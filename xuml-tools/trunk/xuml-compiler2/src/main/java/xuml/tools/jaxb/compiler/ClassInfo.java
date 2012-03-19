package xuml.tools.jaxb.compiler;

import java.util.List;
import java.util.Set;

import xuml.tools.jaxb.compiler.ClassInfoSample.MyEvent;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyIndependentAttribute;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyReferenceMember;
import xuml.tools.jaxb.compiler.ClassInfoSample.MySubclassRole;
import xuml.tools.jaxb.compiler.ClassInfoSample.MyTransition;

public abstract class ClassInfo {

	abstract String getPackage();

	abstract String getClassDescription();

	abstract List<List<String>> getUniqueConstraintColumnNames();

	abstract String getSchema();

	abstract String getTable();

	abstract String getJavaClassSimpleName();

	abstract List<String> getOperations();

	final public String getBehaviourPackage() {
		return getPackage() + ".behaviour";
	}

	abstract String getBehaviourFactoryFullClassName();

	abstract String getBehaviourFullClassName();

	final public String getBehaviourFactorySimpleName() {
		return getJavaClassSimpleName() + "BehaviourFactory";
	}

	abstract String addType(java.lang.Class<?> cls);

	abstract void addTypes(java.lang.Class<?>... classes);

	abstract String addType(String fullClassName);

	abstract String addType(Type type);

	abstract MyIndependentAttribute getPrimaryId();

	abstract List<MyIndependentAttribute> getNonIdIndependentAttributeMembers();

	abstract List<MyEvent> getEvents();

	abstract List<String> getStateNames();

	abstract List<MyTransition> getTransitions();

	abstract String getStateIdentifier(String state);

	abstract boolean isSuperclass();

	abstract boolean isSubclass();

	abstract MySubclassRole getSubclassRole();

	abstract List<MyReferenceMember> getReferenceMembers();

	abstract Set<String> getAtLeastOneFieldChecks();

	abstract String getImports();

	abstract String getIdColumnName();

	abstract String getContextPackageName();

	final public String getContextFullClassName() {
		return getContextPackageName() + ".Context";
	}

	final public String getBehaviourFactoryFullName() {
		return getBehaviourPackage() + "." + getBehaviourFactorySimpleName();
	}

	final public String getBehaviourFactoryFieldName() {
		return Util.toJavaIdentifier(getBehaviourFactorySimpleName());
	}

	final public String getClassFullName() {

		return getPackage() + "." + getJavaClassSimpleName();
	}
}