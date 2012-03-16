package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import xuml.tools.jaxb.compiler.ClassInfo.Mult;
import xuml.tools.jaxb.compiler.ClassInfo.MyEvent;
import xuml.tools.jaxb.compiler.ClassInfo.MyIndependentAttribute;
import xuml.tools.jaxb.compiler.ClassInfo.MyParameter;
import xuml.tools.jaxb.compiler.ClassInfo.MyReferenceMember;
import xuml.tools.jaxb.compiler.ClassInfo.MySubclassRole;
import xuml.tools.jaxb.compiler.ClassInfo.MyTransition;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class ClassWriter2 {

	private static final String BEHAVIOUR_COMMENT = "All actions like onEntry actions and defined operations are performed by this Behaviour class.";
	private static final String STATE_COMMENT = "For internal use only by the state machine but is persisted by the jpa provider.";
	private static final String NO_IDENTIFIERS = "no identifiers";
	private final ClassInfo info;

	public ClassWriter2(ClassInfo info) {
		this.info = info;
	}

	public String generate() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		writeClassJavadoc(out, info);
		writeClassAnnotation(out, info);
		writeClassDeclaration(out, info);
		writeConstructors(out, info);
		writeIdMember(out, info);
		writeNonIdIndependentAttributeMembers(out, info);
		writeStateMember(out, info);
		writeIdGetterAndSetter(out, info);
		writeNonIdIndependentAttributeGettersAndSetters(out, info);
		writeReferenceMembers(out, info);
		writeStateGetterAndSetter(out, info);
		writeStates(out, info);
		writeEvents(out, info);

		writeClassClose(out);
		ByteArrayOutputStream headerBytes = new ByteArrayOutputStream();
		PrintStream header = new PrintStream(headerBytes);
		writePackage(header, info);
		writeImports(header, info);
		out.close();
		header.close();
		return headerBytes.toString() + bytes.toString();
	}

	private boolean isRelationship(MyReferenceMember ref, Mult here, Mult there) {
		return ref.getThisMult().equals(here)
				&& ref.getThatMult().equals(there);
	}

	private void writeReferenceMembers(PrintStream out, ClassInfo info) {
		for (MyReferenceMember ref : info.getReferenceMembers()) {
			jd(out, ref.getThisMult() + " " + info.getJavaClassSimpleName()
					+ " " + ref.getThatVerbClause() + " " + ref.getThatMult()
					+ " " + ref.getSimpleClassName(), "    ");
			if (isRelationship(ref, Mult.ONE, Mult.ZERO_ONE)) {
				info.addType(OneToOne.class);
				info.addType(FetchType.class);
				out.format(
						"    @OneToOne(mappedBy=\"%s\",fetch=FetchType.LAZY,targetEntity=%s.class)\n",
						ref.getThisName(), info.addType(ref.getFullClassName()));
				writeField(out, ref);
			} else if (isRelationship(ref, Mult.ZERO_ONE, Mult.ONE)) {
				info.addType(OneToOne.class);
				info.addType(FetchType.class);
				info.addType(JoinColumn.class);
				info.addType(CascadeType.class);
				out.format(
						"    @OneToOne(targetEntity=%s.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY\n",
						info.addType(ref.getFullClassName()));
				out.format("    @JoinColumn(name=\"%s\",nullable=false)\n",
						ref.getOtherColumnName());
				writeField(out, ref);
			} else if (isRelationship(ref, Mult.ONE, Mult.MANY)) {
				info.addType(OneToMany.class);
				info.addType(CascadeType.class);
				info.addType(FetchType.class);
				out.format(
						"    @OneToMany(mappedBy=\"%s\",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=%s.class)\n",
						ref.getThisName(), info.addType(ref.getFullClassName()));
				writeMultipleField(out, ref);
			} else if (isRelationship(ref, Mult.MANY, Mult.ONE)) {
				info.addType(ManyToOne.class);
				info.addType(FetchType.class);
				info.addType(JoinColumn.class);
				out.format(
						"    @ManyToOne(targetEntity=%s.class,fetch=FetchType.LAZY)\n",
						ref.getSimpleClassName());
				out.format("    @JoinColumn(name=\"%s\",nullable=false)\n",
						ref.getOtherColumnName());
				writeField(out, ref);
			} else if (isRelationship(ref, Mult.ONE, Mult.ONE_MANY)) {
				info.addType(OneToMany.class);
				info.addType(FetchType.class);
				info.addType(JoinColumn.class);
				info.addType(CascadeType.class);
				out.format(
						"    @OneToMany(mappedBy=\"%s\",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=%s.class",
						ref.getThisName(), info.addType(ref.getFullClassName()));
				writeMultipleField(out, ref);
			} else if (isRelationship(ref, Mult.ONE_MANY, Mult.ONE)) {
				info.addType(ManyToOne.class);
				info.addType(JoinColumn.class);
				out.format("    @ManyToOne(targetEntity=%s)\n",
						info.addType(ref.getFullClassName()));
				out.format("    @JoinColumn(name=\"%s\",nullable=false)\n",
						ref.getOtherColumnName());
				writeField(out, ref);
			} else if (isRelationship(ref, Mult.ZERO_ONE, Mult.ZERO_ONE)) {
				if (info.getJavaClassSimpleName().compareTo(
						ref.getSimpleClassName()) < 0) {
					// primary
					info.addType(OneToOne.class);
					info.addType(FetchType.class);
					out.format(
							"    @OneToOne(mappedBy=\"%s\",fetch=FetchType.LAZY,targetEntity=%s.class)\n",
							ref.getThisName(),
							info.addType(ref.getFullClassName()));
				} else {
					// secondary
					info.addType(OneToOne.class);
					info.addType(JoinColumn.class);
					info.addType(FetchType.class);
					out.format(
							"    @OneToOne(targetEntity=%s.class,fetch=FetchType.LAZY)\n",
							info.addType(ref.getFullClassName()));
					out.format("    @JoinColumn(name=\"%s\",nullable=true)\n",
							ref.getOtherColumnName());
				}
				writeField(out, ref);
			} else if (isRelationship(ref, Mult.ZERO_ONE, Mult.MANY)) {
				info.addType(OneToMany.class);
				info.addType(CascadeType.class);
				info.addType(FetchType.class);
				out.format(
						"    @OneToMany(mappedBy=\"%s\",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=%s.class)\n",
						ref.getThisName(), info.addType(ref.getFullClassName()));
				writeMultipleField(out, ref);
			}
		}
	}

	private void writeField(PrintStream out, MyReferenceMember ref) {
		out.format("    private %s %s;\n\n",
				info.addType(ref.getFullClassName()), ref.getFieldName());
	}

	private void writeMultipleField(PrintStream out, MyReferenceMember ref) {
		List<Type> types = Lists.newArrayList();
		types.add(new Type(ref.getFullClassName(), null, false));
		out.format("    private %s %s;\n\n",
				info.addType(new Type(Set.class.getName(), types, false)),
				ref.getFieldName());

	}

	private void writeStates(PrintStream out, ClassInfo info2) {
		jd(out,
				"The list of all states from the state machine for this entity.",
				"    ");
		out.format("    private static enum State {\n");
		boolean first = true;
		out.format("        ");
		for (String state : info.getStateNames()) {
			if (!first)
				out.format(",");
			out.format(info.getStateIdentifier(state));
			first = false;
		}
		out.format(";\n");
		out.format("    }\n\n");
	}

	private void writeEvents(PrintStream out, ClassInfo info) {
		List<MyEvent> events = info.getEvents();
		if (events.size() == 0)
			return;

		// create Events static class and each Event declared within
		out.format("    public static class Events {\n\n");
		for (MyEvent event : info.getEvents()) {
			out.format("        public static class %s {\n\n",
					event.getSimpleClassName());

			StringBuilder constructorBody = new StringBuilder();
			for (MyParameter p : event.getParameters()) {
				constructorBody.append("                this."
						+ p.getFieldName() + " = " + p.getFieldName() + ";\n");
			}

			StringBuilder constructor = new StringBuilder();
			constructor.append("            public "
					+ event.getSimpleClassName() + "(");
			for (MyParameter p : event.getParameters()) {
				out.format("            private final %s %s;\n",
						info.addType(p.getType()), p.getFieldName());
				constructor.append(info.addType(p.getType()) + " "
						+ p.getFieldName());
			}
			constructor.append("){\n");
			constructor.append(constructorBody);
			constructor.append("            }\n");
			out.println();
			out.println(constructor);

			// getters
			for (MyParameter p : event.getParameters()) {
				out.format("            public %s get%s(){\n",
						info.addType(p.getType()), upperFirst(p.getFieldName()));
				out.format("                return %s;\n", p.getFieldName());
				out.format("            }\n\n");
			}
			out.format("        }\n");

		}
		out.format("    }\n\n");

		addEventCallMethods(out, info, events);
	}

	private void addEventCallMethods(PrintStream out, ClassInfo info2,
			List<MyEvent> events) {
		// add event call methods
		for (MyEvent event : events) {
			info.addType(Transient.class);
			out.format("    @Transient\n");
			out.format("    public void event(Events.%s event){\n",
					event.getSimpleClassName());

			boolean first = true;
			for (MyTransition transition : info.getTransitions()) {
				// constraint is no event overloading
				if (transition.getEventName().equals(event.getName())) {
					if (first)
						out.format("        if");
					else
						out.format("        else if");
					first = false;
					out.format(" (state.equals(State.%s.toString())){\n",
							info.getStateIdentifier(transition.getFromState()));
					out.format("            state=State.%s.toString();\n",
							info.getStateIdentifier(transition.getToState()));
					out.format("            synchronized(this) {\n");
					out.format("                behaviour.onEntry(event);\n");
					out.format("            }\n");
					out.format("        }\n");
				}
			}

		}
		out.format("    }\n\n");

	}

	private void writeNonIdIndependentAttributeGettersAndSetters(
			PrintStream out, ClassInfo info2) {
		for (MyIndependentAttribute attribute : info
				.getNonIdIndependentAttributeMembers()) {
			writeIndependentAttributeGetterAndSetter(out, attribute);
		}
	}

	private void writeNonIdIndependentAttributeMembers(PrintStream out,
			ClassInfo info) {
		for (MyIndependentAttribute attribute : info
				.getNonIdIndependentAttributeMembers()) {
			writeIndependentAttributeMember(out, attribute);
		}
	}

	private void writeIdGetterAndSetter(PrintStream out, ClassInfo info2) {
		writeIndependentAttributeGetterAndSetter(out, info.getPrimaryId());
	}

	private void writeIdMember(PrintStream out, ClassInfo info) {
		info.addType(Id.class);
		jd(out, "Primary key", "    ");
		out.format("    @Id\n");
		writeIndependentAttributeMember(out, info.getPrimaryId());
	}

	private void writeIndependentAttributeMember(PrintStream out,
			MyIndependentAttribute attribute) {
		String type = info.addType(attribute.getType());
		info.addType(Column.class);
		out.format("    @Column(name=\"%s\",nullable=%s)\n",
				attribute.getColumnName(), attribute.isNullable());
		out.format("    private %s %s;\n\n", type, attribute.getFieldName());
	}

	private void writeIndependentAttributeGetterAndSetter(PrintStream out,
			MyIndependentAttribute attribute) {
		String type = info.addType(attribute.getType());
		jd(out, "Returns " + attribute.getFieldName() + ".", "    ");
		out.format("    public %s get%s(){\n", type,
				upperFirst(attribute.getFieldName()));
		out.format("        return %s;\n", attribute.getFieldName());
		out.format("    }\n\n");

		jd(out, "Sets " + attribute.getFieldName() + " to the given value.",
				"    ");
		out.format("    public void set%s(%s %s){\n",
				upperFirst(attribute.getFieldName()), type,
				attribute.getFieldName());
		out.format("        this.%1$s=%1$s;\n", attribute.getFieldName());
		out.format("    }\n\n");
	}

	private void writeStateMember(PrintStream out, ClassInfo info) {
		info.addType(Column.class);
		jd(out, STATE_COMMENT, "    ");
		out.format("    @Column(name=\"state\",nullable=false)\n");
		out.format("    private String _state;\n\n");
	}

	private void writeStateGetterAndSetter(PrintStream out, ClassInfo info) {
		jd(out, STATE_COMMENT, "    ");
		out.format("    public String getState(){\n");
		out.format("        return _state;\n");
		out.format("    }\n\n");
		jd(out, STATE_COMMENT, "    ");
		out.format("    private void setState(String state){\n");
		out.format("        this._state= state;\n");
		out.format("    }\n\n");
	}

	private void writeConstructors(PrintStream out, ClassInfo info) {
		// constructor
		if (info.getOperations().size() > 0 || info.getEvents().size() > 0) {
			String factoryTypeName = info.addType(info
					.getBehaviourFactoryFullClassName());
			jd(out, BEHAVIOUR_COMMENT, "    ");
			String behaviourTypeName = info.addType(info
					.getBehaviourFullClassName());
			out.format("    private %s behaviour;\n\n", behaviourTypeName);

			jd(out, "Constructor using BehaviourFactory", "    ");
			out.format("    public %s(%s behaviourFactory){\n",
					info.getJavaClassSimpleName(), factoryTypeName);
			out.format("        this.behaviour = behaviourFactory.create(this);\n");
			out.format("    }\n\n");
		}
		jd(out, "No argument constructor required by JPA.", "    ");
		out.format("    public %s(){\n", info.getJavaClassSimpleName());
		String behaviourSingleton = info.addType(info
				.getBehaviourSingletonFullClassName());
		out.format("        this(%s.get(%s);\n", behaviourSingleton,
				info.getBehaviourFactorySimpleName());
		out.format("    }\n\n");
	}

	private void writeClassClose(PrintStream out) {
		out.format("}");
	}

	private void writeClassDeclaration(PrintStream out, ClassInfo info) {
		String extension;
		if (info.isSubclass()) {
			MySubclassRole subclass = info.getSubclassRole();
			extension = "extends "
					+ info.addType(subclass.getSuperclassJavaFullClassName());
		} else
			extension = "";
		out.format("public class %s %s{\n\n", info.getJavaClassSimpleName(),
				extension);
	}

	private void writeClassAnnotation(PrintStream out, ClassInfo info) {
		info.addType(Entity.class);
		info.addType(Table.class);
		out.format("@Entity\n");
		List<List<String>> uniqueConstraints = info
				.getUniqueConstraintColumnNames();
		Preconditions.checkState(uniqueConstraints.size() > 0, NO_IDENTIFIERS);
		if (uniqueConstraints.size() > 1) {
			info.addType(UniqueConstraint.class);
			out.format("@Table(schema=\"%s\",name=\"%s\",\n", info.getSchema(),
					info.getTable());
			StringBuilder s = new StringBuilder();
			for (List<String> list : uniqueConstraints) {
				if (s.length() > 0)
					s.append(",\n");
				s.append("        @UniqueConstraint(columnNames={"
						+ getCommaDelimitedQuoted(list) + "}");
			}
			out.format("    uniqueConstraints={\n");
			out.format("%s})\n", s);
		}
		if (info.isSuperclass()) {
			info.addType(Inheritance.class);
			info.addType(InheritanceType.class);
			info.addType(DiscriminatorColumn.class);
			info.addType(DiscriminatorType.class);
			out.format("@Inheritance(strategy = InheritanceType.JOINED)\n");
			out.format("//DiscriminatorColumn annotation is ignored by Hibernate but may be used\n");
			out.format("//by other JPA providers. See https://hibernate.onjira.com/browse/ANN-140\n");
			out.format("@DiscriminatorColumn(name = \"DISCRIMINATOR\", discriminatorType = DiscriminatorType.STRING, length = 255)\n");
		}
		if (info.isSubclass()) {
			MySubclassRole subclass = info.getSubclassRole();
			info.addType(DiscriminatorValue.class);
			out.format("@DiscriminatorValue(\"%s\")\n",
					subclass.getDiscriminatorValue());
		}
	}

	private void writePackage(PrintStream out, ClassInfo info) {
		out.format("package %s;\n\n", info.getPackage());
	}

	private void writeImports(PrintStream out, ClassInfo info) {
		TypeRegister types = info.getTypeRegister();
		for (String fullClassName : types.getImports()) {
			out.format("import %s;\n", fullClassName);
		}
		out.println();
	}

	private void writeClassJavadoc(PrintStream out, ClassInfo info) {
		jd(out, info.getClassJavadoc(), "");
	}

	// ///////////////////////////////////////
	// Utils
	// ///////////////////////////////////////

	private void jd(PrintStream out, String comment, String indent) {
		out.format("%s/**\n", indent);
		for (String line : comment.split("\n")) {
			out.format("%s * %s\n", indent, line);
		}
		out.format("%s */\n", indent);
	}

	private String getDelimited(Collection<String> items, String delimiter,
			String itemBefore, String itemAfter) {
		StringBuilder s = new StringBuilder();
		for (String item : items) {
			if (s.length() > 0)
				s.append(delimiter);
			s.append(itemBefore);
			s.append(item);
			s.append(itemAfter);
		}
		return s.toString();
	}

	private String getCommaDelimitedQuoted(List<String> items) {
		return getDelimited(items, ",", "\"", "\"");
	}

}
