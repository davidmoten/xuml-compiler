package moten.david.uml.xuml.model.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import model.Association;
import model.AssociationClass;
import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeDerived;
import model.AttributePersistence;
import model.CallEvent;
import model.Class;
import model.ClassPersistence;
import model.Event;
import model.FinalState;
import model.FreeType;
import model.FromState;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.Index;
import model.InitialState;
import model.ModelFactory;
import model.Operation;
import model.Package;
import model.Parameter;
import model.Primitive;
import model.PrimitiveType;
import model.SignalEvent;
import model.Specialization;
import model.SpecializationGroup;
import model.State;
import model.StateMachine;
import model.System;
import model.TimerEvent;
import model.ToState;
import model.Transition;
import moten.david.uml.xuml.model.CodeGenerator;
import moten.david.uml.xuml.model.Generator;
import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.SqlReservedWords;
import moten.david.uml.xuml.model.compiler.Compiler;
import moten.david.uml.xuml.model.compiler.util.StringUtil;
import moten.david.uml.xuml.model.viewer.SystemViewer;
import moten.david.util.text.UnderscoreFilterWriter;

public class SystemBase implements CodeGenerator {

	private final Map<model.Class, Integer> identifierNumbers = new HashMap<model.Class, Integer>();

	private final String schema;

	private final System system;

	private Generator generator = Generator.GENERATED_VALUE;

	public SystemBase(String schema, System system) {
		this.schema = schema;
		this.system = system;
	}

	public SystemBase(String schema, String systemName) {
		this(schema, createSystem(systemName));
	}

	public model.Package createRootPackage(String name, String description) {
		model.Package pkg = ModelFactory.eINSTANCE.createPackage();
		pkg.setName(name);
		pkg.setDescription(description);
		system.getPackage().add(pkg);
		return pkg;
	}

	public model.Package createPackage(model.Package parent, String name,
			String description) {
		model.Package pkg = ModelFactory.eINSTANCE.createPackage();
		pkg.setName(name);
		pkg.setDescription(description);
		parent.getSubPackage().add(pkg);
		return pkg;
	}

	private PrimitiveType getPrimitiveType(Primitive primitive) {
		if (primitive == null)
			return null;
		for (PrimitiveType pt : system.getPrimitiveType()) {
			if (pt.getPrimitive().equals(primitive))
				return pt;
		}
		PrimitiveType t = ModelFactory.eINSTANCE.createPrimitiveType();
		t.setName(primitive.getName());
		t.setDescription("Primitive type enclosure for primitive "
				+ primitive.getName());
		t.setSystem(system);
		t.setPrimitive(primitive);
		return t;
	}

	private FreeType getFreeType(String typeName) {
		if (typeName == null)
			return null;
		for (FreeType ft : system.getFreeType()) {
			if (ft.getType().equals(typeName))
				return ft;
		}
		FreeType t = ModelFactory.eINSTANCE.createFreeType();
		t.setName(typeName);
		t.setDescription("FreeType enclosure for type " + typeName);
		t.setSystem(system);
		t.setType(typeName);
		return t;
	}

	public Attribute createAttribute(model.Class cls, String name,
			Primitive type, String[] values) {
		Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
		attribute.setName(name);
		attribute.setType(getPrimitiveType(type));
		if (values != null)
			for (String value : values) {
				attribute.getValues().add(value);
			}
		cls.getAttribute().add(attribute);
		return attribute;
	}

	public Attribute createAttribute(model.Class cls, String name,
			Primitive type) {
		return createAttribute(cls, name, type, null);
	}

	public Attribute createAttribute(model.Class cls, String name,
			String[] values) {
		return createAttribute(cls, name, Primitive.STRING, values);
	}

	public Attribute createAttribute(model.Class cls, String name) {
		return createAttribute(cls, name, Primitive.STRING, null);
	}

	public model.Class createClass(model.Package pkg, String name,
			String description) {
		return createClassWithTableName(pkg, name, description, null, true);
	}

