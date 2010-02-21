package moten.david.xuml.model.example.self.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Set;

import moten.david.xuml.model.compiler.templates.ResourceLocator;
import self.Clazz;
import self.ConcreteClass;
import self.ObjectFactory;
import self.Pkg;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateModel;

public class ClassFileGenerator {

	private SubDomain subDomain;
	private File outputDirectory;

	public ClassFileGenerator(SubDomain subDomain, String outputDirectory) {
		this.subDomain = subDomain;
		this.outputDirectory = new File(outputDirectory);
	}

	public void generate() {
		processPackages(subDomain.getPackages());
	}

	private void processPackages(Collection<Pkg> packages) {
		for (Pkg pkg : packages) {
			processClasses(pkg.getClazz());
			processPackages(pkg.getChildPackage());
		}
	}

	private void processClasses(Set<Clazz> classes) {
		for (Clazz cls : classes)
			processClass(cls);
	}

	private void processClass(Clazz cls) {
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		try {
			TemplateModel objectModel = wrapper.wrap(cls);
			Configuration templateConfiguration = getDefaultTemplateConfiguration("template");
			String templateFile = "class.ftl";
			freemarker.template.Template template = templateConfiguration
					.getTemplate(templateFile);
			FileOutputStream fos = new FileOutputStream(outputDirectory);
			Writer out = new OutputStreamWriter(fos);
			template.process(objectModel, out);
			out.close();
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	private static Configuration getDefaultTemplateConfiguration(String path) {
		freemarker.template.Configuration cfg = new freemarker.template.Configuration();
		cfg.setClassForTemplateLoading(ResourceLocator.class, path);
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg;
	}

	public static void main(String[] args) {
		SubDomain sd = new SubDomain();
		Pkg pkg = ObjectFactory.instance.createPkg();
		pkg.setName("test");
		sd.getPackages().add(pkg);
		ConcreteClass c = ObjectFactory.instance.createConcreteClass();
		c.getClazz().setName("Testy");
		pkg.getClazz().add(c.getClazz());
		ClassFileGenerator cg = new ClassFileGenerator(sd, "temp");
		cg.generate();
	}

}
