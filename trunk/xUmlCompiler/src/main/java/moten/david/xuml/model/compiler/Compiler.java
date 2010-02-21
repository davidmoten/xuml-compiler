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
import model.Specialization;
import model.SpecializationGroup;
import model.System;
import moten.david.xuml.model.compiler.templates.ResourceLocator;
import moten.david.xuml.model.compiler.util.KeyMap;
import moten.david.xuml.model.compiler.util.Util;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;

/**
 * Executable Uml model compiler supporting one public method, compile().
 * 
 * @author dave
 * 
 */
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

	private List<String> classNames;

	private final File resourcesDirectory;

	private final File docsDirectory;

	private final File webDirectory;

	public Compiler(System system, File outputDirectory,
			File resourcesDirectory, File webDirectory, File docsDirectory,
			Configuration templateConfiguration) {
		super();
		this.system = system;
		this.outputDirectory = outputDirectory;
		this.resourcesDirectory = resourcesDirectory;
		this.webDirectory = webDirectory;
		this.docsDirectory = docsDirectory;
		makeDirs(outputDirectory);
		makeDirs(resourcesDirectory);
		makeDirs(webDirectory);
		makeDirs(docsDirectory);
		this.templateConfiguration = templateConfiguration;
	}

	private void makeDirs(File directory) {
		if (!directory.exists() && !directory.mkdirs())
			throw new RuntimeException("couldn not create " + directory);
	}

	public Compiler(System system, File outputDirectory,
			File resourcesDirectory, File webDirectory, File docsDirectory) {

		this(system, outputDirectory, resourcesDirectory, webDirectory,
				docsDirectory, getDefaultTemplateConfiguration("java"));
	}

	public Compiler(System system, File outputDirectory, String path) {

		this(system, outputDirectory, outputDirectory, outputDirectory,
				outputDirectory, getDefaultTemplateConfiguration(path));
	}

	private static Configuration getDefaultTemplateConfiguration(String path) {
		freemarker.template.Configuration cfg = new freemarker.template.Configuration();
		cfg.setClassForTemplateLoading(ResourceLocator.class, path);
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg;
	}

	public void compile() throws IOException, TemplateException {
		classNames = new ArrayList<String>();
		// Add implicit associations from associations with Association Classes
		List<Association> implicitAssociations = new ArrayList<Association>();

		for (Association association : system.getAssociation())
			implicitAssociations.addAll(getImplicitAssociations(association));
		system.getAssociation().addAll(implicitAssociations);
		for (model.Package pkg : system.getPackage())
			compile(pkg);
		compileDocumentation();
		compilePersistenceXml();
	}

	private void compilePersistenceXml() throws IOException, TemplateException {
		KeyMap map = new KeyMap();
		map.put("name", system.getName());
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put("classes", list);
		for (String className : classNames) {
			KeyMap map2 = new KeyMap();
			map2.put("name", className);
			list.add(map2);
		}
		File metaInf = new File(resourcesDirectory, "META-INF");
		metaInf.mkdirs();
		File persistenceXml = new File(metaInf, "persistence.xml");
		FileOutputStream fos = new FileOutputStream(persistenceXml);
		write(map, "persistence.ftl", fos);
		fos.close();
	}

	private void compileDocumentation() throws IOException, TemplateException {
		SystemMap systemMap = new SystemMap(system);
		FileOutputStream fos = new FileOutputStream(new File(docsDirectory,
				system.getName() + "-documentation.html"));
		write(systemMap.getMap(), "documentation.ftl", fos);
		fos.close();
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
			writeJavaMap(map, pkg, "object-factory.ftl", null, "ObjectFactory");
			writeJavaMap(map, pkg, "object-factory-impl.ftl",
					IMPLEMENTATION_PACKAGE_EXTENSION, "ObjectFactoryImpl");
			compileInjector(pkg, map);
		}
		for (model.Class cls : pkg.getClass_())
			compile(cls);
		for (model.Package p : pkg.getSubPackage())
			compile(p);
	}

	private void compileInjector(model.Package pkg, KeyMap map)
			throws IOException, TemplateException {
		writeJavaMap(map, pkg, "injector.ftl", null, "ObjectInjector");
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
			map2.put("isGeneralization",
					cls.getSpecializationGroup().size() > 0);
			if (cls instanceof Specialization) {
				Specialization sp = (Specialization) cls;
				List<KeyMap> list2 = new ArrayList<KeyMap>();
				map2.put("generalizations", list2);
				for (SpecializationGroup group : sp.getGroup()) {
					KeyMap map3 = new KeyMap();
					map3.put("name", group.getName());
					map3.put("class", group.getGeneralization().getName());
					list2.add(map3);
				}
			}
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

		// get the fully qualified class name and record it
		String classQualifiedName = Util.getFullPath(cls.getPackage(), ".");
		if (classPackageExtension != null)
			classQualifiedName += "." + classPackageExtension;
		classQualifiedName += "." + cls.getName() + "Impl";
		classNames.add(classQualifiedName);

		String interfaceQualifiedName = Util.getFullPath(cls.getPackage(), ".");
		if (interfacePackageExtension != null)
			interfaceQualifiedName += "." + interfacePackageExtension;
		interfaceQualifiedName += "." + cls.getName();

		writeJavaMap(map, cls.getPackage(), "class.ftl", classPackageExtension,
				cls.getName() + "Impl");
		writeJavaMap(map, cls.getPackage(), "interface.ftl",
				interfacePackageExtension, cls.getName());
		for (SpecializationGroup sg : cls.getSpecializationGroup()) {
			map.put("specializationGroup", sg);
			writeJavaMap(map, cls.getPackage(), "specializationGroup.ftl",
					interfacePackageExtension, cls.getName() + sg.getName());
		}
		writeJavaMap(map, cls.getPackage(), "actions.ftl",
				actionsPackageExtension, cls.getName() + "Actions");
		if (!webDirectory.exists())
			webDirectory.mkdir();
		File updateJsp = new File(webDirectory, "update" + cls.getName()
				+ ".jsp");
		FileOutputStream fos = new FileOutputStream(updateJsp);
		map.put("interfaceFullName", interfaceQualifiedName);
		log.info("writing jsp:" + updateJsp);
		write(map, "jsp-update.ftl", fos);
		fos.close();
		File listJsp = new File(webDirectory, "list" + cls.getName() + ".jsp");
		fos = new FileOutputStream(listJsp);
		log.info("writing jsp:" + listJsp);
		write(map, "jsp-list.ftl", fos);
		fos.close();
	}

	private void writeJavaMap(KeyMap map, model.Package pkg,
			String templateName, String packageExtension, String className)
			throws IOException, TemplateException {
		String packagePath = Util.getFullPath(pkg, "/");
		writeMap(map, packagePath, templateName, packageExtension, className,
				".java");
	}

	private void writeMap(KeyMap map, String packagePath, String templateName,
			String packageExtension, String className, String classExtension)
			throws IOException, TemplateException {
		String extension = "";
		if (packageExtension != null)
			extension = Util.getFileSeparator() + packageExtension;
		String folderPath = outputDirectory.getAbsolutePath()
				+ Util.getFileSeparator() + packagePath + extension;
		File folder = new File(folderPath);
		if (!folder.exists() && !folder.mkdirs())
			throw new Error("couldn't create " + folder.getAbsolutePath());
		String filename = className + classExtension;
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
