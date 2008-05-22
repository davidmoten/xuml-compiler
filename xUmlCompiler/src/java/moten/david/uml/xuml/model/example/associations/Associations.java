package moten.david.uml.xuml.model.example.associations;

import java.io.File;
import java.io.IOException;

import model.Class;
import model.Package;
import model.System;
import moten.david.uml.xuml.model.CodeGenerator;
import moten.david.uml.xuml.model.Generator;
import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.compiler.Compiler;
import moten.david.uml.xuml.model.compiler.util.Util;
import moten.david.uml.xuml.model.util.SystemBase;

import org.apache.log4j.Logger;

import freemarker.template.TemplateException;

public class Associations implements CodeGenerator {

	private static Logger log = Logger.getLogger(Associations.class);

	private static int counter = 0;

	public System getSystem(Multiplicity aMultiplicity,
			Multiplicity bMultiplicity) {
		String systemName = "Associations";
		String schema = aMultiplicity.toString() + "_TO_"
				+ bMultiplicity.toString();
		SystemBase u = new SystemBase(schema, systemName);
		Package pkg = u.createRootPackage(schema.toLowerCase(), "test system");
		Class a = u.createClass(pkg, "A" + ++counter, "first table");
		u.createPrimaryKey(u.createAttribute(a, "id"),
				Generator.GENERATED_VALUE);
		Class b = u.createClass(pkg, "B" + counter, "second table");
		u.createPrimaryKey(u.createAttribute(b, "id"),
				Generator.GENERATED_VALUE);
		u.createAssociation("R1", u.createAssociationEndPrimary(a, "athing",
				aMultiplicity, "has"), u.createAssociationEndSecondary(b,
				"bthing", bMultiplicity, "has"));
		return u.getSystem();
	}

	public static void main(String[] args) throws IOException,
			TemplateException {
		String outputDirectoryFilename = "temp/associations";
		if (args.length > 0)
			outputDirectoryFilename = args[0];
		Associations system = new Associations();
		system.generate(outputDirectoryFilename);
	}

	@Override
	public void generate(String outputDirectoryName) throws IOException,
			TemplateException {
		File outputDirectory = new File(outputDirectoryName);
		Util.delete(outputDirectory);
		outputDirectory.mkdirs();
		for (Multiplicity m1 : Multiplicity.values()) {
			for (Multiplicity m2 : Multiplicity.values()) {
				Compiler compiler = new Compiler(getSystem(m1, m2),
						outputDirectory);
				compiler.compile();
			}
		}
	}

}