	public model.Class createClassWithTableName(model.Package pkg, String name,
			String description, String tableName, boolean persistent) {
		model.Class c = ModelFactory.eINSTANCE.createClass();
		c.setName(name);
		c.setDescription(description);
		if (persistent)
			createPersistence(c, tableName);
		c.setPackage(pkg);
		return c;
	}

	public AssociationClass createAssociationClass(model.Package pkg,
			String name, String description) {
		AssociationClass c = ModelFactory.eINSTANCE.createAssociationClass();
		c.setName(name);
		c.setDescription(description);
		createPersistence(c);
		c.setPackage(pkg);
		return c;
	}

	private AttributePersistence createPrimaryKey(Attribute a,
			boolean generated, boolean generatedBySequence) {
		IdentifierPrimary id = ModelFactory.eINSTANCE.createIdentifierPrimary();
		id.setName("I");
		id.setDescription("primary key for the class");
		id.getAttribute().add(a);
		a.getClass_().setIdentifierPrimary(id);
		AttributePersistence persistence = ModelFactory.eINSTANCE
				.createAttributePersistence();
		a.setPersistence(persistence);
		persistence.setGeneratedBySequence(generatedBySequence);
		persistence.setGeneratedValue(generated);
		return persistence;
	}

	public AttributePersistence createPrimaryKey(Attribute a,
			Generator generator) {
		boolean generated = true;
		boolean generatedBySequence = false;
		if (generator.equals(Generator.GENERATED_BY_SEQUENCE))
			generatedBySequence = true;
		else if (generator.equals(Generator.NOT_GENERATED))
			generated = false;
		return createPrimaryKey(a, generated, generatedBySequence);
	}

	public IdentifierNonPrimary createIdentifierNonPrimary(model.Class cls,
			Attribute... attributes) {

		IdentifierNonPrimary id = ModelFactory.eINSTANCE
				.createIdentifierNonPrimary();
		id.setName(getNextIdentifierName(cls));
		cls.getIdentifierNonPrimary().add(id);
		for (Attribute attribute : attributes) {
			id.getAttribute().add(attribute);
		}
		return id;
	}

	public AssociationClass createAssociationClassWithArbitraryId(
			model.Package pkg, String name, String description) {
		AssociationClass cls = createAssociationClass(pkg, name, description);
		createPrimaryKey(createAttribute(cls, "id", Primitive.ARBITRARY_ID),
				generator);
		return cls;
	}

	private String getNextIdentifierName(model.Class cls) {
		if (identifierNumbers.get(cls) == null) {
			identifierNumbers.put(cls, 0);
		}
		identifierNumbers.put(cls, identifierNumbers.get(cls) + 1);
		return "I" + identifierNumbers.get(cls);
	}

	public ClassPersistence createPersistence(model.Class cls) {
		return createPersistence(cls, null);
	}

	public ClassPersistence createPersistence(model.Class cls, String tableName) {
		ClassPersistence persistence = ModelFactory.eINSTANCE
				.createClassPersistence();
		cls.setPersistence(persistence);
		if (tableName != null) {
			persistence.setTable(tableName);
		} else if (SqlReservedWords.getInstance().isReservedWord(cls.getName())) {
			persistence.setTable(UnderscoreFilterWriter.underscore(cls
					.getName()
					+ "Table"));
		}
		persistence.setSchema(schema);
		return persistence;
	}

	public Association createAssociation(String relationshipName,
			AssociationEndPrimary primary, AssociationEndSecondary secondary) {

		Association a = ModelFactory.eINSTANCE.createAssociation();
		a.setPrimary(primary);
		a.setSecondary(secondary);
		a.setName(relationshipName);
		system.getAssociation().add(a);
		return a;
	}

	public AttributeDerived createAttributeDerived(model.Class cls,
			AssociationEnd end, String name) {
		AttributeDerived a = ModelFactory.eINSTANCE.createAttributeDerived();
		a.setAssociationEnd(end);
		a.setClass(cls);
		a.setName(name);
		return a;
	}

