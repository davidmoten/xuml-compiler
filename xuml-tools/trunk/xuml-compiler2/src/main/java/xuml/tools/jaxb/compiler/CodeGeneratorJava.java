package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.lowerFirst;
import static xuml.tools.jaxb.Util.upperFirst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import xuml.metamodel.jaxb.Association;
import xuml.metamodel.jaxb.AssociationEnd;
import xuml.metamodel.jaxb.AssociativeReference;
import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.DerivedAttribute;
import xuml.metamodel.jaxb.Event;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.IndependentAttributeType;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.Operation;
import xuml.metamodel.jaxb.Reference;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.SuperclassReference;
import xuml.metamodel.jaxb.System;
import xuml.metamodel.jaxb.ToOneReference;
import xuml.tools.jaxb.Util;

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
			createBehaviourFactoryInterface(cls, destination);
		}

		// create object factory
		createObjectFactory(system, destination);
		log("finished generation");
	}

	private void createObjectFactory(System system, File destination) {

	}

	private void createImplementation(Class cls, File destination) {
		// add getters and setters, operations, event methods, static Search
		// class instance, validators
		log("writing implementation of " + cls.getName());

		File file = new File(destination, getClassFilename(cls));
		createDirectories(file);

		ClassWriter w = new ClassWriter();
		w.setPackage(domainPackageNames.get(cls.getDomain()));
		w.setClassName(getClassJavaSimpleName(cls));
		w.addClassAnnotation("@Entity");
		w.addClassAnnotation("@Table(name=\"tablename\",uniqueConstraints=@UniqueConstraint(column_names))");
		for (JAXBElement<? extends Attribute> base : cls.getAttributeBase()) {
			if (base.getValue() instanceof IndependentAttribute) {
				IndependentAttribute a = (IndependentAttribute) base.getValue();
				String comment = "independent attribute " + a.getName() + ".";
				w.addMember(a.getName(), new Type(toJavaType(a.getType()),
						null, false), true, true, comment);
			} else if (base.getValue() instanceof ReferentialAttribute) {
				ReferentialAttribute a = (ReferentialAttribute) base.getValue();
				java.lang.System.out.println(cls.getName() + "." + a.getName()
						+ " "
						+ a.getReferenceBase().getValue().getRelationship());
				Type type = getType(cls, a);
				List<Parameter> parameters = Collections.emptyList();
				String comment = "referential attribute " + a.getName()
						+ " via R"
						+ a.getReferenceBase().getValue().getRelationship();
				w.addMember(lowerFirst(a.getName()), type, true, true, comment);
			} else if (base.getValue() instanceof DerivedAttribute) {
				DerivedAttribute a = (DerivedAttribute) base.getValue();
				Type type = getType(cls, a);
				String comment = "derived attribute " + a.getName()
						+ ". Formula is <code>" + a.getFormula() + "</code>";
				w.addMember(lowerFirst(a.getName()), type, false, true, comment);
			} else
				throw new RuntimeException("unimplemented "
						+ base.getValue().getClass());
		}

		w.setEvents(cls.getEvent());
		w.setTransitions(cls.getTransition());
		w.setOperations(cls.getOperation());

		for (JAXBElement<? extends Relationship> relationship : system
				.getRelationshipBase()) {
			if (relationship.getValue() instanceof Association) {
				addAssociationToWriter(w, cls,
						(Association) relationship.getValue());
			} else if (relationship.getValue() instanceof Generalization) {
				addGeneralizationToWriter(w, cls,
						(Generalization) relationship.getValue());
			} else
				unexpected();
		}

		w.setStates(cls.getState());

		writeToFile(w.toString().getBytes(), file);
	}

	private void addGeneralizationToWriter(ClassWriter w, Class cls,
			Generalization g) {
		if (g.getDomain().equals(cls.getDomain())
				&& g.getSubclass().equals(cls.getName())) {
			log("adding generalization " + g.getNumber());
			Class superClass = lookups.getClass(g.getDomain(),
					g.getSuperclass());
			Type type = new Type(getFullClassName(superClass),
					new ArrayList<Type>(), false);
			String comment = "generalization via R" + g.getNumber() + ".";
			w.addMember(superClass.getName() + "ViaR" + g.getNumber(), type,
					true, true, comment);
		}
	}

	private void addAssociationToWriter(ClassWriter w, Class cls,
			Association ass) {
		if (ass.getDomain().equals(cls.getDomain())
				&& ass.getClass1().getName().equals(cls.getName())
				|| ass.getClass2().getName().equals(cls.getName())) {
			log("adding association " + ass.getNumber());
			Class other = getOtherClass(cls, ass);
			AssociationEnd otherEnd = getOtherEnd(cls, ass);
			AssociationEnd thisEnd = getThisEnd(cls, ass);
			Type baseType = new Type(getFullClassName(other), null, false);
			Type type;
			if (isMany(otherEnd.getMultiplicity())) {
				type = new Type("java.util.Set", Lists.newArrayList(baseType),
						false);
			} else {
				type = baseType;
			}
			String comment = other.getName() + " via association R"
					+ ass.getNumber() + " ("
					+ Util.getAbbreviation(thisEnd.getMultiplicity()) + " -> "
					+ Util.getAbbreviation(otherEnd.getMultiplicity()) + ")";
			w.addMember(other.getName() + "ViaR" + ass.getNumber(), type, true,
					true, comment);
		}

	}

	private static boolean isMany(Multiplicity m) {
		return m.equals(Multiplicity.MANY) || m.equals(Multiplicity.ONE_MANY);
	}

	private void log(String s, Object... objects) {
		java.lang.System.out.format(s + "\n", objects);
	}

	/**
	 * Recursively travels relationship paths and returns the type of a referred
	 * attribute.
	 * 
	 * @param cls
	 * @param a
	 * @return
	 */
	private Type getType(Class cls, Attribute a) {
		log("getting type of %s.%s", cls.getName(), a.getName());

		if (a instanceof IndependentAttribute) {
			return new Type(toJavaType(((IndependentAttribute) a).getType()),
					null, false);
		} else if (a instanceof DerivedAttribute) {
			return new Type(toJavaType(((DerivedAttribute) a).getType()), null,
					false);
		} else if (a instanceof ReferentialAttribute) {
			ReferentialAttribute r = (ReferentialAttribute) a;
			Reference ref = r.getReferenceBase().getValue();
			if (ref instanceof ToOneReference) {
				ToOneReference t = (ToOneReference) ref;
				Type result = getToOneReferenceType(cls, a, r, t);
				return result;
			} else if (ref instanceof SuperclassReference) {
				SuperclassReference t = (SuperclassReference) ref;
				Type otherType = getGeneralizationType(cls, a, r, t);
				return otherType;
			} else if (ref instanceof AssociativeReference) {
				AssociativeReference t = (AssociativeReference) ref;
				Type otherType = getAssociativeType(cls, a, r, t);
				return otherType;
			} else {
				throw new RuntimeException(UNEXPECTED);
			}
		} else
			throw new RuntimeException("unexpected attribute type " + a);
	}

	private Type getAssociativeType(Class cls, Attribute a,
			ReferentialAttribute r, AssociativeReference t) {
		Association ass = lookups.getAssociation(cls.getDomain(),
				t.getRelationship());
		Class other;
		if (t.getSide().intValue() == 1)
			other = lookups
					.getClass(ass.getDomain(), ass.getClass1().getName());
		else
			other = lookups
					.getClass(ass.getDomain(), ass.getClass2().getName());
		String otherName;
		if (r.getOtherName() == null)
			otherName = r.getName();
		else
			otherName = r.getOtherName();
		log("looking up attribute %s %s %s", other.getDomain(),
				other.getName(), otherName);
		Attribute otherAttribute = lookups.getAttribute(other.getDomain(),
				other.getName(), otherName);
		Type otherType = getType(other, otherAttribute);
		return otherType;
	}

	private Type getGeneralizationType(Class cls, Attribute a,
			ReferentialAttribute r, SuperclassReference t) {
		Generalization g = lookups.getGeneralization(cls.getDomain(),
				t.getRelationship());
		if (g == null)
			throw new RuntimeException("did not find association");
		Class other = getOtherClass(g);
		String otherName;
		if (r.getOtherName() == null)
			otherName = r.getName();
		else
			otherName = r.getOtherName();
		log("looking up attribute %s %s %s", other.getDomain(),
				other.getName(), otherName);
		Attribute otherAttribute = lookups.getAttribute(other.getDomain(),
				other.getName(), otherName);
		Type otherType = getType(other, otherAttribute);
		return otherType;
	}

	private Class getOtherClass(Generalization g) {
		return lookups.getClass(g.getDomain(), g.getSuperclass());
	}

	private Type getToOneReferenceType(Class cls, Attribute a,
			ReferentialAttribute r, ToOneReference t) {
		Association ass = lookups.getAssociation(cls.getDomain(),
				t.getRelationship());
		if (ass == null)
			throw new RuntimeException("did not find association");
		Class other = getOtherClass(cls, ass);
		AssociationEnd otherEnd = getOtherEnd(cls, ass);
		String otherName = r.getOtherName();
		if (otherName == null)
			otherName = a.getName();
		log("looking up attribute %s %s %s", other.getDomain(),
				other.getName(), otherName);
		Attribute otherAttribute = lookups.getAttribute(other.getDomain(),
				other.getName(), otherName);
		Type otherType = getType(other, otherAttribute);
		Type result;
		if (otherEnd.getMultiplicity().equals(Multiplicity.MANY)
				|| otherEnd.getMultiplicity().equals(Multiplicity.ONE_MANY)) {
			List<Type> types = Lists.newArrayList(otherType);
			result = new Type(Set.class.getName(), types, false);
		} else
			result = otherType;
		return result;
	}

	private Class getOtherClass(Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return lookups.getClass(a.getDomain(), a.getClass2().getName());
			else
				return lookups.getClass(a.getDomain(), a.getClass1().getName());
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

	private AssociationEnd getThisEnd(Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return a.getClass1();
			else
				return a.getClass2();
		} else
			throw new RuntimeException(UNEXPECTED);
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

		if (!hasBehaviour(cls))
			return;
		// add operations, performOnEntry methods
		File file = new File(destination, getClassBehaviourFilename(cls));
		createDirectories(file);
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
		for (String type : types.getImports())
			java += "import " + type + ";\n";
		java += "\n";
		String all = java + bytes.toString();
		writeToFile(all.getBytes(), file);
	}

	private void createBehaviourFactoryInterface(Class cls, File destination) {

		if (!hasBehaviour(cls))
			return;
		String java = "package " + getPackage(cls) + ".behaviour;\n\n";
		java += "public interface " + cls.getName() + "BehaviourFactory {\n\n";
		java += "    " + cls.getName() + "Behaviour create(" + cls.getName()
				+ " cls);\n";
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

	private String getClassFilename(Class cls) {
		return getFullClassName(cls).replace(".", "/") + ".java";
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
