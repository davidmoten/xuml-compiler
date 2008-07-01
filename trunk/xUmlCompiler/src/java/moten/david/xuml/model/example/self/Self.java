package moten.david.xuml.model.example.self;

import java.io.IOException;

import model.Class;
import model.Package;
import model.Specialization;
import model.SpecializationGroup;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.util.SystemBase;

public class Self extends SystemBase {

	private Package pkg;
	private Class cls;
	private Class association;
	private Class associationEnd;
	private Specialization associationEndPrimary;
	private Specialization associationEndSecondary;
	private Class attributeNormal;
	private Class attributeReferential;
	private Class operation;
	private Class identifier;
	private Specialization identifierPrimary;
	private Specialization identifierNonPrimary;
	private Class specializationGroup;
	private Class associationClass;
	private Class attribute;
	private Class packageClass;
	private Class operationSignature;
	private Class type;
	private Class parameter;

	public Self() {
		super("self", "Self");
		initialize();
	}

	private void initialize() {
		pkg = createRootPackage("self", "xUmlCompiler metamodel");
		packageClass = createClassWithArbitraryId(pkg, "Package", "");
		cls = createClassWithArbitraryId(pkg, "Class", "");
		association = createClassWithArbitraryId(pkg, "Association", "");
		associationEnd = createClassWithArbitraryId(pkg, "AssociationEnd", "");
		SpecializationGroup group1 = createSpecializationGroup(associationEnd,
				"R18", "");
		associationEndPrimary = createSpecialization(group1, pkg,
				"AssociationEndPrimary", "");
		associationEndSecondary = createSpecialization(group1, pkg,
				"AssociationEndSecondary", "");

		attribute = createClassWithArbitraryId(pkg, "Attribute", "");
		SpecializationGroup group3 = createSpecializationGroup(attribute,
				"R19", "");
		attributeNormal = createSpecialization(group3, pkg, "AttributeNormal",
				"");
		attributeReferential = createSpecialization(group3, pkg,
				"AttributeReferential", "");

		operation = createClassWithArbitraryId(pkg, "Operation", "");
		identifier = createClassWithArbitraryId(pkg, "Identifier", "");
		SpecializationGroup group2 = createSpecializationGroup(identifier,
				"R20", "");
		identifierPrimary = createSpecialization(group2, pkg,
				"IdentifierPrimary", "");
		identifierNonPrimary = createSpecialization(group2, pkg,
				"IdentifierNonPrimary", "");
		specializationGroup = createClassWithArbitraryId(pkg,
				"SpecializationGroup", "");
		associationClass = createClassWithArbitraryId(pkg, "AssociationClass",
				"");
		operationSignature = createClassWithArbitraryId(pkg,
				"OperationSignature", "");
		type = createClassWithArbitraryId(pkg, "Type", "");
		parameter = createClassWithArbitraryId(pkg, "Parameter", "");

		SpecializationGroup group4 = createSpecializationGroup(type, "R21", "");
		createSpecialization(group4, pkg, "FreeType", "");
		createSpecialization(group4, pkg, "PrimitiveType", "");

		createAssociation("R1", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "is in"), createAssociationEndSecondary(
				attribute, Multiplicity.MANY, "has"));
		createAssociation("R3", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "operates on"),
				createAssociationEndSecondary(operation, Multiplicity.MANY,
						"is operated on by"));
		createAssociation("R4", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "identifies uniquely an instance of"),
				createAssociationEndSecondary(identifier, Multiplicity.ONE,
						"instance is uniquely referenced by"));
		createAssociation("R2", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "is the primary id for"),
				createAssociationEndSecondary(identifierPrimary,
						Multiplicity.ONE, "is primarily identified by"));
		createAssociation("R7", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "is specialization of"),
				createAssociationEndSecondary(specializationGroup,
						Multiplicity.MANY, "is generalization of"));
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
		createAssociation("R11", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "has"), createAssociationEndSecondary(
				associationEnd, Multiplicity.MANY, "participates via"));
		createAssociation("R12", createAssociationEndPrimary(identifier,
				Multiplicity.ONE, "has"), createAssociationEndSecondary(
				attribute, Multiplicity.MANY, "participates via"));
		createAssociation("R13", createAssociationEndPrimary(cls,
				Multiplicity.MANY, "has"), createAssociationEndSecondary(
				packageClass, Multiplicity.ONE, "belongs to"));
		createAssociation("R14", createAssociationEndPrimary(packageClass,
				Multiplicity.ONE, "has parent"), createAssociationEndSecondary(
				packageClass, Multiplicity.MANY, "has child"));
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
				createAssociationEndSecondary(type, Multiplicity.ONE,
						"is classified by"));
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Self system = new Self();
		system.view("src/viewer/Self.ecore");
	}
}