	public IdentifierPrimary createIdentifierPrimary(model.Class cls,
			String name, Attribute[] attributes,
			AttributeDerived... derivedAttributes) {
		IdentifierPrimary identifierPrimary = ModelFactory.eINSTANCE
				.createIdentifierPrimary();
		identifierPrimary.setName(name);
		if (attributes != null) {
			identifierPrimary.getAttribute().addAll(Arrays.asList(attributes));
		}
		if (derivedAttributes != null) {
			identifierPrimary.getDerivedAttribute().addAll(
					Arrays.asList(derivedAttributes));
		}
		cls.setIdentifierPrimary(identifierPrimary);
		return identifierPrimary;
	}

	public IdentifierNonPrimary createIdentifierNonPrimary(model.Class cls,
			String name, Attribute[] attributes,
			AttributeDerived... derivedAttributes) {
		IdentifierNonPrimary identifierNonPrimary = ModelFactory.eINSTANCE
				.createIdentifierNonPrimary();
		identifierNonPrimary.setName(name);
		if (attributes != null) {
			identifierNonPrimary.getAttribute().addAll(
					Arrays.asList(attributes));
		}
		if (derivedAttributes != null) {
			identifierNonPrimary.getDerivedAttribute().addAll(
					Arrays.asList(derivedAttributes));
		}
		cls.getIdentifierNonPrimary().add(identifierNonPrimary);
		return identifierNonPrimary;
	}

	public AssociationEndPrimary createAssociationEndPrimary(model.Class cls,
			String role, Multiplicity multiplicity, String verbClause) {
		AssociationEndPrimary ae = ModelFactory.eINSTANCE
				.createAssociationEndPrimary();
		ae.setMandatory(multiplicity.isMandatory());
		ae.setMultiple(multiplicity.isMultiple());
		ae.setRole(role);
		ae.setVerbClause(verbClause);
		ae.setClass(cls);
		ae.setName(cls.getName() + " " + role);
		return ae;
	}

	public AssociationEndPrimary createAssociationEndPrimary(model.Class cls,
			Multiplicity multiplicity, String verbClause) {
		return createAssociationEndPrimary(cls, StringUtil.uncapFirst(cls
				.getName()), multiplicity, verbClause);
	}

	public AssociationEndSecondary createAssociationEndSecondary(
			model.Class cls, String role, Multiplicity multiplicity,
			String verbClause) {
		AssociationEndSecondary ae = ModelFactory.eINSTANCE
				.createAssociationEndSecondary();
		ae.setMandatory(multiplicity.isMandatory());
		ae.setMultiple(multiplicity.isMultiple());
		ae.setRole(role);
		ae.setVerbClause(verbClause);
		ae.setClass(cls);
		ae.setName(cls.getName() + " " + role);
		return ae;
	}

	public AssociationEndSecondary createAssociationEndSecondary(
			model.Class cls, Multiplicity multiplicity, String verbClause) {
		return createAssociationEndSecondary(cls, StringUtil.uncapFirst(cls
				.getName()), multiplicity, verbClause);
	}

	public Operation createOperation(model.Class cls, String name,
			String description, String returns, boolean multiple,
			Parameter... params) {
		Operation operation = ModelFactory.eINSTANCE.createOperation();
		operation.setName(name);
		operation.setDescription(description);
		operation.setReturns(getFreeType(returns));
		operation.setReturnsMultiple(multiple);
		for (Parameter param : params)
			operation.getParameter().add(param);
		cls.getOperation().add(operation);
		return operation;
	}

