package moten.david.xuml.model.example.self;

import java.io.IOException;

import model.Class;
import model.Package;
import model.Specialization;
import model.SpecializationGroup;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.util.SystemBase;

public class Self extends SystemBase {

	private Package rootPackage;
	private Class clazz;
	private Class association;
	private Class associationEnd;
	private Specialization associationEndPrimary;
	private Specialization associationEndSecondary;
	private Class attributeNormal;
	private Class attributeReferential;
	private Class operation;
	private Class identifier;
	private Class specializationGroup;
	private Class attribute;
	private Class pkg;
	private Class operationSignature;
	private Class dataType;
	private Class parameter;
	private Class state;
	private Class stateMachine;
	private Class initialState;
	private Specialization fromState;
	private Specialization terminatingState;
	private Specialization abstractClass;
	private Specialization concreteClass;
	private Class transition;
	private Class event;

	public Self() {
		super("self", "Self");
		initialize();
	}

	private void initialize() {
		rootPackage = createRootPackage("self", "xUmlCompiler metamodel");
		pkg = createClassWithArbitraryId(rootPackage, "Pkg", "");
		createAttribute(pkg, "name");
		createAttribute(pkg, "description");
		clazz = createClassWithArbitraryId(rootPackage, "Clazz", "");
		createAttribute(clazz, "name");
		createAttribute(clazz, "description");
		SpecializationGroup classSp = createSpecializationGroup(clazz, "R26",
				"");
		abstractClass = createSpecialization(classSp, rootPackage,
				"AbstractClass", "");
		concreteClass = createSpecialization(classSp, rootPackage,
				"ConcreteClass", "");
		association = createClassWithArbitraryId(rootPackage, "Association", "");
		associationEnd = createClassWithArbitraryId(rootPackage,
				"AssociationEnd", "");
		SpecializationGroup group1 = createSpecializationGroup(associationEnd,
				"R18", "");
		associationEndPrimary = createSpecialization(group1, rootPackage,
				"AssociationEndPrimary", "");
		associationEndSecondary = createSpecialization(group1, rootPackage,
				"AssociationEndSecondary", "");

		attribute = createClassWithArbitraryId(rootPackage, "Attribute", "");
		SpecializationGroup group3 = createSpecializationGroup(attribute,
				"R19", "");
		attributeNormal = createSpecialization(group3, rootPackage,
				"AttributeNormal", "");
		attributeReferential = createSpecialization(group3, rootPackage,
				"AttributeReferential", "");

		operation = createClassWithArbitraryId(rootPackage, "Operation", "");
		identifier = createClassWithArbitraryId(rootPackage, "Identifier", "");
		specializationGroup = createClassWithArbitraryId(rootPackage,
				"SpecializationGroup", "");
		SpecializationGroup assClassGroup = createSpecializationGroup(clazz,
				"R28", "");
		Specialization associationClass = createSpecialization(assClassGroup,
				rootPackage, "AssociationClass", "");
		operationSignature = createClassWithArbitraryId(rootPackage,
				"OperationSignature", "");
		dataType = createClassWithArbitraryId(rootPackage, "DataType", "");
		parameter = createClassWithArbitraryId(rootPackage, "Parameter", "");
		stateMachine = createClassWithArbitraryId(rootPackage, "StateMachine",
				"");
		state = createClassWithArbitraryId(rootPackage, "State", "");
		SpecializationGroup group5 = createSpecializationGroup(state, "R24", "");
		fromState = createSpecialization(group5, rootPackage, "FromState", "");
		terminatingState = createSpecialization(group5, rootPackage,
				"TerminatingState", "");
		SpecializationGroup group6 = createSpecializationGroup(fromState,
				"R26", "");
		initialState = createSpecialization(group6, rootPackage,
				"InitialState", "");

		SpecializationGroup group4 = createSpecializationGroup(dataType, "R21",
				"");
		createSpecialization(group4, rootPackage, "FreeType", "");
		createSpecialization(group4, rootPackage, "PrimitiveType", "");
		transition = createClassWithArbitraryId(rootPackage, "Transition", "");

		event = createClassWithArbitraryId(rootPackage, "Event", "");
		SpecializationGroup group7 = createSpecializationGroup(event, "R34", "");
		createSpecialization(group7, rootPackage, "CallEvent", "");
		createSpecialization(group7, rootPackage, "TimerEvent", "");
		createSpecialization(group7, rootPackage, "SignalEvent", "");
		createSpecialization(group7, rootPackage, "ChangeEvent", "");

		createAssociation("R1", createAssociationEndPrimary(clazz,
				Multiplicity.ONE, "is in"), createAssociationEndSecondary(
				attribute, Multiplicity.MANY, "has"));
		createAssociation("R3", createAssociationEndPrimary(clazz,
				Multiplicity.ONE, "operates on"),
				createAssociationEndSecondary(operation, Multiplicity.MANY,
						"is operated on by"));
		createAssociation("R4", createAssociationEndPrimary(clazz,
				Multiplicity.ONE, "identifies uniquely an instance of"),
				createAssociationEndSecondary(identifier, Multiplicity.ONE,
						"instance is uniquely referenced by"));
		createAssociation("R7", createAssociationEndPrimary(abstractClass,
				Multiplicity.ONE, "is specialization of"),
				createAssociationEndSecondary(specializationGroup,
						Multiplicity.ONE_MANY, "is generalization of"));
		createAssociation("R8", createAssociationEndPrimary(association,
				Multiplicity.ONE, "describes"), createAssociationEndSecondary(
				associationClass, Multiplicity.ZERO_ONE, "is described by"));
		createAssociation("R9", createAssociationEndPrimary(association,
				Multiplicity.ONE, "describes"),
				createAssociationEndSecondary(associationEndPrimary,
						Multiplicity.ZERO_ONE, "is described by"));
		createAssociation("R10", createAssociationEndPrimary(association,
				Multiplicity.ONE, "describes"), createAssociationEndSecondary(
				associationEndSecondary, Multiplicity.ZERO_ONE,
				"is described by"));
		createAssociation("R11", createAssociationEndPrimary(clazz,
				Multiplicity.ONE, "has"), createAssociationEndSecondary(
				associationEnd, Multiplicity.MANY, "participates via"));
		createAssociation("R12", createAssociationEndPrimary(identifier,
				Multiplicity.ONE, "has"), createAssociationEndSecondary(
				attribute, Multiplicity.MANY, "participates via"));
		createAssociation("R13", createAssociationEndPrimary(clazz,
				Multiplicity.MANY, "has"), createAssociationEndSecondary(pkg,
				Multiplicity.ONE, "belongs to"));
		createAssociation("R14", createAssociationEndPrimary(pkg,
				"parentPackage", Multiplicity.ONE, "has parent"),
				createAssociationEndSecondary(pkg, "childPackage",
						Multiplicity.MANY, "has child"));
		createAssociation("R15", createAssociationEndPrimary(operation,
				Multiplicity.ZERO_ONE, "describes"),
				createAssociationEndSecondary(operationSignature,
						Multiplicity.ONE, "is described by"));
		createAssociation("R16", createAssociationEndPrimary(
				operationSignature, Multiplicity.ZERO_ONE, "parameterizes"),
				createAssociationEndSecondary(parameter, Multiplicity.MANY,
						"has"));
		createAssociation("R17", createAssociationEndPrimary(parameter,
				Multiplicity.ZERO_ONE, "classifies"),
				createAssociationEndSecondary(dataType, Multiplicity.ONE,
						"is classified by"));
		createAssociation("R22", createAssociationEndPrimary(attribute,
				Multiplicity.MANY, "classifies"),
				createAssociationEndSecondary(dataType, Multiplicity.ONE,
						"is classified by"));
		createAssociation("R23", createAssociationEndPrimary(clazz,
				Multiplicity.ONE, "describes state-dependent behaviour of"),
				createAssociationEndSecondary(stateMachine,
						Multiplicity.ZERO_ONE, "has state-dependent behaviour"));
		createAssociation("R25", createAssociationEndPrimary(stateMachine,
				Multiplicity.ONE, "starts"), createAssociationEndSecondary(
				initialState, Multiplicity.ONE, "is initially at"));
		createAssociation("R27", createAssociationEndPrimary(stateMachine,
				Multiplicity.ONE, "finalizes"), createAssociationEndSecondary(
				terminatingState, Multiplicity.ZERO_ONE, "is finalized by"));
		createAssociation("R29", createAssociationEndPrimary(
				specializationGroup, Multiplicity.MANY,
				"is a specialization in"), createAssociationEndSecondary(clazz,
				Multiplicity.ONE_MANY, "has specialization"));
		createAssociation("R30", createAssociationEndPrimary(
				attributeReferential, Multiplicity.MANY, "is referred to by"),
				createAssociationEndSecondary(attributeNormal,
						Multiplicity.ONE, "refers to"));
		createAssociation("R31", createAssociationEndPrimary(stateMachine,
				Multiplicity.ONE, "belongs to"), createAssociationEndSecondary(
				transition, Multiplicity.MANY, "has"));
		createAssociation("R32", createAssociationEndPrimary(transition,
				Multiplicity.ONE_MANY, "transits via"),
				createAssociationEndSecondary(fromState, Multiplicity.ONE,
						"starts at"));
		createAssociation("R33", createAssociationEndPrimary(transition,
				Multiplicity.ONE_MANY, "is arrived at via"),
				createAssociationEndSecondary(state, Multiplicity.ONE,
						"transits to"));
		createAssociation("R35", createAssociationEndPrimary(transition,
				Multiplicity.MANY, "initiates"), createAssociationEndSecondary(
				event, Multiplicity.ONE, "is initiated by"));
		createAssociation("R36", createAssociationEndPrimary(event,
				Multiplicity.MANY, "parameterizes"),
				createAssociationEndSecondary(parameter, Multiplicity.MANY,
						"has"));
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Self system = new Self();
		system.view("src/viewer/Self.ecore");
	}
}
