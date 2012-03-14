package xuml.tools.jaxb;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class MarshallerTest {

	@Test
	public void testUnmarshal() throws FileNotFoundException {
		Marshaller m = new Marshaller();
		InputStream is = getClass().getResourceAsStream(TstUtil.SAMPLE_XML);
		xuml.metamodel.jaxb.System system = m.unmarshal(is);
		Assert.assertTrue(system.getClazz().size() > 1);
	}
}
