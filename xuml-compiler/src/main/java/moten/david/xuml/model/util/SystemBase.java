package moten.david.xuml.model.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import model.Association;
import model.AssociationClass;
import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributePersistence;
import model.AttributeReferential;
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
import moten.david.util.text.UnderscoreFilterWriter;
import moten.david.xuml.model.CodeGenerator;
import moten.david.xuml.model.Generator;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.SqlReservedWords;
import moten.david.xuml.model.compiler.Compiler;
import moten.david.xuml.model.compiler.util.StringUtil;
import moten.david.xuml.model.viewer.SystemViewer;

public class SystemBase implements CodeGenerator {

	public static final String SYSTEM_DEFINITION_EXTENSION = "systemDefinition";

	private final Map<model.Class, Integer> identifierNumbers = new HashMap<model.Class, Integer>();

	private final String schema;

	private final System system;

	private Generator generator = Generator.GENERATED_VALUE;

	/**
	 * Constructor.
	 * 
	 * @param schema
	 * @param system
	 */
	public SystemBase(String schema, System system) {
		this.schema = schema;
		this.system = system;
	}

	/**
	 * Constructor.
	 * 
	 * @param schema
	 * @param systemName
	 */
	public SystemBase(String schema, String systemName) {
		this(schema, createSystem(systemName));
	}

	/**
	 * Create root package with a name and description. 
	 * 
	 * @param name should not contain delimiters e.g. '.' . Use createPackage repeatedly to create nested packages.
	 * @param description
	 * @return root package
	 */
	public model.Package createRootPackage(String name, String description) {
		model.Package pkg = ModelFactory.eINSTANCE.createPackage();
		pkg.setName(name);
		pkg.setDescription(description);
		system.getPackage().add(pkg);
		return pkg;
	}

	/**
	 * Create a package with the given name and description and set it as a
	 * child package of parent.
	 * 
	 * @param parent
	 * @param name
	 * @param description
	 * @return package
	 */
	public model.Package createPackage(model.Package parent, String name,
			String description) {
		model.Package pkg = ModelFactory.eINSTANCE.createPackage();
		pkg.setName(name);
		pkg.setDescription(description);
		parent.getSubPackage().add(pkg);
		return pkg;
	}

	/**
	 * Get the possibly cached PrimitiveType corresponding to the given
	 * primitive.
	 * 
	 * @param primitive
	 * @return primitive type
	 */
	private PrimitiveType getPrimitiveType(Primitive primitive) {
		if (primitive == null)
			return null;
		for (PrimitiveType pt : system.getPrimitiveType())
			if (pt.getPrimitive().equals(primitive))
				return pt;
		PrimitiveType t = ModelFactory.eINSTANCE.createPrimitiveType();
		t.setName(primitive.getName());
		t.setDescription("Primitive type enclosure for primitive "
				+ primitive.getName());
		t.setSystem(system);
		t.setPrimitive(primitive);
		return t;
	}

	/**
	 * Get the FreeType for the typeName.
	 * 
	 * @param typeName
	 * @return free type
	 */
	private FreeType getFreeType(String typeName) {
		if (typeName == null)
			return null;
		for (FreeType ft : system.getFreeType())
			if (ft.getType().equals(typeName))
				return ft;
		FreeType t = ModelFactory.eINSTANCE.createFreeType();
		t.setName(typeName);
		t.setDescription("FreeType enclosure for type " + typeName);
		t.setSystem(system);
		t.setType(typeName);
		return t;
	}

	/**
	 * Create an Attribute for the class with the given name, type and optional
	 * list of enumerated values.
	 * 
	 * @param cls
	 * @param name
	 * @param type
	 * @param values
	 * @return attribute
	 */
	public Attribute createAttribute(model.Class cls, String name,
			Primitive type, String[] values) {
		Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
		attribute.setName(name);
		attribute.setType(getPrimitiveType(type));
		if (values != null)
			for (String value : values)
				attribute.getValues().add(value);
		cls.getAttribute().add(attribute);
		return attribute;
	}

	/**
	 * Create an Attribute for the Class with the given name and primitive type.
	 * 
	 * @param cls
	 * @param name
	 * @param type
	 * @return attribute
	 */
	public Attribute createAttribute(model.Class cls, String name,
			Primitive type) {
		return createAttribute(cls, name, type, null);
	}

