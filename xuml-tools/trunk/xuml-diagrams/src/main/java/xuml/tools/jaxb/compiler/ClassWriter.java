package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.lowerFirst;
import static xuml.tools.jaxb.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

import xuml.metamodel.jaxb.Event;
import xuml.tools.jaxb.Util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

public class ClassWriter {
	private String pkg;
	private String className;
	private final List<String> classAnnotations = Lists.newArrayList();
	private final List<Member> members = Lists.newArrayList();
	private final List<Method> methods = Lists.newArrayList();
	private List<Event> events;

	/**
	 * Full type name -> abbr (if possible)
	 */
	private final BiMap<String, String> types = HashBiMap.create();

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
		return this;
	}

	@Override
	public String toString() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(bytes);
		out.format("public class %s {\n", className);
		out.format("\n");

		for (Member member : members) {
			out.format("    /**\n");
			out.format("     * %s\n", member.getComment());
			out.format("     */\n");
			out.format("    private %s %s;\n", addType(member.getType()),
					lowerFirst(member.getName()));
		}
		out.format("\n");

		for (Member member : members) {
			if (member.isAddGetter()) {
				out.format("    /**\n");
				out.format("     * Returns %s\n", member.getComment());
				out.format("     */\n");
				out.format("    public %s  get%s() {\n",
						addType(member.getType()), upperFirst(member.getName()));
				out.format("        return %s;\n", lowerFirst(member.getName()));
				out.format("    }\n\n");
			}

			if (member.isAddSetter()) {
				out.format("    /**\n");
				out.format("     * Sets %s\n", member.getComment());
				out.format("     */\n");
				out.format("    public void set%s(%s %s) {\n",
						upperFirst(member.getName()),
						addType(member.getType()), lowerFirst(member.getName()));
				out.format("        this.%1$s=%1$s;\n",
						lowerFirst(member.getName()));
				out.format("    }\n\n");
			}

		}

		for (Event event : events) {
			out.format("    public static class %s {\n",
					Util.upperFirst(event.getName()));
			StringBuilder constructor = new StringBuilder();
			StringBuilder constructorBody = new StringBuilder();
			constructor.append("        public "
					+ Util.upperFirst(event.getName()) + "(");
			for (xuml.metamodel.jaxb.Parameter p : event.getParameter()) {
				out.format("        private final %s %s;\n",
						Util.upperFirst(p.getType()),
						Util.lowerFirst(p.getName()));
				constructor.append(Util.upperFirst(p.getType()) + " "
						+ Util.lowerFirst(p.getName()));
				constructorBody.append("            this."
						+ Util.lowerFirst(p.getName()) + " = "
						+ Util.lowerFirst(p.getName()) + ";\n");
			}
			constructor.append("){\n");
			constructor.append(constructorBody);
			constructor.append("        }\n");
			// getters
			for (xuml.metamodel.jaxb.Parameter p : event.getParameter()) {
				out.format("        public %s get%s(){\n",
						Util.upperFirst(p.getType()),
						Util.upperFirst(p.getName()));
				out.format("        }\n\n");
			}
			out.println(constructor);
			out.format("    }\n\n");

		}

		for (Event event : events) {
			out.format("    public void event(%s event){\n",
					Util.upperFirst(event.getName()));
			out.format("        //TODO state checks and onEntry calls\n");
			out.format("    }\n\n");
		}

		for (Method method : methods) {
			out.format("    public %s %s(){\n", addType(method.getType()),
					method.getName());

			out.format("    }\n\n");
		}

		out.format("}");
		out.close();
		StringBuilder header = new StringBuilder();
		header.append("package " + pkg + ";\n\n");
		for (String t : types.keySet())
			header.append("import " + t + ";\n");
		return header.toString() + "\n\n" + bytes.toString();
	}

	private String addType(Type type) {
		StringBuilder result = new StringBuilder(addType(type.getBase()));
		StringBuilder typeParams = new StringBuilder();
		for (Type t : type.getGenerics()) {
			String typeParameter = addType(t);
			if (typeParams.length() > 0)
				typeParams.append(",");
			typeParams.append(typeParameter);
		}
		if (typeParams.length() > 0) {
			result.append("<");
			result.append(typeParams);
			result.append(">");
		}
		return result.toString();
	}

	private String addType(String type) {
		String abbr = types.get(type);
		if (abbr != null)
			return abbr;
		else {
			int i = type.lastIndexOf(".");
			if (i >= 0) {
				String last = type.substring(i + 1);
				if (types.inverse().get(last) != null)
					return type;
				else {
					types.put(type, last);
					return last;
				}
			} else
				return type;
		}
	}

	public void setPackage(String string) {
		this.pkg = string;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
