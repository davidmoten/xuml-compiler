package xuml.tools.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class ClassDiagramGeneratorTest {

	
	@Test
	public void testGenerate() throws IOException {
		ClassDiagramGenerator g = new ClassDiagramGenerator();
		xuml.metamodel.jaxb.System system= new Marshaller().unmarshal(new FileInputStream(
				TstUtil.SAMPLE_XML));
		String s = g.generate(system);
		System.out.println(s);
		File webapp= new File("target/webapp");
		FileUtils.deleteDirectory(webapp);
		FileUtils.copyDirectoryToDirectory(new File("src/main/webapp"), new File("target"));
		FileOutputStream fos = new FileOutputStream("target/webapp/class-diagram.html");
		IOUtils.copy(IOUtils.toInputStream(s), fos);
		fos.close();
		Assert.assertTrue(s.endsWith("</html>"));
	}

}
