package xuml.tools.jaxb.compiler;

import org.junit.Test;

public class ClassWriter2Test {

	@Test
	public void test() {
		System.out.println(new ClassWriter2(new ClassInfo()).generate());
	}
}
