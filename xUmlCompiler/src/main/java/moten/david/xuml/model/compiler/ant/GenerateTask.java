package moten.david.xuml.model.compiler.ant;

import java.io.File;

import moten.david.xuml.model.CodeGenerator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class GenerateTask extends Task {

	private String outputDirectory;
	private String resourcesDirectory;
	private String webDirectory;
	private String docsDirectory;
	private String codeGenerator;

	public String getResourcesDirectory() {
		return resourcesDirectory;
	}

	public void setResourcesDirectory(String resourcesDirectory) {
		this.resourcesDirectory = resourcesDirectory;
	}

	public String getWebDirectory() {
		return webDirectory;
	}

	public void setWebDirectory(String webDirectory) {
		this.webDirectory = webDirectory;
	}

	public String getDocsDirectory() {
		return docsDirectory;
	}

	public void setDocsDirectory(String docsDirectory) {
		this.docsDirectory = docsDirectory;
	}

	@Override
	public void execute() throws BuildException {
		if (outputDirectory == null)
			throw new BuildException("must specify outputDirectory");
		if (codeGenerator == null)
			throw new BuildException("must specify codeGenerator");
		File file = new File(outputDirectory);
		if (!file.exists())
			file.mkdirs();
		try {
			CodeGenerator generator = (CodeGenerator) Class.forName(
					codeGenerator).newInstance();
			log("writing generated classes to " + outputDirectory);
			if (resourcesDirectory == null)
				resourcesDirectory = outputDirectory + File.separatorChar
						+ "src";
			if (webDirectory == null)
				webDirectory = outputDirectory + File.separatorChar + "www";
			if (docsDirectory == null)
				docsDirectory = outputDirectory;
			generator.generate(outputDirectory, resourcesDirectory,
					webDirectory, docsDirectory);
		} catch (Exception e) {
			throw new BuildException(e);
		}
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public String getCodeGenerator() {
		return codeGenerator;
	}

	public void setCodeGenerator(String codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

}
