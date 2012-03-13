package xuml.tools.jaxb.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Test;

import xuml.tools.jaxb.Marshaller;
import xuml.tools.jaxb.TstUtil;

import com.google.common.collect.Maps;

public class CodeGeneratorJavaTest {

	@Test
	public void test() throws FileNotFoundException {
		if ("false".equals(System.getProperty("generate")))
			return;
		xuml.metamodel.jaxb.System system = new Marshaller()
				.unmarshal(new FileInputStream(TstUtil.SAMPLE_XML));
		Map<String, String> domainPackageNames = Maps.newHashMap();
		domainPackageNames.put("xuml", "miuml");
		new CodeGeneratorJava(system, domainPackageNames).generate(new File(
				"target/generated"));
	}
}
