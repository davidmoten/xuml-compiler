package moten.david.xuml.model.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import org.apache.log4j.lf5.util.StreamUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

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
	 * Create root package with a name and description. TODO: document how to
	 * use name with dot delimiters. Have only tested one word package names.
	 * 
	 * @param name
	 * @param description
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * Class (the attribute will be annotated @Id) that is optionally generated
	 * 
	 * @param a
	 * @param generated
	 * @param generatedBySequence
	 * @return
	 */
	private AttributePersistence createIdentifierPrimary(Attribute a,
			boolean generated, boolean generatedBySequence) {

		createIdentifierPrimary(a.getClass_(), "I", new Attribute[] { a });
		return a.getPersistence();
	}

	public AttributePersistence createIdentifierPrimary(Attribute a,
			Generator generator) {
		boolean generated = true;
		boolean generatedBySequence = false;
		if (generator.equals(Generator.GENERATED_BY_SEQUENCE))
			generatedBySequence = true;
		else if (generator.equals(Generator.NOT_GENERATED))
			generated = false;
		return createIdentifierPrimary(a, generated, generatedBySequence);
	}

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

	public AssociationClass createAssociationClassWithArbitraryId(
			model.Package pkg, String name, String description) {
		AssociationClass cls = createAssociationClass(pkg, name, description);
		createIdentifierPrimary(createAttribute(cls, "id",
				Primitive.ARBITRARY_ID), generator);
		return cls;
	}

	private String getNextIdentifierName(model.Class cls) {
		if (identifierNumbers.get(cls) == null)
			identifierNumbers.put(cls, 0);
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
		if (tableName != null)
			persistence.setTable(tableName);
		else if (SqlReservedWords.getInstance().isReservedWord(cls.getName()))
			persistence.setTable(UnderscoreFilterWriter.underscore(cls
					.getName()
					+ "Table"));
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

	public AttributeReferential createAttributeReferential(model.Class cls,
			AssociationEnd end, String name) {
		AttributeReferential a = ModelFactory.eINSTANCE
				.createAttributeReferential();
		a.setAssociationEnd(end);
		a.setClass(cls);
		a.setName(name);
		return a;
	}

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

	public Parameter createParameter(Event event, String name,
			String description, Primitive primitive) {
		Parameter p = createParameter(name, description, primitive);
		event.getParameter().add(p);
		return p;
	}

	public Parameter createParameter(String name, String description,
			String type) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getFreeType(type));
		return p;
	}

	public Parameter createParameter(String name, String description) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getPrimitiveType(Primitive.STRING));
		return p;
	}

	public Parameter createParameter(String name, String description,
			Primitive primitive) {
		Parameter p = ModelFactory.eINSTANCE.createParameter();
		p.setName(name);
		p.setDescription(description);
		p.setType(getPrimitiveType(primitive));
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
		t.setName(state1.getName() + "_" + event.getName() + "_"
				+ state2.getName());
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
		for (Attribute a : attributes)
			aspect.getOrderBy().add(a);
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
		group.setGeneralization(cls);
		return group;
	}

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

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public Generator getGenerator() {
		return this.generator;
	}

	public Class createClassWithArbitraryId(Package pkg, String name,
			String description) {
		Class cls = createClass(pkg, name, description);
		createArbitraryId(cls);
		return cls;
	}

	public AttributePersistence createArbitraryId(Class cls) {
		return createIdentifierPrimary(createAttribute(cls, "id",
				Primitive.ARBITRARY_ID), generator);
	}

	public String getSchema() {
		return schema;
	}

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

	public void view(String settingsFilename) throws NumberFormatException,
			IOException {
		SystemViewer viewer = new SystemViewer(getSystem(), settingsFilename);
		viewer.showViewer();
	}

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

	public void validate() throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(system);
		if (diagnostic.getSeverity() == Diagnostic.ERROR)
			throw new ValidationException(diagnostic);
	}

	public static System load(InputStream is) {
		try {
			File file = File
					.createTempFile("Temp", SYSTEM_DEFINITION_EXTENSION);
			FileOutputStream fos = new FileOutputStream(file);
			StreamUtils.copy(is, fos);
			fos.close();
			is.close();
			return load(file.getAbsolutePath());
		} catch (IOException e) {
			throw new Error(e);
		}
	}

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
