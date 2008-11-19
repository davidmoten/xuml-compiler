package moten.david.xuml.model.compiler.ant;

import java.io.File;

import moten.david.xuml.model.CodeGenerator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class GenerateTask extends Task {

	private String outputDirectory;
	private String codeGenerator;

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
			generator.generate(outputDirectory);
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
