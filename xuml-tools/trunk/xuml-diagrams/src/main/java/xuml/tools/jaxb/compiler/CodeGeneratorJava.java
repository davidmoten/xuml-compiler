package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.compiler.Util.capFirst;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.datanucleus.sco.backed.Set;

import xuml.metamodel.jaxb.Association;
import xuml.metamodel.jaxb.AssociationEnd;
import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.IndependentAttributeType;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.Reference;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.System;
import xuml.metamodel.jaxb.ToOneReference;

import com.google.common.collect.Lists;

public class CodeGeneratorJava {

	private static final String UNEXPECTED = "unexpected";
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
			} else if (base.getValue() instanceof ReferentialAttribute) {
				ReferentialAttribute a = (ReferentialAttribute) base.getValue();
				java.lang.System.out.println(cls.getName() + "." + a.getName()
						+ " "
						+ a.getReferenceBase().getValue().getRelationship());
				Type type = getType(cls, a);
				List<Parameter> parameters = Collections.emptyList();
				w.addMethod("get" + capFirst(a.getName()), type, parameters);
			}
		}

		// for (JAXBElement<? extends Relationship> rel : system
		// .getRelationshipBase()) {
		// if (rel.getValue() instanceof Association) {
		// createAssociationMethod(w, cls, (Association) rel.getValue());
		// } else if (rel.getValue() instanceof Generalization) {
		// createGeneralizationMethod(w, cls,
		// (Generalization) rel.getValue());
		// } else
		// unexpected();
		// }

		writeToFile(w.toString().getBytes(), file);
	}

	private Type getType(Class cls, Attribute a) {
		if (a instanceof IndependentAttribute) {
			return new Type(toJavaType(((IndependentAttribute) a).getType()),
					null, false);
		} else if (a instanceof ReferentialAttribute) {
			ReferentialAttribute r = (ReferentialAttribute) a;
			Reference ref = r.getReferenceBase().getValue();
			if (ref instanceof ToOneReference) {
				ToOneReference t = (ToOneReference) ref;
				t.getRelationship();
				Association ass = lookups.getAssociation(cls.getDomain(),
						t.getRelationship());
				if (ass == null)
					throw new RuntimeException("did not find association");
				Class other = getOtherClass(cls, ass);
				AssociationEnd otherEnd = getOtherEnd(cls, ass);
				String otherName = r.getOtherName();
				if (otherName == null)
					otherName = a.getName();
				Attribute otherAttribute = lookups.getAttribute(
						cls.getDomain(), other.getName(), r.getOtherName());
				Type otherType = getType(other, otherAttribute);
				if (otherEnd.getMultiplicity().equals(Multiplicity.MANY)
						|| otherEnd.getMultiplicity().equals(
								Multiplicity.ONE_MANY)) {
					List<Type> types = Lists.newArrayList(otherType);
					return new Type(Set.class.getName(), types, false);
				} else
					return otherType;
			} else {
				throw new RuntimeException(UNEXPECTED);
			}
		} else
			throw new RuntimeException("unexpected attribute type " + a);
	}

	private Class getOtherClass(Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return lookups.getClass(a.getDomain(), a.getClass2().getName());
			else
				return lookups.getClass(a.getDomain(), a.getClass2().getName());
		} else
			throw new RuntimeException(UNEXPECTED);
	}

	private AssociationEnd getOtherEnd(Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return a.getClass2();
			else
				return a.getClass1();
		} else
			throw new RuntimeException(UNEXPECTED);
	}

	private void createAssociationMethod(ClassWriter w, Class cls,
			Association rel) {
		Class class1 = lookups.getClass(rel.getDomain(), rel.getClass1()
				.getName());
		Class class2 = lookups.getClass(rel.getDomain(), rel.getClass2()
				.getName());
		if (class1 == cls || class2 == cls) {
			final AssociationEnd meEnd;
			final AssociationEnd otherEnd;
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
					|| otherEnd.getMultiplicity().equals(Multiplicity.ONE_MANY)) {
				java.lang.System.out.format(
						"looking up rel %s attribute %s,%s,%s",
						rel.getNumber(), other.getDomain(), other.getName(),
						otherEnd.getName());

				Attribute otherAttribute = lookups.getAttribute(
						other.getDomain(), other.getName(), otherEnd.getName());
				Type t = getType(other, otherAttribute);
			}
		}
	}

	private void createGeneralizationMethod(ClassWriter w, Class cls,
			Generalization value) {
		// TODO
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

	private static void notImplemented() {
		re("not  implemented");
	}

	private static void unexpected() {
		re(UNEXPECTED);
	}

	private static void createDirectories(File file) {
		file.getParentFile().mkdirs();
	}

	private static PrintWriter createPrintWriter(OutputStream os) {
		return new PrintWriter(os);
	}

}
