package moten.david.xuml.model.example.specialize;

import java.io.IOException;

import model.Class;
import model.Package;
import model.Specialization;
import model.SpecializationGroup;
import moten.david.xuml.model.util.SystemBase;

public class Specialize extends SystemBase {

	public Specialize() {
		super("Specialize", "Specialize");
		initialize();
	}

	private void initialize() {
		Package pkg = createRootPackage("specialize", "specialization package");
		Class book = createClassWithArbitraryId(pkg, "Writing", "");
		SpecializationGroup group1 = createSpecializationGroup(book, "R1",
				"specialization of book");

		Specialization fiction = createSpecialization(group1, pkg, "Fiction",
				"");
		createArbitraryId(fiction);
		Specialization nonFiction = createSpecialization(group1, pkg,
				"NonFiction", "");
		createArbitraryId(nonFiction);

		SpecializationGroup group2 = createSpecializationGroup(book, "R2",
				"specialization of book");
		Specialization hardCover = createSpecialization(group2, pkg,
				"HardCover", "");
		createArbitraryId(hardCover);
		Specialization softCover = createSpecialization(group2, pkg,
				"SoftCover", "");
		createArbitraryId(softCover);
		Specialization electronicEdition = createSpecialization(group2, pkg,
				"ElectronicEdition", "");
		createArbitraryId(electronicEdition);

		SpecializationGroup group3 = createSpecializationGroup(
				electronicEdition, "R3", "specialization of electronic edition");
		Specialization pdf = createSpecialization(group3, pkg, "ElectronicPdf",
				"");
		createArbitraryId(pdf);
		Specialization doc = createSpecialization(group3, pkg, "ElectronicDoc",
				"");
		createArbitraryId(doc);
		Specialization text = createSpecialization(group3, pkg,
				"ElectronicText", "");
		createArbitraryId(text);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Specialize specialize = new Specialize();
		specialize.view("src/viewer/Specialize.ecore");
	}

}
