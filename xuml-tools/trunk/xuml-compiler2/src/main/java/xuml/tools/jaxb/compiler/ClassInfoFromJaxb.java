package xuml.tools.jaxb.compiler;

import static xuml.tools.jaxb.Util.toColumnName;
import static xuml.tools.jaxb.Util.toJavaConstantIdentifier;
import static xuml.tools.jaxb.Util.toJavaIdentifier;
import static xuml.tools.jaxb.Util.upperFirst;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
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
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.IndependentAttributeType;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.Parameter;
import xuml.metamodel.jaxb.Reference;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.State;
import xuml.metamodel.jaxb.SuperclassReference;
import xuml.metamodel.jaxb.ToOneReference;
import xuml.metamodel.jaxb.Transition;
import xuml.tools.jaxb.Util;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyEvent;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyIndependentAttribute;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyParameter;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyReferenceMember;
import xuml.tools.jaxb.compiler.ClassInfoSample.MySubclassRole;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyTransition;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ClassInfoFromJaxb implements ClassInfo {

	private static final String UNEXPECTED = "unexpected";
	private final Class cls;
	private final String packageName;
	private final Lookups lookups;
	private final TypeRegister types = new TypeRegister();

	public ClassInfoFromJaxb(Class cls, Map<String, String> domainPackageNames,
			Lookups lookups) {
		this.cls = cls;
		this.lookups = lookups;
		this.packageName = domainPackageNames.get(cls.getDomain());
	}

	@Override
	public String getPackage() {
		return packageName;
	}

	@Override
	public String getClassDescription() {
		return cls.getName() + " description";
	}

	@Override
	public List<List<String>> getUniqueConstraintColumnNames() {
		List<List<String>> list = Lists.newArrayList();
		Multimap<BigInteger, Attribute> ids = getIdentifiers();
		for (BigInteger idNumber : ids.keySet()) {
			Set<String> columnNames = Sets.newHashSet();
			for (Attribute attribute : ids.get(idNumber)) {
				columnNames.add(getColumnName(attribute));
			}
			list.add(new ArrayList<String>(columnNames));
		}
		return list;
	}

	private String getColumnName(Attribute attribute) {
		return getColumnName(attribute, cls, lookups);
	}

	private static String getColumnName(Attribute attribute, Class cls,
			Lookups lookups) {
		if (attribute instanceof IndependentAttribute) {
			IndependentAttribute a = (IndependentAttribute) attribute;
			// TODO user override
			return Util.toColumnName(a.getName());
		} else if (attribute instanceof DerivedAttribute) {
			DerivedAttribute a = (DerivedAttribute) attribute;
			return Util.toColumnName(a.getName());
		} else if (attribute instanceof ReferentialAttribute) {
			ReferentialAttribute a = (ReferentialAttribute) attribute;
			BigInteger relNumber = a.getReferenceBase().getValue()
					.getRelationship();
			Relationship rel = lookups.getRelationship(cls.getDomain(),
					relNumber);
			if (rel instanceof Association) {
				Association ass = (Association) rel;
				Class other = getOtherClass(lookups, cls, ass);
				return getIdColumnName(other);
			} else
				return null;
		} else
			throw new RuntimeException("unexpected");
	}

	@Override
	public String getIdColumnName() {
		return Util.toTableIdName(cls.getName());
	}

	public static String getIdColumnName(Class cls) {
		return Util.toTableIdName(cls.getName());
	}

	private static Class getOtherClass(Lookups lookups, Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return lookups.getClass(a.getDomain(), a.getClass2().getName());
			else
				return lookups.getClass(a.getDomain(), a.getClass1().getName());
		} else
			throw new RuntimeException("unexpected");
	}

	private AssociationEnd getOtherEnd(Class cls, Association a) {
		if (cls.getDomain().equals(a.getDomain())) {
			if (cls.getName().equals(a.getClass1().getName()))
				return a.getClass2();
			else
				return a.getClass1();
		} else
			throw new RuntimeException("unexpected");
	}

	private Multimap<BigInteger, Attribute> getIdentifiers() {
		Multimap<BigInteger, Attribute> ids = HashMultimap.create();
		for (JAXBElement<? extends Attribute> element : cls.getAttributeBase()) {
			Attribute a = element.getValue();
			for (Identifier id : a.getIdentifier()) {
				ids.put(id.getNumber(), a);
			}
		}
		return ids;
	}

	@Override
	public String getSchema() {
		return Util.toTableName(cls.getDomain());
	}

	@Override
	public String getTable() {
		return Util.toTableName(cls.getName());
	}

	@Override
	public String getJavaClassSimpleName() {
		return Util.upperFirst(Util.toJavaIdentifier(cls.getName()));
	}

	@Override
	public List<String> getOperations() {
		return Lists.newArrayList();
	}

	@Override
	public String getBehaviourFactoryFullClassName() {
		return getBehaviourPackage() + "." + getBehaviourFactorySimpleName();
	}

	private String getBehaviourPackage() {
		return getPackage() + ".behaviour";
	}

	@Override
	public String getBehaviourFullClassName() {
		return getBehaviourPackage() + "." + getJavaClassSimpleName()
				+ "Factory";
	}

	@Override
	public String getBehaviourSingletonFullClassName() {
		return getPackage() + ".BehaviourFactory";
	}

	@Override
	public String getBehaviourFactorySimpleName() {
		return getJavaClassSimpleName() + "BehaviourFactory";
	}

	@Override
	public String addType(java.lang.Class<?> cls) {
		return types.addType(cls);
	}

	@Override
	public void addTypes(java.lang.Class<?>... classes) {
		types.addTypes(classes);
	}

	@Override
	public String addType(String fullClassName) {
		return types.addType(fullClassName);
	}

	@Override
	public String addType(Type type) {
		return types.addType(type);
	}

	@Override
	public MyIndependentAttribute getPrimaryId() {
		Collection<Attribute> attributes = getIdentifiers().get(BigInteger.ONE);
		if (attributes.size() == 1) {
			Attribute attribute = attributes.iterator().next();
			String fieldName = Util.toJavaIdentifier(attribute.getName());
			return new MyIndependentAttribute(fieldName,
					Util.toColumnName(fieldName), getType(cls, attribute),
					false, null);
		} else
			// don't use embedded id but rather create an arbitrary id
			return new MyIndependentAttribute("id", Util.toTableIdName(cls
					.getName()), new Type(
					toJavaType(IndependentAttributeType.ARBITRARY_ID), null,
					false), false, "");
	}

	@Override
	public List<MyIndependentAttribute> getNonIdIndependentAttributeMembers() {

		List<MyIndependentAttribute> list = Lists.newArrayList();

		for (JAXBElement<? extends Attribute> element : cls.getAttributeBase()) {
			Attribute attribute = element.getValue();
			if (attribute instanceof IndependentAttribute) {
				IndependentAttribute a = (IndependentAttribute) attribute;
				boolean inPrimaryIdentifier = false;
				for (Identifier id : attribute.getIdentifier())
					if (id.getNumber().equals(BigInteger.ONE))
						inPrimaryIdentifier = true;
				// if primary id has more than one field then arbitrary id is
				// used as the id
				if (getIdentifiers().get(BigInteger.ONE).size() > 1)
					inPrimaryIdentifier = false;
				if (!inPrimaryIdentifier) {
					list.add(new MyIndependentAttribute(
							toJavaIdentifier(attribute.getName()),
							toColumnName(attribute.getName()), getType(cls,
									attribute), !a.isMandatory(),
							"attribute description here"));
				}
			}
		}

		return list;
	}

	@Override
	public List<MyEvent> getEvents() {
		List<MyEvent> list = Lists.newArrayList();
		for (Event event : cls.getEvent()) {
			List<MyParameter> params = Lists.newArrayList();
			for (Parameter p : event.getParameter()) {
				params.add(new MyParameter(toJavaIdentifier(p.getName()), p
						.getType()));
			}
			list.add(new MyEvent(event.getName(),
					upperFirst(toJavaIdentifier(event.getName())), params));
		}
		return list;
	}

	@Override
	public List<String> getStateNames() {
		List<String> list = Lists.newArrayList();
		for (State state : cls.getState()) {
			list.add(state.getName());
		}
		return list;
	}

	@Override
	public List<MyTransition> getTransitions() {
		List<MyTransition> list = Lists.newArrayList();
		for (Transition t : cls.getTransition()) {
			list.add(new MyTransition(t.getEvent(), t.getFrom(), t.getTo()));
		}
		return list;
	}

	@Override
	public String getStateIdentifier(String state) {
		return toJavaConstantIdentifier(state);
	}

	@Override
	public boolean isSuperclass() {

		for (JAXBElement<? extends Relationship> element : lookups.getSystem()
				.getRelationshipBase()) {
			Relationship rel = element.getValue();
			if (rel instanceof Generalization) {
				Generalization g = (Generalization) rel;
				if (g.getDomain().equals(cls.getDomain())
						&& g.getSuperclass().equals(cls.getName()))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isSubclass() {
		for (JAXBElement<? extends Relationship> element : lookups.getSystem()
				.getRelationshipBase()) {
			Relationship rel = element.getValue();
			if (rel instanceof Generalization) {
				Generalization g = (Generalization) rel;
				if (g.getDomain().equals(cls.getDomain())
						&& g.getSubclass().equals(cls.getName()))
					return true;
			}
		}
		return false;
	}

	@Override
	public MySubclassRole getSubclassRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyReferenceMember> getReferenceMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAtLeastOneFieldChecks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getImports() {
		// TODO Auto-generated method stub
		return null;
	}

	private Type getType(Class cls, Attribute a) {
		MyAttributeType t = getMyAttributeType(cls, a);
		if (t.multiple)
			return new Type(Set.class.getName(), Lists.newArrayList(new Type(
					toJavaType(t.type), null, false)), false);
		return new Type(toJavaType(t.type), null, false);
	}

	private static class MyAttributeType {
		IndependentAttributeType type;
		boolean multiple;

		public MyAttributeType(IndependentAttributeType type, boolean multiple) {
			super();
			this.type = type;
			this.multiple = multiple;
		}
	}

	private void log(String message, Object... objects) {
		java.lang.System.out.format(message, objects);
	}

	/**
	 * Recursively travels relationship paths and returns the type of a referred
	 * attribute.
	 * 
	 * @param cls
	 * @param a
	 * @return
	 */
	private MyAttributeType getMyAttributeType(Class cls, Attribute a) {
		log("getting type of %s.%s", cls.getName(), a.getName());

		if (a instanceof IndependentAttribute) {
			return new MyAttributeType(((IndependentAttribute) a).getType(),
					false);
		} else if (a instanceof DerivedAttribute) {
			return new MyAttributeType(((DerivedAttribute) a).getType(), false);
		} else if (a instanceof ReferentialAttribute) {
			ReferentialAttribute r = (ReferentialAttribute) a;
			Reference ref = r.getReferenceBase().getValue();
			if (ref instanceof ToOneReference) {
				ToOneReference t = (ToOneReference) ref;
				MyAttributeType result = getToOneReferenceType(cls, a, r, t);
				return result;
			} else if (ref instanceof SuperclassReference) {
				SuperclassReference t = (SuperclassReference) ref;
				MyAttributeType otherType = getGeneralizationType(cls, a, r, t);
				return otherType;
			} else if (ref instanceof AssociativeReference) {
				AssociativeReference t = (AssociativeReference) ref;
				MyAttributeType otherType = getAssociativeType(cls, a, r, t);
				return otherType;
			} else {
				throw new RuntimeException(UNEXPECTED);
			}
		} else
			throw new RuntimeException("unexpected attribute type " + a);
	}

	private MyAttributeType getAssociativeType(Class cls, Attribute a,
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
		MyAttributeType otherType = getMyAttributeType(other, otherAttribute);
		return otherType;
	}

	private MyAttributeType getGeneralizationType(Class cls, Attribute a,
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
		MyAttributeType otherType = getMyAttributeType(other, otherAttribute);
		return otherType;
	}

	private Class getOtherClass(Generalization g) {
		return lookups.getClass(g.getDomain(), g.getSuperclass());
	}

	private MyAttributeType getToOneReferenceType(Class cls, Attribute a,
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
		MyAttributeType otherType = getMyAttributeType(other, otherAttribute);
		MyAttributeType result;
		if (otherEnd.getMultiplicity().equals(Multiplicity.MANY)
				|| otherEnd.getMultiplicity().equals(Multiplicity.ONE_MANY)) {
			result = new MyAttributeType(otherType.type, true);
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

}
