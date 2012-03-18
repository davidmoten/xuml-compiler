package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.lowerFirst;
import static xuml.tools.jaxb.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Event;
import xuml.metamodel.jaxb.Operation;
import xuml.metamodel.jaxb.System;

public class CodeGeneratorJava {

	private final System system;
	private final Map<String, String> domainPackageNames;
	private final Lookups lookups;
	private final PersistenceDetails persistence;
	private final String contextPackageName;

	public CodeGeneratorJava(xuml.metamodel.jaxb.System system,
			Map<String, String> domainPackageNames,
			PersistenceDetails persistence, String contextPackageName) {
		this.system = system;
		this.domainPackageNames = domainPackageNames;
		this.contextPackageName = contextPackageName;
		this.persistence = persistence;
		// create maps for classes, relationships, generalizations
		lookups = new Lookups(system);
	}

	public void generate(File destination) {

		for (Class cls : system.getClazz()) {
			// create classes (impls)
			createImplementation(cls, destination);
			// create behaviour interfaces
			createBehaviourInterface(cls, destination);
			createBehaviourFactoryInterface(cls, destination);
		}

		createContext(destination);

		// create object factory
		createObjectFactory(system, destination);
		log("finished generation");
	}

	private void createContext(File destination) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		out.format("package %s;\n\n", contextPackageName);
		out.format("import javax.persistence.EntityManagerFactory;\n\n");
		out.format("public class Context {\n\n");
		out.format("    private static EntityManagerFactory emf;\n\n");
		out.format("    public EntityManagerFactory getEntityManagerFactory() {\n");
		out.format("        return emf;\n");
		out.format("    }\n\n");
		out.format("    public void setEntityManagerFactory(EntityManagerFactory value){\n");
		out.format("        emf = value;\n");
		out.format("    }\n");
		out.format("}\n");
		out.close();

		File file = new File(destination, contextPackageName.replace(".", "/")
				+ "/Context.java");
		writeToFile(bytes.toByteArray(), file);

	}

	private void createImplementation(Class cls, File destination) {
		ClassWriter w = new ClassWriter(new ClassInfoFromJaxb(cls,
				domainPackageNames, lookups, contextPackageName));
		String java = w.generate();
		File file = new File(destination, getClassFilename(cls));
		writeToFile(java.getBytes(), file);
	}

	private void createObjectFactory(System system2, File destination) {

	}

	private void log(String message) {
		java.lang.System.out.println(message);
	}

	private void createBehaviourInterface(Class cls, File destination) {

		if (!hasBehaviour(cls))
			return;
		destination.mkdirs();
		// add operations, performOnEntry methods
		File file = new File(destination, getClassBehaviourFilename(cls));

		TypeRegister types = new TypeRegister();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		String pkg = getPackage(cls);
		out.format("public interface %sBehaviour {\n\n", cls.getName());
		for (Event event : cls.getEvent()) {
			String typeName = types.addType(new Type(pkg + "." + cls.getName()
					+ "." + upperFirst(event.getName()), null, false));
			out.format("    void onEntry%s(%s event);\n\n",
					upperFirst(event.getName()), typeName);
		}

		for (Operation op : cls.getOperation()) {
			String returnType;
			if (op.getReturns() == null)
				returnType = "void";
			else
				returnType = op.getReturns();
			StringBuilder params = new StringBuilder();
			for (xuml.metamodel.jaxb.Parameter p : op.getParameter()) {
				if (params.length() > 0)
					params.append(",");
				params.append(types.addType(p.getType()));
				params.append(" ");
				params.append(lowerFirst(p.getName()));
			}

			out.format("    %s %s(%s);\n\n", returnType, op.getName(),
					params.toString());
		}
		out.format("}");
		out.close();
		String java = "package " + pkg + ".behaviour;\n\n";
		java += types.getImports();
		java += "\n";
		String all = java + bytes.toString();
		writeToFile(all.getBytes(), file);
	}

	private void createBehaviourFactoryInterface(Class cls, File destination) {
		TypeRegister types = new TypeRegister();
		if (!hasBehaviour(cls))
			return;
		String java = "package " + getPackage(cls) + ".behaviour;\n\n";
		java += "public interface " + cls.getName() + "BehaviourFactory {\n\n";
		types.addType(getFullClassName(cls) + "Behaviour");
		types.addType(getFullClassName(cls));
		java += "    " + getClassJavaSimpleName(cls) + "Behaviour create("
				+ getClassJavaSimpleName(cls) + " cls);\n";
		java += "}";
		File file = new File(destination, getClassBehaviourFactoryFilename(cls));
		writeToFile(java.getBytes(), file);
	}

	// ----------------------------------------
	// Utility Methods
	// -----------------------------------------
	private String getPackage(Class cls) {
		return domainPackageNames.get(cls.getDomain());
	}

	private String getClassJavaSimpleName(Class cls) {
		return cls.getName().replace(" ", "").replace("-", "");
	}

	private String getFullClassName(Class cls) {
		String packageName = domainPackageNames.get(cls.getDomain());
		if (packageName == null)
			re("no package name specified for  domain '" + cls.getDomain()
					+ "'");
		return packageName + "." + getClassJavaSimpleName(cls);
	}

	private String getClassBehaviourFilename(Class cls) {
		String s = getFullClassName(cls);
		int i = s.lastIndexOf(".");
		if (i == -1)
			s = "behaviour." + s;
		else
			s = s.substring(0, i) + ".behaviour" + s.substring(i);
		return s.replace(".", "/") + "Behaviour.java";
	}

	private String getClassFilename(Class cls) {
		String s = getFullClassName(cls);
		return s.replace(".", "/") + ".java";
	}

	private String getClassBehaviourFactoryFilename(Class cls) {
		String s = getFullClassName(cls);
		int i = s.lastIndexOf(".");
		if (i == -1)
			s = "behaviour." + s;
		else
			s = s.substring(0, i) + ".behaviour" + s.substring(i);
		return s.replace(".", "/") + "BehaviourFactory.java";
	}

	// ----------------------------------------
	// Static Utility Methods
	// -----------------------------------------

	private static boolean hasBehaviour(Class cls) {
		return cls.getEvent().size() > 0 || cls.getOperation().size() > 0;
	}

	private static void writeToFile(byte[] bytes, File file) {
		try {
			file.getParentFile().mkdirs();
			java.lang.System.out.println("writing to " + file);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void re(String string) {
		throw new RuntimeException(string);
	}

}