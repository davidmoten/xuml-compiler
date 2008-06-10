package moten.david.xuml.model.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import model.Association;
import model.AssociationClass;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.AttributeReferential;
import model.IdentifierNonPrimary;
import model.ModelFactory;
import model.System;
import moten.david.xuml.model.compiler.templates.ResourceLocator;
import moten.david.xuml.model.compiler.util.KeyMap;
import moten.david.xuml.model.compiler.util.Util;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;

public class Compiler {

	private static final String KEY_ACTIONS_PACKAGE_EXTENSION = "actionsPackageExtension";

	private static final String KEY_INTERFACE_PACKAGE_EXTENSION = "interfacePackageExtension";

	private static final String KEY_CLASS_PACKAGE_EXTENSION = "classPackageExtension";

	private static final String KEY_CLASSES = "classes";

	private static final String KEY_IMPLEMENTATION_PACKAGE_EXTENSION = "implementationPackageExtension";

	private static final String IMPLEMENTATION_PACKAGE_EXTENSION = "impl";

	private static Logger log = Logger.getLogger(Compiler.class);

	private final model.System system;

	private final File outputDirectory;

	private final Configuration templateConfiguration;

	public Compiler(System system, File outputDirectory,
			Configuration templateConfiguration) {
		super();
		this.system = system;
		this.outputDirectory = outputDirectory;
		this.templateConfiguration = templateConfiguration;
	}

	public Compiler(System system, File outputDirectory) {

		this(system, outputDirectory, getDefaultTemplateConfiguration("java"));
	}

	public Compiler(System system, File outputDirectory, String path) {

		this(system, outputDirectory, getDefaultTemplateConfiguration(path));
	}

	private static Configuration getDefaultTemplateConfiguration(String path) {
		freemarker.template.Configuration cfg = new freemarker.template.Configuration();
		cfg.setClassForTemplateLoading(ResourceLocator.class, path);
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg;
	}

	public void compile() throws IOException, TemplateException {
		// Add implicit associations from associations with Association Classes
		List<Association> implicitAssociations = new ArrayList<Association>();

		for (Association association : system.getAssociation()) {
			implicitAssociations.addAll(getImplicitAssociations(association));
		}
		system.getAssociation().addAll(implicitAssociations);
		for (model.Package pkg : system.getPackage()) {
			compile(pkg);
		}
	}

	private List<Association> getImplicitAssociations(Association association) {
		List<Association> list = new ArrayList<Association>();
		AssociationClass assClass = association.getAssociationClass();
		if (assClass == null)
			return list;

		// A
		Association ass = ModelFactory.eINSTANCE.createAssociation();
		ass.setName(association.getName() + "A");
		ass
				.setDescription("Implicit relationship due to existence of Association Class "
						+ assClass.getName());

		AssociationEndPrimary aep = ModelFactory.eINSTANCE
				.createAssociationEndPrimary();
		aep.setRole(association.getPrimary().getRole());
		aep.setVerbClause(association.getPrimary().getVerbClause());
		aep.setMandatory(true);
		aep.setMultiple(false);
		aep.setClass(association.getPrimary().getClass_());
		ass.setPrimary(aep);

		AssociationEndSecondary aes = ModelFactory.eINSTANCE
				.createAssociationEndSecondary();
		aes.setRole(assClass.getName());
		aes.setVerbClause("participates in");
		aes.setMandatory(association.getSecondary().isMandatory());
		aes.setMultiple(association.getSecondary().isMultiple());
		aes.setClass(assClass);
		ass.setSecondary(aes);

		// B
		Association ass2 = ModelFactory.eINSTANCE.createAssociation();
		ass2.setName(association.getName() + "B");
		ass2
				.setDescription("Implicit relationship due to existence of Association Class "
						+ assClass.getName());

		AssociationEndPrimary aep2 = ModelFactory.eINSTANCE
				.createAssociationEndPrimary();
		aep2.setRole(association.getSecondary().getRole());
		aep2.setVerbClause(association.getSecondary().getVerbClause());
		aep2.setMandatory(true);
		aep2.setMultiple(false);
		aep2.setClass(association.getSecondary().getClass_());
		ass2.setPrimary(aep2);

		AssociationEndSecondary aes2 = ModelFactory.eINSTANCE
				.createAssociationEndSecondary();
		aes2.setRole(assClass.getName());
		aes2.setVerbClause("participates in");
		aes2.setMandatory(association.getPrimary().isMandatory());
		aes2.setMultiple(association.getPrimary().isMultiple());
		aes2.setClass(assClass);
		ass2.setSecondary(aes2);

		IdentifierNonPrimary id = ModelFactory.eINSTANCE
				.createIdentifierNonPrimary();
		AttributeReferential a1 = ModelFactory.eINSTANCE
				.createAttributeReferential();
		a1.setClass(assClass);
		a1.setName("primary");
		a1.setAssociationEnd(aep);
		id.getAttributeReferential().add(a1);
		AttributeReferential a2 = ModelFactory.eINSTANCE
				.createAttributeReferential();
		a2.setClass(assClass);
		a2.setName("secondary");
		a2.setAssociationEnd(aep2);
		id.getAttributeReferential().add(a2);
		id
				.setName("implicitly defined because this class is an association class");
		assClass.getIdentifierNonPrimary().add(id);

		list.add(ass);
		list.add(ass2);
		return list;
	}

