package xuml.tools.jaxb.compiler;

import static com.google.common.collect.Lists.newArrayList;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import miuml.jaxb.Attribute;
import miuml.jaxb.Class;
import miuml.jaxb.IdentifierAttribute;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Sets;

public class ClassInfoFromJaxb2 extends ClassInfo {

	private final Class cls;
	private final String packageName;
	private final String classDescription;
	private final String schema;
	private final String table;
	private final TypeRegister typeRegister = new TypeRegister();

	public ClassInfoFromJaxb2(Class cls, String packageName,
			String classDescription, String schema, String table) {
		this.cls = cls;
		this.packageName = packageName;
		this.classDescription = classDescription;
		this.schema = schema;
		this.table = table;
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
		HashMultimap<BigInteger, String> m = HashMultimap.create();
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
		return Sets.newHashSet(Collections2
				.transform(attributes, attributeName));
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
	List<MyIndependentAttribute> getPrimaryIdAttributeMembers() {
		// TODO Auto-generated method stub
		return null;
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