	/**
	 * Create an Attribute of type Primitive.STRING for the Class with the given
	 * name and and enumerated values.
	 * 
	 * @param cls
	 * @param name
	 * @param values
	 * @return attribute
	 */
	public Attribute createAttribute(model.Class cls, String name,
			String[] values) {
		return createAttribute(cls, name, Primitive.STRING, values);
	}

	/**
	 * Create an Attribute of type Primitive.STRING for the Class with the given
	 * name and a null description.
	 * 
	 * @param cls
	 * @param name
	 * @return attribute
	 */
	public Attribute createAttribute(model.Class cls, String name) {
		return createAttribute(cls, name, Primitive.STRING, null);
	}

	/**
	 * Create a Class in the package with name and description. The class is
	 * nominated persistent to a table name with the same name as the name of
	 * the class.
	 * 
	 * @param pkg
	 * @param name
	 * @param description
	 * @return class
	 */
	public model.Class createClass(model.Package pkg, String name,
			String description) {
		return createClassWithTableName(pkg, name, description, null, true);
	}

	/**
	 * Create a Class in the package with name and description. The class is
	 * optionally nominated as persistent and if it is, the underlying table
	 * name for persisting the Class is as given.
	 * 
	 * @param pkg
	 * @param name
	 * @param description
	 * @param tableName
	 * @param persistent
	 * @return class
	 */
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

	/**
	 * Create an AssociationClass in the given package with name and
	 * description.
	 * 
	 * @param pkg
	 * @param name
	 * @param description
	 * @return asssociation class
	 */
	public AssociationClass createAssociationClass(model.Package pkg,
			String name, String description) {
		AssociationClass c = ModelFactory.eINSTANCE.createAssociationClass();
		c.setName(name);
		c.setDescription(description);
		createPersistence(c);
		c.setPackage(pkg);
		return c;
	}

	/**
	 * Create an identifier which will be the nominated JPA identifier for the
	 * Class (the attribute will be annotated @Id) that is optionally generated,
	 * and potentially by a sequence. The identifier is named "I". Craft
	 * Tracking System used generated by a sequence but not sure how it worked
	 * exactly.
	 * 
	 * @param a
	 * @param generated
	 * @param generatedBySequence
	 * @return persistence attribute
	 */
	private AttributePersistence createIdentifierPrimary(Attribute a,
			boolean generated, boolean generatedBySequence) {

		createIdentifierPrimary(a.getClass_(), "I", new Attribute[] { a });
		if (generated) {
			AttributePersistence p = a.getPersistence();
			p.setGeneratedValue(true);
			// TODO these two statements appear mutually exclusive, are they? I
			// assume they're in because of ecore limitations (or my limited
			// knowledge of ecore!)
			p.setGeneratedByIdentity(!generatedBySequence);
			p.setGeneratedBySequence(generatedBySequence);
		}
		return a.getPersistence();
	}

	/**
	 * Create a primary identifier on the attribute using the given generator.
	 * 
	 * @param attribute
	 * @param generator
	 * @return persistence attribute
	 */
	public AttributePersistence createIdentifierPrimary(Attribute attribute,
			Generator generator) {
		boolean generated = true;
		boolean generatedBySequence = false;
		if (generator.equals(Generator.GENERATED_BY_SEQUENCE))
			generatedBySequence = true;
		else if (generator.equals(Generator.NOT_GENERATED))
			generated = false;
		return createIdentifierPrimary(attribute, generated,
				generatedBySequence);
	}

	/**
	 * Create a non primary identifier using the given attributes(s).
	 * 
	 * @param cls
	 * @param attributes
	 * @return identifier 
	 */
	public IdentifierNonPrimary createIdentifierNonPrimary(model.Class cls,
			Attribute... attributes) {

		IdentifierNonPrimary id = ModelFactory.eINSTANCE
				.createIdentifierNonPrimary();
		id.setName(getNextIdentifierName(cls));
		cls.getIdentifierNonPrimary().add(id);
		for (Attribute attribute : attributes)
			id.getAttribute().add(attribute);
		return id;
	}

