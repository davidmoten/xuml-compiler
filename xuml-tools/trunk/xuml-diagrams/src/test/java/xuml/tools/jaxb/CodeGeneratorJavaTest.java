package xuml.tools.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

import org.junit.Test;

public class CodeGeneratorJavaTest {

	@Test
	public void test() throws FileNotFoundException {
		xuml.metamodel.jaxb.System system = new Marshaller()
				.unmarshal(new FileInputStream(TstUtil.SAMPLE_XML));
		new CodeGeneratorJava().generate(System.out, system,
				Collections.EMPTY_MAP, null);
	}
}
