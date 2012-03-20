package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.compiler.Util.lowerFirst;
import static xuml.tools.jaxb.compiler.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.io.FileUtils;

import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Event;
import xuml.metamodel.jaxb.Operation;
import xuml.metamodel.jaxb.System;

import com.google.common.collect.Lists;

public class CodeGeneratorJava {

	private final System system;
	private final Map<String, String> domainPackageNames;
	private final Lookups lookups;
	private final String contextPackageName;
	private final File resourcesDirectory;

	public CodeGeneratorJava(xuml.metamodel.jaxb.System system,
			Map<String, String> domainPackageNames, String contextPackageName,
			File resourcesDirectory) {
		this.system = system;
		this.domainPackageNames = domainPackageNames;
		this.contextPackageName = contextPackageName;
		this.resourcesDirectory = resourcesDirectory;
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

		createPersistenceXml(system.getClazz(), resourcesDirectory);

		log("finished generation");
	}

	private void createPersistenceXml(List<Class> clazz, File resourcesDirectory) {
		List<String> list = Lists.newArrayList();
		for (Class cls : clazz) {
			ClassInfo info = createClassInfo(cls);
			list.add(info.getClassFullName());
		}
		String xml = new PersistenceXmlWriter().generate(list);
		try {
			File file = new File(resourcesDirectory, "META-INF/persistence.xml");
			file.getParentFile().mkdirs();
			FileUtils.write(file, xml);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void createContext(File destination) {
		TypeRegister types = new TypeRegister();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		types.addType(EntityManagerFactory.class);
		out.format("package %s;\n\n", contextPackageName);
		out.format("IMPORTS_HERE\n");
		out.format("public class Context {\n\n");
		out.format("    private static EntityManagerFactory emf;\n\n");
		out.format("    public static EntityManagerFactory getEntityManagerFactory() {\n");
		out.format("        return emf;\n");
		out.format("    }\n\n");
		out.format("    public static void setEntityManagerFactory(EntityManagerFactory value){\n");
		out.format("        emf = value;\n");
		out.format("    }\n");
		for (Class cls : system.getClazz()) {
			ClassInfo info = createClassInfo(cls);
			String behaviourFactory = types.addType(info
					.getBehaviourFactoryFullName());
			out.format("    private static %s %s;\n\n", behaviourFactory,
					info.getBehaviourFactoryFieldName());
			out.format("    public static void set%s(%s factory){\n",
					info.getBehaviourFactorySimpleName(), behaviourFactory);
			out.format("        %s=factory;\n",
					info.getBehaviourFactoryFieldName());
			out.format("    }\n\n");
			out.format("    public static %s get%s(){\n", behaviourFactory,
					info.getBehaviourFactorySimpleName());
			out.format("        return %s;\n",
					info.getBehaviourFactoryFieldName());
			out.format("    }\n\n");
		}

		out.format("}\n");
		out.close();

		File file = new File(destination, contextPackageName.replace(".", "/")
				+ "/Context.java");
		String java = bytes.toString().replace("IMPORTS_HERE",
				types.getImports());
		writeToFile(java.getBytes(), file);

	}

	private void createImplementation(Class cls, File destination) {
		ClassWriter w = new ClassWriter(createClassInfo(cls));
		String java = w.generate();
		File file = new File(destination, getClassFilename(cls));
		writeToFile(java.getBytes(), file);
	}

	private ClassInfo createClassInfo(Class cls) {
		return new ClassInfoFromJaxb(cls, domainPackageNames, lookups,
				contextPackageName);
	}

	private void createObjectFactory(System system2, File destination) {

	}

	private void log(String message) {
		java.lang.System.out.println(message);
	}

	private void createBehaviourInterface(Class cls, File destination) {

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
					+ ".Events." + upperFirst(event.getName())));
			out.format("    void onEntry(%s event);\n\n", typeName);
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
		ClassInfo info = createClassInfo(cls);
		String java = "package " + getPackage(cls) + ".behaviour;\n\n";
		java += "IMPORTS_HERE\n";
		java += "public interface " + cls.getName() + "BehaviourFactory {\n\n";
		types.addType(getFullClassName(cls) + "Behaviour");
		types.addType(getFullClassName(cls));
		java += "    " + getClassJavaSimpleName(cls) + "Behaviour create("
				+ info.addType(info.getClassFullName()) + " cls);\n";
		java += "}";
		java = java.replace("IMPORTS_HERE", info.getImports());
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