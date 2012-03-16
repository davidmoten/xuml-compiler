package xuml.tools.jaxb.compiler;

import static com.google.common.collect.Lists.newArrayList;
import static xuml.tools.jaxb.Util.toJavaConstantIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

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

	public void addTypes(Class<?>... classes) {
		for (Class<?> cls : classes)
			addType(cls);
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

	public static enum Mult {
		ONE, ZERO_ONE, MANY, ONE_MANY;
	}

	public static class MyReferenceMember {
		private final String simpleClassName;
		private final String fullClassName;
		private final Mult thisMult;
		private final Mult thatMult;
		private final String thisVerbClause;
		private final String thatVerbClause;
		private final String fieldName;
		private final String otherColumnName;
		private final String thisName;
		private final String otherName;
		private final MyManyToMany manyToMany;

		public MyReferenceMember(String simpleClassName, String fullClassName,
				Mult thisMult, Mult thatMult, String thisVerbClause,
				String thatVerbClause, String fieldName,
				String otherColumnName, String thisName, String otherName,
				MyManyToMany manyToMany) {
			this.simpleClassName = simpleClassName;
			this.fullClassName = fullClassName;
			this.thisMult = thisMult;
			this.thatMult = thatMult;
			this.thisVerbClause = thisVerbClause;
			this.thatVerbClause = thatVerbClause;
			this.fieldName = fieldName;
			this.otherColumnName = otherColumnName;
			this.thisName = thisName;
			this.otherName = otherName;
			this.manyToMany = manyToMany;
		}

		public String getFieldName() {
			return fieldName;
		}

		public String getThisName() {
			return thisName;
		}

		public String getOtherName() {
			return otherName;
		}

		public String getOtherColumnName() {
			return otherColumnName;
		}

		public String getSimpleClassName() {
			return simpleClassName;
		}

		public String getFullClassName() {
			return fullClassName;
		}

		public Mult getThisMult() {
			return thisMult;
		}

		public Mult getThatMult() {
			return thatMult;
		}

		public String getThisVerbClause() {
			return thisVerbClause;
		}

		public String getThatVerbClause() {
			return thatVerbClause;
		}

		public MyManyToMany getManyToMany() {
			return manyToMany;
		}

	}

	public static class MyManyToMany {
		private final String joinTable;
		private final String joinTableSchema;
		private final String thisColumnName;
		private final String thatColumnName;

		public String getThatColumnName() {
			return thatColumnName;
		}

		public MyManyToMany(String joinTable, String joinTableSchema,
				String thisColumnName, String thatColumnName) {
			super();
			this.joinTable = joinTable;
			this.joinTableSchema = joinTableSchema;
			this.thisColumnName = thisColumnName;
			this.thatColumnName = thatColumnName;
		}

		public String getJoinTable() {
			return joinTable;
		}

		public String getJoinTableSchema() {
			return joinTableSchema;
		}

		public String getThisColumnName() {
			return thisColumnName;
		}
	}

	public List<MyReferenceMember> getReferenceMembers() {

		// otherColumnName,thisName,otherName,manyToMany
		List<MyReferenceMember> list = newArrayList();
		list.add(new MyReferenceMember("Domain", getPackage() + ".Domain",
				Mult.ONE, Mult.ZERO_ONE, "models", "is modelled in", "domain",
				null, "class", null, null));
		list.add(new MyReferenceMember("Barge", getPackage() + ".Barge",
				Mult.ZERO_ONE, Mult.ONE, "carries", "is carried by", "barge",
				"barge_id", null, null, null));
		list.add(new MyReferenceMember("Wheel", getPackage() + ".Wheel",
				Mult.ONE, Mult.MANY, "helps move", "moves on", "wheel", null,
				"class", null, null));
		list.add(new MyReferenceMember("Insect", getPackage() + ".Insect",
				Mult.MANY, Mult.ONE, "bites", "is bitten by", "insect",
				"insect_id", null, null, null));
		list.add(new MyReferenceMember("Train", getPackage() + ".Train",
				Mult.ONE, Mult.ONE_MANY, "carries", "is carried by", "train",
				null, "class", null, null));
		list.add(new MyReferenceMember("Light", getPackage() + ".Light",
				Mult.ONE_MANY, Mult.ONE, "lights", "is lit by", "light",
				"light_id", null, null, null));
		list.add(new MyReferenceMember("Mouse", getPackage() + ".Mouse",
				Mult.ZERO_ONE, Mult.ZERO_ONE, "scares", "is scared by",
				"mouse", null, "class", null, null));
		list.add(new MyReferenceMember("Ant", getPackage() + ".Ant",
				Mult.ZERO_ONE, Mult.ZERO_ONE, "nibbles", "is nibbled by",
				"ant", "ant_id", null, null, null));
		list.add(new MyReferenceMember("Aircraft", getPackage() + ".Aircraft",
				Mult.ZERO_ONE, Mult.MANY, "flies", "is flown by", "aircraft",
				null, "class", null, null));
		list.add(new MyReferenceMember("Balloon", getPackage() + ".Balloon",
				Mult.MANY, Mult.ZERO_ONE, "floats", "is floated by", "balloon",
				"balloon_id", null, null, null));
		list.add(new MyReferenceMember("Mower", getPackage() + ".Mower",
				Mult.ZERO_ONE, Mult.MANY, "mows", "is mown by", "mower", null,
				"class", null, null));
		list.add(new MyReferenceMember("Chair", getPackage() + ".Chair",
				Mult.ONE_MANY, Mult.ZERO_ONE, "is sat on by", "sits on",
				"chair", "chair_id", null, null, null));
		list.add(new MyReferenceMember("Lemon", getPackage() + ".Lemon",
				Mult.MANY, Mult.MANY, "is sucked by", "sucks", "lemon", null,
				null, null, new MyManyToMany("class_lemon", getSchema(),
						"class_id", "lemon_id")));
		list.add(new MyReferenceMember("Abacus", getPackage() + ".Abacus",
				Mult.MANY, Mult.MANY, "is clicked by", "clicks", "abacus",
				null, "class", null, new MyManyToMany("class_lemon",
						getSchema(), "class_id", "abacus_id")));
		list.add(new MyReferenceMember("Lemon", getPackage() + ".Lemon",
				Mult.ONE_MANY, Mult.ONE_MANY, "is sucked by", "sucks", "lemon",
				null, null, null, new MyManyToMany("class_lemon", getSchema(),
						"class_id", "lemon_id")));
		list.add(new MyReferenceMember("Abacus", getPackage() + ".Abacus",
				Mult.ONE_MANY, Mult.ONE_MANY, "is clicked by", "clicks",
				"abacus", null, "class", null, new MyManyToMany("class_lemon",
						getSchema(), "class_id", "abacus_id")));
		return list;
	}

	public Set<String> getAtLeastOneFieldChecks() {
		Set<String> set = Sets.newTreeSet();
		set.add("train");
		set.add("lemon");
		set.add("abacus");
		return set;
	}

}
