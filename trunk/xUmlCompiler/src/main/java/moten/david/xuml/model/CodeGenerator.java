package moten.david.xuml.model;

/**
 * JPA Code generator from Executable UML style model.
 * 
 * @author dave
 * 
 */
public interface CodeGenerator {
	/**
	 * Generate code into the output directory, resources into
	 * resourcesDirectory, web files (jsp) into webDirectory and documentation
	 * (Executable UML style) to docsDirectory.
	 * 
	 * @param outputDirectory
	 * @param resourcesDirectory
	 * @param webDirectory
	 * @param docsDirectory
	 * @throws Exception
	 */
	public void generate(String outputDirectory, String resourcesDirectory,
			String webDirectory, String docsDirectory) throws Exception;
}
