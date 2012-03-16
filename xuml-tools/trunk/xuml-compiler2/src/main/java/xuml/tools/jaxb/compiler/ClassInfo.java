package xuml.tools.jaxb.compiler;

import static com.google.common.collect.Lists.newArrayList;
import static xuml.tools.jaxb.Util.toJavaConstantIdentifier;

import java.util.ArrayList;
import java.util.List;

public class ClassInfo {

	private static final String DOT = ".";
	private final TypeRegister types = new TypeRegister();

	public TypeRegister getTypeRegister() {
		return types;
	}

	public String getPackage() {
		return "miuml";
	}

	public String getClassJavadoc() {

		return getClassDescription() + "\n\n@GeneratedBy xuml-compiler2\n"
				+ "@Generated\n";
	}

	private String getClassDescription() {
		return "Represents a Class from the miUML metamodel.";
	}

	public List<List<String>> getUniqueConstraintColumnNames() {
		List<List<String>> list = newArrayList();
		List<String> list1 = newArrayList("name", "domain");
		List<String> list2 = newArrayList("domain", "number");
		list.add(list1);
		list.add(list2);
		return list;
	}

	public String getSchema() {
		return "xuml";
	}

	public String getTable() {
		return "t_class";
	}

	public String getJavaClassSimpleName() {
		return "Class";
	}

	public List<String> getOperations() {
		ArrayList<String> list = newArrayList("validate");
		return list;
	}

	public String getBehaviourFactoryFullClassName() {
		return getBehaviourPackage() + DOT + getJavaClassSimpleName()
				+ "BehaviourFactory";
	}

	public String getBehaviourFullClassName() {
		return getBehaviourPackage() + DOT + getBehaviourFactorySimpleName();
	}

	public String getBehaviourSingletonFullClassName() {
		return getBehaviourPackage() + DOT + "BehaviourFactory";
	}

	private String getBehaviourPackage() {
		return getPackage() + ".behaviour";
	}

	public String getBehaviourFactorySimpleName() {
		return getJavaClassSimpleName() + "Behaviour";
	}

	public String addType(Class<?> cls) {
		return types.addType(cls);
	}

	public String addType(String fullClassName) {
		return types.addType(fullClassName);
	}

	public String addType(Type type) {
		return types.addType(type);
	}

	public static class MyIndependentAttribute {
		private final String fieldName;
		private final String columnName;
		private final Type type;
		private final boolean nullable;
		private final String description;

		public boolean isNullable() {
			return nullable;
		}

		public MyIndependentAttribute(String fieldName, String columnName,
				Type type, boolean nullable, String description) {
			super();
			this.fieldName = fieldName;
			this.columnName = columnName;
			this.type = type;
			this.nullable = nullable;
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public String getFieldName() {
			return fieldName;
		}

		public String getColumnName() {
			return columnName;
		}

		public Type getType() {
			return type;
		}
	}

	public MyIndependentAttribute getPrimaryId() {
		return new MyIndependentAttribute("id", "class_id", new Type("Long",
				null, false), false, null);
	}

	public List<MyIndependentAttribute> getNonIdIndependentAttributeMembers() {
		List<MyIndependentAttribute> list = newArrayList();
		list.add(new MyIndependentAttribute("description", "desc", new Type(
				"String", null, false), true,
				"a description of the class in terms of its role in the xuml domain"));
		return list;
	}

	public static class MyParameter {
		private final String fieldName;
		private final String type;

		public String getFieldName() {
			return fieldName;
		}

		public String getType() {
			return type;
		}

		public MyParameter(String fieldName, String type) {
			super();
			this.fieldName = fieldName;
			this.type = type;
		}
	}

	public static class MyEvent {
		private final String name;
		private String simpleClassName;
		private final List<MyParameter> parameters;

		public List<MyParameter> getParameters() {
			return parameters;
		}

		public MyEvent(String name, String simpleClassName,
				List<MyParameter> parameters) {
			this.name = name;
			this.simpleClassName = simpleClassName;
			if (parameters == null)
				this.parameters = newArrayList();
			else
				this.parameters = parameters;
		}

		public String getName() {
			return name;
		}

		public String getSimpleClassName() {
			return simpleClassName;
		}

		public void setSimpleClassName(String simpleClassName) {
			this.simpleClassName = simpleClassName;
		}
	}

	public List<MyEvent> getEvents() {
		List<MyEvent> list = newArrayList();
		List<MyParameter> params = newArrayList();
		params.add(new MyParameter("message", "String"));
		list.add(new MyEvent("Validation Error", "ValidationError", params));
		return list;
	}

	public static class MyTransition {
		private final String eventName;
		private final String fromState;
		private final String toState;

		public String getEventName() {
			return eventName;
		}

		public MyTransition(String eventName, String fromState, String toState) {
			this.eventName = eventName;
			this.fromState = fromState;
			this.toState = toState;
		}

		public String getFromState() {
			return fromState;
		}

		public String getToState() {
			return toState;
		}
	}

	public List<String> getStateNames() {
		List<String> list = newArrayList();
		list.add("Valid");
		list.add("Invalid");
		return list;
	}

	public List<MyTransition> getTransitions() {
		List<MyTransition> list = newArrayList();
		list.add(new MyTransition("Validation Error", "Valid", "Invalid"));
		return list;
	}

	public String getStateIdentifier(String state) {
		return toJavaConstantIdentifier(state);
	}

	public boolean isSuperclass() {
		return true;
	}

	public boolean isSubclass() {
		return true;
	}

	public static class MySubclassRole {
		private final String superclassJavaFullClassName;
		private final String discriminatorValue;

		public MySubclassRole(String superclassJavaFullClassName,
				String discriminatorValue) {
			super();
			this.superclassJavaFullClassName = superclassJavaFullClassName;
			this.discriminatorValue = discriminatorValue;
		}

		public String getSuperclassJavaFullClassName() {
			return superclassJavaFullClassName;
		}

		public String getDiscriminatorValue() {
			return discriminatorValue;
		}
	}

	public MySubclassRole getSubclassRole() {
		return new MySubclassRole(getPackage() + ".Element",
				getJavaClassSimpleName());
	}
}