	/**
	 * Create an AssociationClass with an arbitrary primary identifier with the
	 * given name and description.
	 * 
	 * @param pkg
	 * @param name
	 * @param description
	 * @return association class
	 */
	public AssociationClass createAssociationClassWithArbitraryId(
			model.Package pkg, String name, String description) {
		AssociationClass cls = createAssociationClass(pkg, name, description);
		createIdentifierPrimary(createAttribute(cls, "id",
				Primitive.ARBITRARY_ID), generator);
		return cls;
	}

	/**
	 * Advance the identifier index for the Class and return "I" with the index
	 * as a suffix.
	 * 
	 * @param cls
	 * @return string
	 */
	private String getNextIdentifierName(model.Class cls) {
		if (identifierNumbers.get(cls) == null)
			identifierNumbers.put(cls, 0);
		identifierNumbers.put(cls, identifierNumbers.get(cls) + 1);
		return "I" + identifierNumbers.get(cls);
	}

	/**
	 * Setup persistence for the given Class. Use the Class name as the table
	 * name unless the Class name is a SQL reserved word according to the
	 * classpath resource /sql-reserved-words.txt. If so then concatenate the
	 * Class name with the word "Table" and convert camel case to lowercase with
	 * underscores. The schema is the default schema set by the constructor of
	 * SystemBase.
	 * 
	 * @param cls
	 * @return persistence class
	 */
	public ClassPersistence createPersistence(model.Class cls) {
		return createPersistence(cls, null);
	}

	/**
	 * Setup persistence for the given Class. If the tablename is null then use
	 * the Class name as the table name unless the Class name is a SQL reserved
	 * word according to the classpath resource /sql-reserved-words.txt. If so
	 * then concatenate the Class name with the word "Table" and convert camel
	 * case to lowercase with underscores. The schema is the default schema set
	 * by the constructor of SystemBase.
	 * 
	 * @param cls
	 * @param tableName
	 * @return persistence class
	 */
	public ClassPersistence createPersistence(model.Class cls, String tableName) {
		ClassPersistence persistence = ModelFactory.eINSTANCE
				.createClassPersistence();
		cls.setPersistence(persistence);
		if (tableName != null)
			persistence.setTable(tableName);
		else if (SqlReservedWords.getInstance().isReservedWord(cls.getName()))
			persistence.setTable(UnderscoreFilterWriter.underscore(cls
					.getName()
					+ "Table"));
		persistence.setSchema(schema);
		return persistence;
	}

	/**
	 * Create an Association with the given name between two Association Ends.
	 * 
	 * @param relationshipName
	 * @param primary
	 * @param secondary
	 * @return association
	 */
	public Association createAssociation(String relationshipName,
			AssociationEndPrimary primary, AssociationEndSecondary secondary) {

		Association a = ModelFactory.eINSTANCE.createAssociation();
		a.setPrimary(primary);
		a.setSecondary(secondary);
		a.setName(relationshipName);
		system.getAssociation().add(a);
		return a;
	}

	/**
	 * Create a referential attribute based on an association end and call it by
	 * the given name.
	 * 
	 * @param cls
	 * @param end
	 * @param name
	 * @return attribute
	 */
	public AttributeReferential createAttributeReferential(model.Class cls,
			AssociationEnd end, String name) {
		AttributeReferential a = ModelFactory.eINSTANCE
				.createAttributeReferential();
		a.setAssociationEnd(end);
		a.setClass(cls);
		a.setName(name);
		return a;
	}

	/**
	 * Create a primary identifier using the given attributes (including derived
	 * attributes) with the given name. If there is one attribute then the
	 * attribute is annotated with @Id. If not then a composite attribute is
	 * created in the class with @Embeddable annotation.
	 * 
	 * @param cls
	 * @param name
	 * @param attributes
	 * @param derivedAttributes
	 * @return identifier
	 */
	public IdentifierPrimary createIdentifierPrimary(model.Class cls,
			String name, Attribute[] attributes,
			AttributeReferential... derivedAttributes) {
		IdentifierPrimary identifierPrimary = ModelFactory.eINSTANCE
				.createIdentifierPrimary();
		identifierPrimary.setName(name);
		if (attributes != null)
			identifierPrimary.getAttribute().addAll(Arrays.asList(attributes));
		if (derivedAttributes != null)
			identifierPrimary.getAttributeReferential().addAll(
					Arrays.asList(derivedAttributes));
		cls.setIdentifierPrimary(identifierPrimary);
		for (Attribute attribute : attributes)
			initializeAttributePersistenceForPrimaryId(attribute);
		if (attributes.length > 1)
			throw new RuntimeException(
					"multiple attributes in primary id not supported yet.");
		if (derivedAttributes != null && derivedAttributes.length > 0)
			throw new RuntimeException(
					"derived attributes in primary id not supported yet.");
		return identifierPrimary;
	}

