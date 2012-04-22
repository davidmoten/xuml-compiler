package xuml.tools.jaxb.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import miuml.jaxb.Marshaller;

import org.junit.Test;

import com.google.common.collect.Maps;

public class CodeGeneratorJavaTest {

	@Test
	public void test() throws FileNotFoundException {
		if ("false".equals(System.getProperty("generate")))
			return;
		miuml.jaxb.Domains domains = new Marshaller().unmarshal(getClass()
				.getResourceAsStream("/bookstore.xml"));
		Map<String, String> domainPackageNames = Maps.newHashMap();
		domainPackageNames.put("xuml", "miuml");
		File resources = new File("target/generated-resources");
		if (!resources.exists())
			resources.mkdirs();
		new CodeGeneratorJava(domains, domainPackageNames, "miuml", resources)
				.generate(new File("target/generated/"));
	}
}
