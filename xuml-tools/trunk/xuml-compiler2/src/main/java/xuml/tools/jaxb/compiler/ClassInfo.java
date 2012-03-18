package xuml.tools.jaxb.compiler;

import java.util.List;
import java.util.Set;

import xuml.tools.jaxb.compiler.ClassInfoSample.MyEvent;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyIndependentAttribute;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyReferenceMember;
import xuml.tools.jaxb.compiler.ClassInfoSample.MySubclassRole;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyTransition;

public interface ClassInfo {

	String getPackage();

	String getClassDescription();

	List<List<String>> getUniqueConstraintColumnNames();

	String getSchema();

	String getTable();

	String getJavaClassSimpleName();

	List<String> getOperations();

	String getBehaviourFactoryFullClassName();

	String getBehaviourFullClassName();

	String getBehaviourSingletonFullClassName();

	String getBehaviourFactorySimpleName();

	String addType(java.lang.Class<?> cls);

	void addTypes(java.lang.Class<?>... classes);

	String addType(String fullClassName);

	String addType(Type type);

	MyIndependentAttribute getPrimaryId();

	List<MyIndependentAttribute> getNonIdIndependentAttributeMembers();

	List<MyEvent> getEvents();

	List<String> getStateNames();

	List<MyTransition> getTransitions();

	String getStateIdentifier(String state);

	boolean isSuperclass();

	boolean isSubclass();

	MySubclassRole getSubclassRole();

	List<MyReferenceMember> getReferenceMembers();

	Set<String> getAtLeastOneFieldChecks();

	String getImports();

	String getIdColumnName();

	String getContextPackageName();

}