	/**
	 * Set the persistence field of the attribute assuming that the attribute is
	 * not generated by a sequence nor is a generated value.
	 * 
	 * @param attribute
	 */
	private void initializeAttributePersistenceForPrimaryId(Attribute attribute) {
		// need to set a persistence attribute for id fields
		if (attribute.getPersistence() == null) {
			AttributePersistence persistence = ModelFactory.eINSTANCE
					.createAttributePersistence();
			attribute.setPersistence(persistence);
			persistence.setGeneratedBySequence(false);
			persistence.setGeneratedValue(false);
		}
	}

	/**
	 * Create a non-primary identifier using the given attributes. This provides
	 * a unique constraint on the attributes as a group and does not apply @Id
	 * annotations to the attributes.
	 * 
	 * @param cls
	 * @param name
	 * @param attributes
	 * @param derivedAttributes
	 * @return identifier
	 */
	public IdentifierNonPrimary createIdentifierNonPrimary(model.Class cls,
			String name, Attribute[] attributes,
			AttributeReferential... derivedAttributes) {
		IdentifierNonPrimary identifierNonPrimary = ModelFactory.eINSTANCE
				.createIdentifierNonPrimary();
		identifierNonPrimary.setName(name);
		if (attributes != null)
			identifierNonPrimary.getAttribute().addAll(
					Arrays.asList(attributes));
		if (derivedAttributes != null)
			identifierNonPrimary.getAttributeReferential().addAll(
					Arrays.asList(derivedAttributes));
		cls.getIdentifierNonPrimary().add(identifierNonPrimary);
		return identifierNonPrimary;
	}

	/**
	 * Create a primary association end on Class cls with the given role,
	 * multiplicity and verb clause. Nomination of primary and secondary ends
	 * can be arbitrary.
	 * 
	 * @param cls
	 * @param role
	 * @param multiplicity
	 * @param verbClause
	 * @return association
	 */
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

	/**
	 * Create a primary association end on Class cls with a role corresponding
	 * to the name of the class (first letter uncapped) and the given
	 * multiplicity and verb clause. Nomination of primary and secondary ends
	 * can be arbitrary.
	 * 
	 * @param cls
	 * @param multiplicity
	 * @param verbClause
	 * @return association
	 */
	public AssociationEndPrimary createAssociationEndPrimary(model.Class cls,
			Multiplicity multiplicity, String verbClause) {
		return createAssociationEndPrimary(cls, StringUtil.uncapFirst(cls
				.getName()), multiplicity, verbClause);
	}

	/**
	 * Create a secondary association end on Class cls with the given role,
	 * multiplicity and verb clause. Nomination of primary and secondary ends
	 * can be arbitrary.
	 * 
	 * @param cls
	 * @param role
	 * @param multiplicity
	 * @param verbClause
	 * @return association
	 */
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

	/**
	 * Create a secondary association end on Class cls with a role corresponding
	 * to the name of the class (first letter uncapped) and the given
	 * multiplicity and verb clause. Nomination of primary and secondary ends
	 * can be arbitrary.
	 * 
	 * @param cls
	 * @param multiplicity
	 * @param verbClause
	 * @return association
	 */
	public AssociationEndSecondary createAssociationEndSecondary(
			model.Class cls, Multiplicity multiplicity, String verbClause) {
		return createAssociationEndSecondary(cls, StringUtil.uncapFirst(cls
				.getName()), multiplicity, verbClause);
	}

