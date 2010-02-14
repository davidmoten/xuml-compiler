package moten.david.xuml.model;

public interface CodeGenerator {
	public void generate(String outputDirectory, String resourcesDirectory,
			String webDirectory, String docsDirectory) throws Exception;
}
