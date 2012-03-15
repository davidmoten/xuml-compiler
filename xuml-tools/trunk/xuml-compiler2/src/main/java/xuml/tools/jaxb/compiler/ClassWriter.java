package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.lowerFirst;
import static xuml.tools.jaxb.Util.toJavaConstantIdentifier;
import static xuml.tools.jaxb.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

import xuml.metamodel.jaxb.Event;
import xuml.metamodel.jaxb.Operation;
import xuml.metamodel.jaxb.State;
import xuml.metamodel.jaxb.Transition;
import xuml.tools.jaxb.compiler.CodeGeneratorJava.AttributeInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ClassWriter {
	private String pkg;
	private String className;
	private final List<String> classAnnotations = Lists.newArrayList();
	private final List<Member> members = Lists.newArrayList();
	private final List<Method> methods = Lists.newArrayList();
	private List<Event> events;
	private List<State> states;
	private List<Transition> transitions;
	private List<Operation> operations;
	private final TypeRegister types = new TypeRegister();
	private Set<AttributeInfo> ids;
	private final PersistenceDetails persistence;

	public ClassWriter(PersistenceDetails persistence) {
		this.persistence = persistence;
	}

	public ClassWriter setClassName(String s) {
		className = s;
		return this;
	}

	public ClassWriter addClassAnnotation(String s) {
		classAnnotations.add(s);
		return this;
	}

	public ClassWriter addMember(String name, Type type, boolean addSetter,
			boolean addGetter, String comment) {
		types.addType(type);
		members.add(new Member(name, type, addSetter, addGetter, comment));
		return this;
	}

	/**
	 * @param name
	 * @param returnType
	 * @param parameters
	 * @return
	 */
	public ClassWriter addMethod(String name, Type returnType,
			List<Parameter> parameters) {
		methods.add(new Method(name, returnType, parameters));
		types.addType(returnType);
		for (Parameter p : parameters)
			types.addType(p.getType());
		return this;
	}

	public ClassWriter addType(Type type) {
		types.addType(type);
		return this;
	}

	public ClassWriter addType(java.lang.Class<?> cls) {
		addType(new Type(cls.getName(), null, false));
		return this;
	}

	@Override
	public String toString() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(bytes);
		out.format("/**\n");
		out.format(" * Generated by xuml-compiler %s.\n", new Date());
		out.format(" */\n");
		for (String ann : classAnnotations)
			out.println(ann);
		out.format("public class %s {\n", className);
		out.format("\n");

		// constructor
		if (operations.size() > 0 || events.size() > 0) {
			types.addType(pkg + ".behaviour." + className + "BehaviourFactory");
			types.addType(pkg + ".behaviour." + className + "Behaviour");
			out.format(
					"    public %1$s(%1$sBehaviourFactory behaviourFactory){\n",
					className);
			out.format(
					"        this.behaviour = behaviourFactory.create(this);\n",
					className);
			out.format("    }\n\n");

			out.format("    /**\n");
			out.format("     * All actions like onEntry actions and defined operations are performed by this Behaviour class.\n");
			out.format("     */\n");
			out.format("    private final %sBehaviour behaviour;\n\n",
					className);

			out.format("    /**\n");
			out.format("     * For internal use only by the state machine but is persisted by the jpa provider.");
			out.format("     */\n");
			out.format("    private String _state;\n\n");

		}

		Set<String> idAttributes = Sets.newHashSet();
		for (AttributeInfo a : ids)
			idAttributes.add(a.attribute.getName().toUpperCase());

		// members
		for (Member member : members) {
			if (!idAttributes.contains(member.getName().toUpperCase())) {
				out.format("    /**\n");
				out.format("     * %s\n", member.getComment());
				out.format("     */\n");
				out.format("    private %s %s;\n\n",
						types.addType(member.getType()),
						lowerFirst(member.getName()));
			}
		}

		// ids
		if (ids.size() > 1) {
			addType(Embeddable.class);
			addType(Serializable.class);
			addType(Column.class);
			addType(EmbeddedId.class);
			out.format("    @Embeddable\n");
			out.format("    public static class PrimaryKey implements Serializable {\n\n");
			for (AttributeInfo a : ids) {
				out.format("        @Column(name=\"%s\", nullable=false)\n",
						persistence.getColumnName(a.cls, a.attribute));
				out.format("        private %s %s;\n\n", types.addType(a.type),
						lowerFirst(a.attribute.getName()));
			}
			for (AttributeInfo a : ids) {
				out.format("        public %s get%s(){\n",
						types.addType(a.type),
						upperFirst(a.attribute.getName()));
				out.format("            return %s;\n",
						lowerFirst(a.attribute.getName()));
				out.format("        }\n\n");
			}

			out.format("    }\n\n");

			out.format("    @EmbeddedId\n");
			out.format("    private PrimaryKey id;\n");

			out.format("    public PrimaryKey getId(){\n");
			out.format("        return id;\n");
			out.format("    }\n\n");

		} else {
			if (ids.size() == 0)
				throw new RuntimeException("class '" + className
						+ "' does not have an identifier: ");
			idAttributes.add(ids.iterator().next().attribute.getName());
		}

		// state member
		out.format("\n");

		out.format("    /**\n");
		out.format("     * For internal use only by the state machine but is persisted by the jpa provider.");
		out.format("     */\n");
		out.format("    public String getState(){\n");
		out.format("        return _state;\n");
		out.format("    }\n\n");

		out.format("    /**\n");
		out.format("     * For internal use only by the state machine but is persisted by the jpa provider.");
		out.format("     */\n");
		out.format("    private void setState(String state){\n");
		out.format("        this._state= state;\n");
		out.format("    }\n\n");

		// add member getters and setters
		for (Member member : members) {
			if (!idAttributes.contains(member.getName().toUpperCase())) {
				if (member.isAddGetter()) {
					out.format("    /**\n");
					out.format("     * Returns %s\n", member.getComment());
					out.format("     */\n");
					out.format("    public %s get%s() {\n",
							types.addType(member.getType()),
							upperFirst(member.getName()));
					out.format("        return %s;\n",
							lowerFirst(member.getName()));
					out.format("    }\n\n");
				}

				if (member.isAddSetter()) {
					out.format("    /**\n");
					out.format("     * Sets %s\n", member.getComment());
					out.format("     */\n");
					out.format("    public void set%s(%s %s) {\n",
							upperFirst(member.getName()),
							types.addType(member.getType()),
							lowerFirst(member.getName()));
					out.format("        this.%1$s=%1$s;\n",
							lowerFirst(member.getName()));
					out.format("    }\n\n");
				}
			}
		}

		// add state constants
		if (!states.isEmpty()) {
			out.format("    //////////////////////////////////////////////\n");
			out.format("    //                     States                       //\n");
			out.format("    //////////////////////////////////////////////\n\n");
		}
		for (State state : states) {
			out.format("    private static final String STATE_%s = \"%s\";\n",
					getStateIdentifier(state.getName()), state.getName());
		}
		out.println();

		// add event classes
		if (!events.isEmpty()) {
			out.format("    //////////////////////////////////////////////\n");
			out.format("    //                     Events                      //\n");
			out.format("    //////////////////////////////////////////////\n\n");
		}

		for (Event event : events) {
			out.format("    public static class %s {\n\n",
					upperFirst(event.getName()));

			StringBuilder constructorBody = new StringBuilder();
			for (xuml.metamodel.jaxb.Parameter p : event.getParameter()) {
				constructorBody.append("            this."
						+ lowerFirst(p.getName()) + " = "
						+ lowerFirst(p.getName()) + ";\n");
			}

			StringBuilder constructor = new StringBuilder();
			constructor.append("        public " + upperFirst(event.getName())
					+ "(");
			for (xuml.metamodel.jaxb.Parameter p : event.getParameter()) {
				out.format("        private final %s %s;\n",
						upperFirst(p.getType()), lowerFirst(p.getName()));
				constructor.append(upperFirst(p.getType()) + " "
						+ lowerFirst(p.getName()));
			}
			constructor.append("){\n");
			constructor.append(constructorBody);
			constructor.append("        }\n");
			out.println();
			out.println(constructor);

			// getters
			for (xuml.metamodel.jaxb.Parameter p : event.getParameter()) {
				out.format("        public %s get%s(){\n",
						upperFirst(p.getType()), upperFirst(p.getName()));
				out.format("            return %s;\n", lowerFirst(p.getName()));
				out.format("        }\n\n");
			}
			out.format("    }\n\n");

		}

		// add event call methods
		for (Event event : events) {
			out.format("    public void event(%s event){\n",
					upperFirst(event.getName()));

			boolean first = true;
			for (Transition transition : transitions) {
				// constraint is no event overloading
				if (transition.getEvent().equals(event.getName())) {
					if (first)
						out.format("        if");
					else
						out.format("        else if");
					first = false;
					out.format(" (state.equals(%s)){\n",
							getStateIdentifier(transition.getFrom()));
					out.format("            state=%s;\n",
							getStateIdentifier(transition.getTo()));
					out.format("            synchronized(this) {\n");
					out.format("                behaviour.onEntry(event);\n");
					out.format("            }\n");
					out.format("        }\n");
				}
			}

			out.format("    }\n\n");
		}

		// don't need this?
		for (Method method : methods) {
			out.format("    public %s %s(){\n",
					types.addType(method.getType()), method.getName());

			out.format("    }\n\n");
		}

		out.format("}");
		out.close();
		StringBuilder header = new StringBuilder();
		header.append("package " + pkg + ";\n\n");
		for (String t : types.getImports())
			header.append("import " + t + ";\n");
		return header.toString() + "\n" + bytes.toString();
	}

	private String getStateIdentifier(String state) {
		return toJavaConstantIdentifier(state);
	}

	public void setPackage(String string) {
		this.pkg = string;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void setIds(Set<AttributeInfo> ids) {
		this.ids = ids;
	}

}