	/**
	 * Create an Operation on a class.
	 * 
	 * @param cls
	 *            the model Class to apply the operation to
	 * @param name
	 *            the name of the operation
	 * @param description
	 *            a description of the operation
	 * @param returns
	 *            the full java class name of the return type
	 * @param multiple
	 *            whether the return is multiple (an array)
	 * @param params
	 *            multiple paremeters
	 * @return operation
	 */
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

	/**
	 * Create a primitive parameter for an Event.
	 * 
	 * @param event
	 * @param name
	 *            the parameter name
	 * @param description
	 *            the parameter description
	 * @param primitive
	 *            the type of the parameter
	 * @return parameter for the Event
	 */
	public Parameter createParameter(Event event, String name,
			String description, Primitive primitive) {
		Parameter p = createParameter(name, description, primitive);
		event.getParameter().add(p);
		return p;
	}

	/**
	 * Create a freely typed parameter.
	 * 
	 * @param name
	 * @param description
	 * @param type
	 *            the full java class name of the type
	 * @return parameter
	 */
	public Parameter createParameter(String name, String description,
			String type) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getFreeType(type));
		return p;
	}

	/**
	 * Create a String parameter
	 * 
	 * @param name
	 * @param description
	 * @return parameter
	 */
	public Parameter createParameter(String name, String description) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getPrimitiveType(Primitive.STRING));
		return p;
	}

	/**
	 * Create a primitive parameter
	 * 
	 * @param name
	 * @param description
	 * @param primitive
	 * @return parameter
	 */
	public Parameter createParameter(String name, String description,
			Primitive primitive) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getPrimitiveType(primitive));
		return p;
	}

	/**
	 * Setup a state machine for a class with an initial state called
	 * "InitialState" and a final state called "FinalState".
	 * 
	 * @param cls
	 * @return state machine
	 */
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

	/**
	 * Create a state for the Class. Creates the state machine for the class if
	 * not created already and then adds the created state to the state machine.
	 * 
	 * @param cls
	 * @param name
	 *            the name of the state
	 * @return state
	 */
	public State createState(model.Class cls, String name) {
		createStateMachine(cls);
		State state = ModelFactory.eINSTANCE.createState();
		state.setName(name);
		cls.getStateMachine().getState().add(state);
		return state;
	}

	/**
	 * Create a signal event for the Class. Creates the state machine for the
	 * class if not created already and then adds the created signal event to
	 * the state machine.
	 * 
	 * @param cls
	 * @param name
	 *            the name of the signal event
	 * @return signal event
	 */
	public SignalEvent createSignalEvent(model.Class cls, String name) {
		createStateMachine(cls);
		SignalEvent event = ModelFactory.eINSTANCE.createSignalEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	/**
	 * Create a call event for the Class. Creates the state machine for the
	 * class if not created already and then adds the created call event to the
	 * state machine.
	 * 
	 * @param cls
	 * @param name
	 *            the name of the call event
	 * @return call event
	 */
	public CallEvent createCallEvent(model.Class cls, String name) {
		createStateMachine(cls);
		CallEvent event = ModelFactory.eINSTANCE.createCallEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	/**
	 * Create a timer event for the Class. Creates the state machine for the
	 * class if not created already and then adds the created timer event to the
	 * state machine.
	 * 
	 * @param cls
	 * @param name
	 *            the name of the timer event
	 * @return timer event
	 */
	public TimerEvent createTimerEvent(model.Class cls, String name) {
		createStateMachine(cls);
		TimerEvent event = ModelFactory.eINSTANCE.createTimerEvent();
		event.setName(name);
		cls.getStateMachine().getEvent().add(event);
		return event;
	}

	/**
	 * Create a transition from state1 to state2 via an event
	 * 
	 * @param state1
	 * @param state2
	 * @param event
	 */
	public void createTransition(FromState state1, ToState state2, Event event) {
		Transition t = ModelFactory.eINSTANCE.createTransition();
		t.setName(state1.getName() + "_" + event.getName() + "_"
				+ state2.getName());
		t.setFromState(state1);
		t.setToState(state2);
		t.setEvent(event);
	}

	/**
	 * Create a parameter for an event with a free type.
	 * 
	 * @param event
	 * @param name
	 *            the name of the parameter
	 * @param type
	 *            java class name of type
	 * @return parameter
	 */
	public Parameter createParameter(Event event, String name, String type) {
		Parameter parameter = ModelFactory.eINSTANCE.createParameter();
		parameter.setName(name);
		parameter.setType(getFreeType(type));
		event.getParameter().add(parameter);
		return parameter;
	}

	/**
	 * Create a string parameter for an event
	 * 
	 * @param event
	 * @param name
	 *            the name of the parameter
	 * @return parameter
	 */
	public Parameter createParameter(Event event, String name) {
		return createParameter(event, name, "String");
	}

	/**
	 * Create a System
	 * 
	 * @param name
	 *            the name of the system
	 * @return the System
	 */
	public static System createSystem(String name) {
		System system = ModelFactory.eINSTANCE.createSystem();
		system.setName(name);
		return system;
	}

	/**
	 * Set the default ordering for a query result via an association. Order is
	 * ascending by the given attributes.
	 * 
	 * @param ae
	 * @param attributes
	 * @return association
	 */
	public AssociationEndPersistence createOrderBy(AssociationEnd ae,
			Attribute... attributes) {
		AssociationEndPersistence aspect = ModelFactory.eINSTANCE
				.createAssociationEndPersistence();
		for (Attribute a : attributes)
			aspect.getOrderBy().add(a);
		ae.setPersistence(aspect);
		return aspect;
	}

	/**
	 * Create an Attribute that at implementation time will correspond to a
	 * single indexed column.
	 * 
	 * @param cls
	 *            the Class of the attribute
	 * @param name
	 *            the name of the attribute
	 * @param type
	 *            the type of the attribute
	 * @return attribute
	 */
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

	/**
	 * Create a class with null persistence field. This might be used as a
	 * parameter to an Operation.
	 * 
	 * @param pkg
	 * @param name
	 * @param description
	 * @return class
	 */
	public Class createClassNonPersistent(Package pkg, String name,
			String description) {
		return createClassWithTableName(pkg, name, description, name, false);
	}

	/**
	 * Create a specialization group.
	 * 
	 * @param cls
	 * @param name
	 * @param description
	 * @return specialization group
	 */
	public SpecializationGroup createSpecializationGroup(Class cls,
			String name, String description) {
		SpecializationGroup group = ModelFactory.eINSTANCE
				.createSpecializationGroup();
		group.setName(name);
		group.setDescription(description);
		group.setGeneralization(cls);
		return group;
	}

	/**
	 * Create a specialization.
	 * 
	 * @param group
	 * @param pkg
	 * @param name
	 * @param description
	 * @return specialization
	 */
	public Specialization createSpecialization(SpecializationGroup group,
			Package pkg, String name, String description) {
		Specialization s = ModelFactory.eINSTANCE.createSpecialization();
		s.setName(name);
		s.setDescription(description);
		s.setPackage(pkg);
		s.getGroup().add(group);
		createPersistence(s, null);
		return s;
	}

	/**
	 * Set the default Generator.
	 * 
	 * @param generator
	 */
	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	/**
	 * Get the default generator.
	 * 
	 * @return generator
	 */
	public Generator getGenerator() {
		return this.generator;
	}

	/**
	 * Create a class with an arbitrary id.
	 * 
	 * @param pkg
	 *            the package of the class
	 * @param name
	 *            the name of the class
	 * @param description
	 *            description of the class
	 * @return class
	 */
	public Class createClassWithArbitraryId(Package pkg, String name,
			String description) {
		Class cls = createClass(pkg, name, description);
		createArbitraryId(cls);
		return cls;
	}

	/**
	 * Create an arbitrary id on a class.
	 * 
	 * @param cls
	 * @return persistence attribute
	 */
	public AttributePersistence createArbitraryId(Class cls) {
		return createIdentifierPrimary(createAttribute(cls, "id",
				Primitive.ARBITRARY_ID), generator);
	}

	/**
	 * Get the schema.
	 * 
	 * @return string
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * Get the system.
	 * 
	 * @return system
	 */
	public System getSystem() {
		return system;
	}

	@Override
	public void generate(String outputDirectoryFilename,
			String resourcesDirectoryFilename, String webDirectoryFilename,
			String docsDirectoryFilename) throws Exception {
		File outputDirectory = new File(outputDirectoryFilename);
		outputDirectory.mkdirs();
		Compiler compiler = new Compiler(getSystem(), outputDirectory,
				new File(resourcesDirectoryFilename), new File(
						webDirectoryFilename), new File(docsDirectoryFilename));
		compiler.compile();
	}

	/**
	 * View the system.
	 * 
	 * @param settingsFilename
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void view(String settingsFilename) throws NumberFormatException,
			IOException {
		SystemViewer viewer = new SystemViewer(getSystem(), settingsFilename);
		viewer.showViewer();
	}

	/**
	 * Serialize the system to the given file in xmi format.
	 * 
	 * @param filename
	 */
	public void save(String filename) {
		try {
			// Register the XMI resource factory for the extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put(SYSTEM_DEFINITION_EXTENSION, new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();

			// set up save options
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			// Create a resource
			Resource resource = resSet.createResource(URI.createURI(filename));
			resource.getContents().add(getSystem());
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			resource.save(bytes, options);
			String s = bytes.toString();
			String xmlns = "xmlns:model=\"http://davidmoten.homeip.net/uml/executable/model\"";
			String schemaLocation = "xsi:schemaLocation=\"http://davidmoten.homeip.net/uml/executable/model http://xuml-compiler.googlecode.com/svn/trunk/xUmlMetaModel/model/uml.ecore\"";
			s = s.replace(xmlns, xmlns + " " + schemaLocation);
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(s.getBytes());
			fos.close();
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public static class ValidationException extends Exception {

		private static final long serialVersionUID = -7935781336267397766L;
		private Diagnostic diagnostic;

		public ValidationException(Diagnostic diagnostic) {
			this.diagnostic = diagnostic;
		}

		public Diagnostic getDiagnostic() {
			return diagnostic;
		}

		public void setDiagnostic(Diagnostic diagnostic) {
			this.diagnostic = diagnostic;
		}

		@Override
		public String getMessage() {
			StringBuffer s = new StringBuffer();
			for (Diagnostic d : diagnostic.getChildren())
				s.append(d.getMessage() + "\n");
			return s.toString();
		}

	}

	/**
	 * Validate the system.
	 * 
	 * @throws ValidationException
	 */
	public void validate() throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(system);
		if (diagnostic.getSeverity() == Diagnostic.ERROR)
			throw new ValidationException(diagnostic);
	}
	
	public static void copy(InputStream in, OutputStream out) throws IOException {
	    byte[] buffer = new byte[8192];
	    int n;
	    while ((n = in.read(buffer)) != -1) {
	        out.write(buffer, 0, n);
	    }
	}

	/**
	 * Load the system from an xmi input stream.
	 * 
	 * @param is
	 * @return system
	 */
	public static System load(InputStream is) {
		try {
			File file = File
					.createTempFile("Temp", SYSTEM_DEFINITION_EXTENSION);
			FileOutputStream fos = new FileOutputStream(file);
			copy(is, fos);
			fos.close();
			is.close();
			return load(file.getAbsolutePath());
		} catch (IOException e) {
			throw new Error(e);
		}
	}

	/**
	 * Load the system from a URI in xmi format.
	 * 
	 * @param uri
	 * @return system
	 */
	public static System load(URI uri) {
		// Register the XMI resource factory for the extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(SYSTEM_DEFINITION_EXTENSION, new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		{
			// perform some trickery to get the ViewPackage to be loaded
			// this is a workaround for an ecore problem with instantiation
			// of ViewPackage
			System temp = ModelFactory.eINSTANCE.createSystem();
			Resource resource = new ResourceSetImpl().createResource(URI
					.createURI("unused." + "." + SYSTEM_DEFINITION_EXTENSION));
			resource.getContents().add(temp);
			resource.getContents().remove(temp);
		}

		// Get the resource
		Resource resource = resSet.getResource(uri, true);
		System system = (System) resource.getContents().get(0);
		return system;
	}

	/**
	 * Load the system from a file in xmi format.
	 * 
	 * @param filename
	 * @return system
	 */
	public static System load(String filename) {
		if (!new File(filename).exists())
			throw new Error("file not found: " + filename);
		try {
			return load(URI.createURI(filename));
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}
