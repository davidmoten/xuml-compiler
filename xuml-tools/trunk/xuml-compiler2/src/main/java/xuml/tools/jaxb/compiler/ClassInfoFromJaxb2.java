package xuml.tools.jaxb.compiler;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.HashMultimap.create;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import miuml.jaxb.Attribute;
import miuml.jaxb.BinaryAssociation;
import miuml.jaxb.Class;
import miuml.jaxb.Generalization;
import miuml.jaxb.IdentifierAttribute;
import miuml.jaxb.NativeAttribute;
import miuml.jaxb.Reference;
import miuml.jaxb.ReferentialAttribute;
import miuml.jaxb.Relationship;
import miuml.jaxb.UnaryAssociation;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;

public class ClassInfoFromJaxb2 extends ClassInfo {

	private final Class cls;
	private final String packageName;
	private final String classDescription;
	private final String schema;
	private final String table;
	private final TypeRegister typeRegister = new TypeRegister();
	private final Lookups lookups;

	public ClassInfoFromJaxb2(Class cls, String packageName,
			String classDescription, String schema, String table,
			Lookups lookups) {
		this.cls = cls;
		this.packageName = packageName;
		// TODO is this property needed?
		this.classDescription = classDescription;
		this.schema = schema;
		this.table = table;
		this.lookups = lookups;
	}

	@Override
	String getPackage() {
		return packageName;
	}

	@Override
	String getClassDescription() {
		return classDescription;
	}

	@Override
	List<List<String>> getUniqueConstraintColumnNames() {
		HashMultimap<BigInteger, String> map = getIdentifierAttributeNames();
		List<List<String>> list = newArrayList();
		for (BigInteger i : map.keySet())
			list.add(newArrayList(map.get(i)));
		return list;
	}

	private HashMultimap<BigInteger, String> getIdentifierAttributeNames() {
		HashMultimap<BigInteger, Attribute> map = getIdentifierAttributes();
		HashMultimap<BigInteger, String> m = create();
		for (BigInteger i : map.keySet()) {
			m.putAll(i, getNames(map.get(i)));
		}
		return m;
	}

	private static Function<Attribute, String> attributeName = new Function<Attribute, String>() {
		@Override
		public String apply(Attribute a) {
			return a.getName();
		}
	};

	private Set<String> getNames(Set<Attribute> attributes) {
		return newHashSet(transform(attributes, attributeName));
	}

	private HashMultimap<BigInteger, Attribute> getIdentifierAttributes() {
		HashMultimap<BigInteger, Attribute> map = HashMultimap.create();
		for (JAXBElement<? extends Attribute> element : cls.getAttribute()) {
			Attribute attribute = element.getValue();
			for (IdentifierAttribute id : attribute.getIdentifier()) {
				map.put(id.getNumber(), attribute);
			}
		}
		return map;
	}

	@Override
	String getSchema() {
		return schema;
	}

	@Override
	String getTable() {
		return table;
	}

	@Override
	String getJavaClassSimpleName() {
		return Util.toClassSimpleName(cls.getName());
	}

	@Override
	List<String> getOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<MyPrimaryIdAttribute> getPrimaryIdAttributeMembers() {
		Set<Attribute> list = getIdentifierAttributes().get(BigInteger.ONE);
		List<MyPrimaryIdAttribute> result = newArrayList();
		for (Attribute attribute : list) {
			if (attribute instanceof NativeAttribute) {
				NativeAttribute a = (NativeAttribute) attribute;
				MyPrimaryIdAttribute id = createMyPrimaryIdAttribute(a);
				result.add(id);
			} else {
				ReferentialAttribute a = (ReferentialAttribute) attribute;
				List<MyPrimaryIdAttribute> ids = createMyPrimaryIdAttribute(a);
				result.addAll(ids);
			}
		}
		return result;
	}

	private List<MyPrimaryIdAttribute> createMyPrimaryIdAttribute(
			ReferentialAttribute a) {
		List<JoinColumn> joinColumns = newArrayList();
		Reference ref = a.getReference().getValue();
		// TODO check model on how to override attribute names inherited via
		// relationship

		Relationship rel = lookups.getRelationship(ref.getRelationship());
		if (rel instanceof BinaryAssociation) {
			BinaryAssociation b = (BinaryAssociation) rel;
			String otherClassName;
			if (isActiveSide(b))
				otherClassName = b.getPassivePerspective().getViewedClass();
			else
				otherClassName = b.getActivePerspective().getViewedClass();
			ClassInfoFromJaxb2 otherInfo = getClassInfo(otherClassName);
			return otherInfo.getPrimaryIdAttributeMembers();
		} else if (rel instanceof UnaryAssociation) {
			// TODO
			throw new RuntimeException("not sure how to do this one yet");
		} else if (rel instanceof Generalization) {
			Generalization g = (Generalization) rel;
			if (cls.getName().equals(g.getSuperclass()))
				throw new RuntimeException(
						"cannot use an id from a specialization as primary id member: "
								+ g.getRnum());
			else {
				ClassInfoFromJaxb2 otherInfo = getClassInfo(g.getSuperclass());
				return otherInfo.getPrimaryIdAttributeMembers();
			}
		} else
			throw new RuntimeException("unexpected");
	}

	private ClassInfoFromJaxb2 getClassInfo(String otherClassName) {
		ClassInfoFromJaxb2 otherInfo = new ClassInfoFromJaxb2(
				lookups.getClassByName(otherClassName), packageName, "unknown",
				schema, table, lookups);
		return otherInfo;
	}

	private boolean isActiveSide(BinaryAssociation b) {
		return b.getActivePerspective().getViewedClass().equals(cls.getName());
	}

	private MyPrimaryIdAttribute createMyPrimaryIdAttribute(NativeAttribute a) {
		// TODO Auto-generated method stub
		return null;
	}

	private MyIndependentAttribute createMyIndependentAttribute(
			ReferentialAttribute a) {
		// TODO
		return new MyIndependentAttribute(schema, packageName, null,
				isSubclass(), classDescription);
	}

	private MyIndependentAttribute createMyIndependentAttribute(
			NativeAttribute a) {
		// TODO
		return new MyIndependentAttribute(schema, packageName, null,
				isSubclass(), classDescription);
	}

	@Override
	List<MyIndependentAttribute> getNonIdIndependentAttributeMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<MyEvent> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<String> getStateNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<MyTransition> getTransitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getStateIdentifier(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean isSuperclass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isSubclass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	MySubclassRole getSubclassRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<MyReferenceMember> getReferenceMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Set<String> getAtLeastOneFieldChecks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getImports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getIdColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getContextPackageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TypeRegister getTypes() {
		return typeRegister;
	}

}
