package xuml.tools.jaxb.compiler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import xuml.metamodel.jaxb.Association;
import xuml.metamodel.jaxb.AssociationEnd;
import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.DerivedAttribute;
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;
import xuml.tools.jaxb.Util;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyEvent;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyIndependentAttribute;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyReferenceMember;
import xuml.tools.jaxb.compiler.ClassInfoSample.MySubclassRole;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyTransition;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ClassInfoFromJaxb implements ClassInfo {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyIndependentAttribute> getNonIdIndependentAttributeMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyEvent> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStateNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyTransition> getTransitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStateIdentifier(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSuperclass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSubclass() {
		// TODO Auto-generated method stub
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

}
