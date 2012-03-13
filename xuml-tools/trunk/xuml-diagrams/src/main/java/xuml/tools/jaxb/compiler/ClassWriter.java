package xuml.tools.jaxb.compiler;

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

	private static String lowerFirst(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	private static String capFirst(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	private String addType(Type type) {
		String result = addType(type.base);
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
		String name;
		Type type;
		boolean addSetter;
		boolean addGetter;

		public Member(String name, Type type, boolean addSetter,
				boolean addGetter) {
			super();
			this.name = name;
			this.type = type;
			this.addSetter = addSetter;
			this.addGetter = addGetter;
		}
	}

	public static class Type {
		private final String base;
		private final List<Type> generics;
		private final boolean isArray;

		public Type(String base, List<Type> generics, boolean isArray) {
			super();
			this.base = base;
			if (generics != null)
				this.generics = generics;
			else
				this.generics = Lists.newArrayList();
			this.isArray = isArray;
		}

		public String getBase() {
			return base;
		}

		public List<Type> getGenerics() {
			return generics;
		}

		public boolean isArray() {
			return isArray;
		}
	}

}
