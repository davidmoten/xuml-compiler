package xuml.tools.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import xuml.metamodel.jaxb.Domain;

public class ClassDiagramGeneratorTest {

	@Test
	public void testGenerate() throws FileNotFoundException {
		ClassDiagramGenerator g = new ClassDiagramGenerator();
		Domain domain = new Marshaller().unmarshal(new FileInputStream(
				"src/main/webapp/xuml-sample-1.xml"));
		String s = g.generate(domain);
		System.out.println(s);
	}

}
