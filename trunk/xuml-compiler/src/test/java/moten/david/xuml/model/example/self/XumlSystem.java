package moten.david.xuml.model.example.self;

import java.io.IOException;

import model.Class;
import model.Package;
import model.Specialization;
import model.SpecializationGroup;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.util.SystemBase;

public class XumlSystem extends SystemBase {

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

	public XumlSystem() {
		super("self", "Self");
		initialize();
	}

	private void initialize() {
		pkg = createRootPackage("self", "xUmlCompiler metamodel");
		createClassWithArbitraryId(pkg, "Package", "");
		cls = createClassWithArbitraryId(pkg, "Class", "");
		association = createClassWithArbitraryId(pkg, "Association", "");
		associationEnd = createClassWithArbitraryId(pkg, "AssociationEnd", "");
		SpecializationGroup group1 = createSpecializationGroup(associationEnd,
				"ends", "");
		associationEndPrimary = createSpecialization(group1, pkg,
				"AssociationEndPrimary", "");
		associationEndSecondary = createSpecialization(group1, pkg,
				"AssociationEndSecondary", "");

		attribute = createClassWithArbitraryId(pkg, "Attribute", "");
		SpecializationGroup group3 = createSpecializationGroup(attribute,
				attribute.getName(), "");
		attributeNormal = createSpecialization(group3, pkg, "AttributeNormal",
				"");
		attributeReferential = createSpecialization(group3, pkg,
				"AttributeReferential", "");

		operation = createClassWithArbitraryId(pkg, "Operation", "");
		identifier = createClassWithArbitraryId(pkg, "Identifier", "");
		SpecializationGroup group2 = createSpecializationGroup(identifier,
				identifier.getName(), "");
		identifierPrimary = createSpecialization(group2, pkg,
				"IdentifierPrimary", "");
		identifierNonPrimary = createSpecialization(group2, pkg,
				"IdentifierNonPrimary", "");
		specializationGroup = createClassWithArbitraryId(pkg,
				"SpecializationGroup", "");
		associationClass = createClassWithArbitraryId(pkg, "AssociationClass",
				"");
		createAssociation("R1", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "is in"), createAssociationEndSecondary(
				attribute, Multiplicity.MANY, "has"));
		createAssociation("R3", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "is in"), createAssociationEndSecondary(
				operation, Multiplicity.MANY, "has"));
		createAssociation("R4", createAssociationEndPrimary(cls,
				Multiplicity.ONE, "identifies uniquely an instance of"),
				createAssociationEndSecondary(identifier, Multiplicity.ONE,
						"instance is uniquely referenced by"));
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

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		XumlSystem system = new XumlSystem();
		system.view("src/viewer/xuml.ecore");
	}
}
