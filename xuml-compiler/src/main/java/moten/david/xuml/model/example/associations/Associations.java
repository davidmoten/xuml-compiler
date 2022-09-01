package moten.david.xuml.model.example.associations;

import java.io.File;
import java.io.IOException;

import model.Class;
import model.Package;
import model.System;
import moten.david.xuml.model.CodeGenerator;
import moten.david.xuml.model.Generator;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.compiler.Compiler;
import moten.david.xuml.model.compiler.util.Util;
import moten.david.xuml.model.util.SystemBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.TemplateException;

public class Associations implements CodeGenerator {

	private static Logger log = LoggerFactory.getLogger(Associations.class);

	private static int counter = 0;

	public System getSystem(Multiplicity aMultiplicity,
			Multiplicity bMultiplicity) {
		String systemName = "Associations";
		String schema = aMultiplicity.toString() + "_TO_"
				+ bMultiplicity.toString();
		SystemBase u = new SystemBase(schema, systemName);
		Package pkg = u.createRootPackage(schema.toLowerCase(), "test system");
		Class a = u.createClass(pkg, "A" + ++counter, "first table");
		u.createIdentifierPrimary(u.createAttribute(a, "id"),
				Generator.GENERATED_VALUE);
		Class b = u.createClass(pkg, "B" + counter, "second table");
		u.createIdentifierPrimary(u.createAttribute(b, "id"),
				Generator.GENERATED_VALUE);
		u.createAssociation("R1", u.createAssociationEndPrimary(a, "athing",
				aMultiplicity, "has"), u.createAssociationEndSecondary(b,
				"bthing", bMultiplicity, "has"));
		return u.getSystem();
	}

	public static void main(String[] args) throws IOException,
			TemplateException {
		String outputDirectoryFilename = "target/associations";
		if (args.length > 0)
			outputDirectoryFilename = args[0];
		Associations system = new Associations();
		system.generate(outputDirectoryFilename, outputDirectoryFilename,
				outputDirectoryFilename, outputDirectoryFilename);
	}

	@Override
	public void generate(String outputDirectoryName,
			String resourcesDirectoryName, String webDirectoryName,
			String docsDirectoryName) throws IOException, TemplateException {
		File outputDirectory = new File(outputDirectoryName);
		Util.delete(outputDirectory);
		outputDirectory.mkdirs();
		for (Multiplicity m1 : Multiplicity.values()) {
			for (Multiplicity m2 : Multiplicity.values()) {
				Compiler compiler = new Compiler(getSystem(m1, m2),
						outputDirectory, new File(resourcesDirectoryName),
						new File(webDirectoryName), new File(docsDirectoryName));
				compiler.compile();
			}
		}
	}

}
