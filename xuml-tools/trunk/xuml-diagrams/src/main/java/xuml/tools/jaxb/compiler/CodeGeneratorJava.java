package xuml.tools.jaxb.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.IndependentAttributeType;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.RelationshipEnd;
import xuml.metamodel.jaxb.System;
import xuml.tools.jaxb.compiler.ClassWriter.Type;

public class CodeGeneratorJava {

	private final System system;
	private final Map<String, String> domainPackageNames;
	private final Lookups lookups;

	public CodeGeneratorJava(xuml.metamodel.jaxb.System system,
			Map<String, String> domainPackageNames) {
		this.system = system;
		this.domainPackageNames = domainPackageNames;
		// create maps for classes, relationships, generalizations
		lookups = new Lookups(system);
	}

	public void generate(File destination) {

		for (Class cls : system.getClazz()) {
			// create classes (impls)
			createImplementation(cls, destination);
			// create behaviour interfaces
			createBehaviourInterface(cls, destination);
		}

		// create object factory
		createObjectFactory(system, destination);
	}

	private void createObjectFactory(System system, File destination) {

	}

	private void createImplementation(Class cls, File destination) {
		// add getters and setters, operations, event methods, static Search
		// class instance, validators
		File file = new File(destination, getClassFilename(cls));
		createDirectories(file);

		ClassWriter w = new ClassWriter();
		w.setClassName(getClassJavaSimpleName(cls));
		for (JAXBElement<? extends Attribute> base : cls.getAttributeBase()) {
			if (base.getValue() instanceof IndependentAttribute) {
				IndependentAttribute a = (IndependentAttribute) base.getValue();
				w.addMember(a.getName(), new Type(toJavaType(a.getType()),
						null, false), true, true);
			}
		}

		for (Relationship rel : system.getRelationship()) {
			Class class1 = getClassFromRelationshipEnd(rel.getClass1());
			Class class2 = getClassFromRelationshipEnd(rel.getClass1());
			if (class1 == cls || class2 == cls) {
				final RelationshipEnd meEnd;
				final RelationshipEnd otherEnd;
				final Class me;
				final Class other;
				if (class1 == cls) {
					meEnd = rel.getClass1();
					otherEnd = rel.getClass2();
					me = class1;
					other = class2;
				} else {
					meEnd = rel.getClass2();
					otherEnd = rel.getClass1();
					me = class2;
					other = class1;
				}
				String returnType;
				if (otherEnd.getMultiplicity().equals(Multiplicity.MANY)
						|| otherEnd.getMultiplicity().equals(
								Multiplicity.ONE_MANY)) {
					Attribute otherAttribute = lookups.getAttribute(
							other.getDomain(), other.getName(),
							otherEnd.getName());
					// Type t = getType(other, otherAttribute);
				}
			}
		}

		writeToFile(w.toString().getBytes(), file);
	}

	private Type getType(Class cls, Attribute a) {
		if (a instanceof IndependentAttribute) {
			return new Type(toJavaType(((IndependentAttribute) a).getType()),
					null, false);
		} else if (a instanceof ReferentialAttribute) {
			ReferentialAttribute r = (ReferentialAttribute) a;
			// Relationship rel = lookups.getRelationship(cls.getDomain(),
			// r.getRelationship());
			// Class other = getOtherClass(cls, rel);
			throw new RuntimeException("not implemented");

		} else
			throw new RuntimeException("unexpected attribute type "
					+ a.getClass().getName());
	}

	private Class getOtherClass(Class cls, Relationship r) {
		if (is(cls, r.getClass1()))
			return lookups.getClass(r.getClass2());
		else
			return cls;
	}

	private Class getClassFromRelationshipEnd(RelationshipEnd e) {
		return lookups.getClass(e.getDomain(), e.getName());
	}

	private static String toJavaType(IndependentAttributeType type) {
		if (type.equals(IndependentAttributeType.ARBITRARY_ID)) {
			return "Long";
		} else if (type.equals(IndependentAttributeType.BOOLEAN)) {
			return "Boolean";
		} else if (type.equals(IndependentAttributeType.DATE)) {
			return "String";
		} else if (type.equals(IndependentAttributeType.DECIMAL)) {
			return "BigDecimal";
		} else if (type.equals(IndependentAttributeType.INTEGER)) {
			return "BigInteger";
		} else if (type.equals(IndependentAttributeType.STRING)) {
			return "String";
		} else if (type.equals(IndependentAttributeType.TIMESTAMP)) {
			return "java.util.Date";
		} else
			throw new RuntimeException("no java type implemented for " + type);
	}

	private void createBehaviourInterface(Class cls, File destination) {
		// add operations, performOnEntry methods
	}

	// ----------------------------------------
	// Utility Methods
	// -----------------------------------------

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

	private String getClassFilename(Class cls) {
		return getFullClassName(cls).replace(".", "/") + ".java";
	}

	// ----------------------------------------
	// Static Utility Methods
	// -----------------------------------------

	private static boolean is(Class c, RelationshipEnd e) {
		return c.getDomain().equals(e.getDomain())
				&& c.getName().equals(e.getName());
	}

	private static void writeToFile(byte[] bytes, File file) {
		try {
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

	private static void createDirectories(File file) {
		file.getParentFile().mkdirs();
	}

	private static PrintWriter createPrintWriter(OutputStream os) {
		return new PrintWriter(os);
	}

}
