package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.compiler.Util.capFirst;
import static xuml.tools.jaxb.compiler.Util.lowerFirst;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

public class ClassWriter {
	private String className;
	private final List<String> classAnnotations = Lists.newArrayList();
	private final List<Member> members = Lists.newArrayList();
	private final List<Method> methods = Lists.newArrayList();

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
			boolean addGetter) {
		members.add(new Member(name, type, addSetter, addGetter));
		return this;
	}

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
			out.format("    private %s %s;\n", addType(member.type),
					lowerFirst(member.name));
		}
		out.format("\n");

		for (Member member : members) {
			if (member.addGetter) {
				out.format("    public %s  get%s() {\n", addType(member.type),
						capFirst(member.name));
				out.format("        return %s;\n", lowerFirst(member.name));
				out.format("    }\n\n");
			}

			if (member.addSetter) {
				out.format("    public void set%s(%s %s) {\n",
						capFirst(member.name), addType(member.type),
						lowerFirst(member.name));
				out.format("        this.%1$s=%1$s;\n", lowerFirst(member.name));
				out.format("    }\n\n");
			}
		}

		out.format("}");
		out.close();
		return bytes.toString();
	}

	private String addType(Type type) {
		String result = addType(type.getBase());
		for (Type t : type.getGenerics())
			addType(type);
		return result;
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

	private static class Member {
		private final String name;
		private final Type type;
		private final boolean addSetter;
		private final boolean addGetter;

		public Member(String name, Type type, boolean addSetter,
				boolean addGetter) {
			super();
			this.name = name;
			this.type = type;
			this.addSetter = addSetter;
			this.addGetter = addGetter;
		}
	}

}