	private void compile(model.Package pkg) throws IOException,
			TemplateException {

		KeyMap map = new KeyMap();
		putPackage(map, pkg);
		// no ObjectFactory or ObjectInjector unless the package has classes
		if (pkg.getClass_().size() > 0) {
			writeMap(map, pkg, "object-factory.ftl", null, "ObjectFactory");
			writeMap(map, pkg, "object-factory-impl.ftl",
					IMPLEMENTATION_PACKAGE_EXTENSION, "ObjectFactoryImpl");
			compileInjector(pkg, map);
		}
		for (model.Class cls : pkg.getClass_()) {
			compile(cls);
		}
		for (model.Package p : pkg.getSubPackage()) {
			compile(p);
		}
	}

	private void compileInjector(model.Package pkg, KeyMap map)
			throws IOException, TemplateException {
		writeMap(map, pkg, "injector.ftl", null, "ObjectInjector");
	}

	private void putPackage(KeyMap map, model.Package pkg) {
		map.put(KEY_IMPLEMENTATION_PACKAGE_EXTENSION,
				IMPLEMENTATION_PACKAGE_EXTENSION);
		map.put("packageLast", pkg.getName());
		map.put("package", Util.getFullPath(pkg, "."));
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put(KEY_CLASSES, list);
		for (model.Class cls : pkg.getClass_()) {
			KeyMap map2 = new KeyMap();
			map2.put("name", cls.getName());
			list.add(map2);
		}
	}

	private void compile(model.Class cls) throws IOException, TemplateException {
		KeyMap map = new KeyMap();
		ClassMap classMap = new ClassMap(cls);
		map.putAll(classMap.getMap());
		String classPackageExtension = IMPLEMENTATION_PACKAGE_EXTENSION;
		String interfacePackageExtension = null;
		String actionsPackageExtension = "actions";
		map.put(KEY_CLASS_PACKAGE_EXTENSION, classPackageExtension);
		map.put(KEY_INTERFACE_PACKAGE_EXTENSION, interfacePackageExtension);
		map.put(KEY_ACTIONS_PACKAGE_EXTENSION, actionsPackageExtension);

		writeMap(map, cls.getPackage(), "class.ftl", classPackageExtension, cls
				.getName()
				+ "Impl");
		writeMap(map, cls.getPackage(), "interface.ftl",
				interfacePackageExtension, cls.getName());
		writeMap(map, cls.getPackage(), "actions.ftl", actionsPackageExtension,
				cls.getName() + "Actions");
	}

	private void writeMap(KeyMap map, model.Package pkg, String templateName,
			String packageExtension, String className) throws IOException,
			TemplateException {
		String packagePath = Util.getFullPath(pkg, "/");
		writeMap(map, packagePath, templateName, packageExtension, className);
	}

	private void writeMap(KeyMap map, String packagePath, String templateName,
			String packageExtension, String className) throws IOException,
			TemplateException {
		String extension = "";
		if (packageExtension != null)
			extension = Util.getFileSeparator() + packageExtension;
		String folderPath = outputDirectory.getAbsolutePath()
				+ Util.getFileSeparator() + packagePath + extension;
		File folder = new File(folderPath);
		if (!folder.exists() && !folder.mkdirs())
			throw new Error("couldn't create " + folder.getAbsolutePath());
		String filename = className + ".java";
		File file = new File(folder, filename);
		log.info("writing to " + file.getName());
		FileOutputStream fos = new FileOutputStream(file);
		write(map, templateName, fos);
		fos.close();
	}

	private void write(KeyMap map, String templateFile, OutputStream os)
			throws IOException, TemplateException {

		freemarker.template.Template template = templateConfiguration
				.getTemplate(templateFile);
		Writer out = new OutputStreamWriter(os);
		template.process(map, out);
		out.close();
	}

}
