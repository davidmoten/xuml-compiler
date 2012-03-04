package xuml.tools.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import xuml.metamodel.jaxb.Domain;

public class MarshallerTest {

	@Test
	public void testUnmarshal() throws FileNotFoundException {
		Marshaller m = new Marshaller();
		InputStream is = new FileInputStream(TstUtil.SAMPLE_XML);
		Domain domain = m.unmarshal(is);
		Assert.assertTrue(domain.getClazz().size()>1);
	}
}