	public Parameter createParameter(String name, String description,
			String type) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getFreeType(type));
		return p;
	}

	public synchronized StateMachine createStateMachine(model.Class cls) {
		if (cls.getStateMachine() == null) {
			StateMachine stateMachine = ModelFactory.eINSTANCE
					.createStateMachine();
			cls.setStateMachine(stateMachine);
			InitialState initial = ModelFactory.eINSTANCE.createInitialState();
			initial.setName("InitialState");
			FinalState fin = ModelFactory.eINSTANCE.createFinalState();
			fin.setName("FinalState");
			stateMachine.setInitialState(initial);
			stateMachine.setFinalState(fin);
		}
		return cls.getStateMachine();
	}

	public State createState(model.Class cls, String name) {
		createStateMachine(cls);
		State state = ModelFactory.eINSTANCE.createState();
		state.setName(name);
		cls.getStateMachine().getState().add(state);
		return state;
	}

	public SignalEvent createSignalEvent(model.Class cls, String name) {
		createStateMachine(cls);
		SignalEvent event = ModelFactory.eINSTANCE.createSignalEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	public CallEvent createCallEvent(model.Class cls, String name) {
		createStateMachine(cls);
		CallEvent event = ModelFactory.eINSTANCE.createCallEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	public TimerEvent createTimerEvent(model.Class cls, String name) {
		createStateMachine(cls);
		TimerEvent event = ModelFactory.eINSTANCE.createTimerEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	public void createTransition(FromState state1, ToState state2, Event event) {
		Transition t = ModelFactory.eINSTANCE.createTransition();
		t.setName(event.getName());
		t.setFromState(state1);
		t.setToState(state2);
		t.setEvent(event);

	}

	public Parameter createParameter(Event event, String name, String type) {
		Parameter parameter = ModelFactory.eINSTANCE.createParameter();
		parameter.setName(name);
		parameter.setType(getFreeType(type));
		event.getParameter().add(parameter);
		return parameter;
	}

	public Parameter createParameter(Event event, String name) {
		return createParameter(event, name, "String");
	}

	public static System createSystem(String name) {
		System system = ModelFactory.eINSTANCE.createSystem();
		system.setName(name);
		return system;
	}

	public AssociationEndPersistence createOrderBy(AssociationEnd ae,
			Attribute... attributes) {
		AssociationEndPersistence aspect = ModelFactory.eINSTANCE
				.createAssociationEndPersistence();
		for (Attribute a : attributes) {
			aspect.getOrderBy().add(a);
		}
		ae.setPersistence(aspect);
		return aspect;

	}

	public Attribute createAttributeIndexed(Class cls, String name,
			Primitive type) {
		Attribute a = createAttribute(cls, name, type, null);
		if (cls.getPersistence() == null)
			cls.setPersistence(ModelFactory.eINSTANCE.createClassPersistence());
		Index index = ModelFactory.eINSTANCE.createIndex();
		index.setName(a.getName() + "Index");
		index
				.setDescription("single column index for attribute "
						+ a.getName());
		index.getAttribute().add(a);
		cls.getPersistence().getIndex().add(index);
		return a;
	}

	public Class createClassNonPersistent(Package pkg, String name,
			String description) {
		return createClassWithTableName(pkg, name, description, name, false);
	}

	public SpecializationGroup createSpecializationGroup(Class cls,
			String name, String description) {
		SpecializationGroup group = ModelFactory.eINSTANCE
				.createSpecializationGroup();
		group.setName(name);
		group.setDescription(description);
		group.setSuperClass(cls);
		return group;
	}

	public Specialization createSpecialization(SpecializationGroup group,
			Package pkg, String name, String description) {
		Specialization s = ModelFactory.eINSTANCE.createSpecialization();
		s.setName(name);
		s.setDescription(description);
		s.setPackage(pkg);
		s.setGroup(group);
		createPersistence(s, null);
		return s;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public Generator getGenerator() {
		return this.generator;
	}

	public Class createClassWithArbitraryId(Package pkg, String name,
			String description) {
		Class cls = createClass(pkg, name, description);
		createPrimaryKey(createAttribute(cls, "id", Primitive.ARBITRARY_ID),
				generator);
		return cls;
	}

	public String getSchema() {
		return schema;
	}

	public System getSystem() {
		return system;
	}

	public void generate(String outputDirectoryFilename) throws Exception {
		File outputDirectory = new File(outputDirectoryFilename);
		outputDirectory.mkdirs();
		Compiler compiler = new Compiler(getSystem(), outputDirectory);
		compiler.compile();
	}

	public void view(String settingsFilename) throws NumberFormatException,
			IOException {
		SystemViewer viewer = new SystemViewer(getSystem(),
				"src/viewer/shop.ini");
		viewer.showViewer();
	}

}
