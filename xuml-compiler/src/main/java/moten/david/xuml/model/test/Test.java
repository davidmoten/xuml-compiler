package moten.david.xuml.model.test;

import org.junit.Assert;
import model.ModelFactory;
import moten.david.xuml.model.util.SystemBase;

public class Test {
	@org.junit.Test
	public void test() {
		model.Package pkg = ModelFactory.eINSTANCE.createPackage();
		pkg.setName("au");
		SystemBase system = new SystemBase("test", "test");
		model.Package subPackage = system.createPackage(pkg, "amsa",
				"Australian Maritime Safety Authority");
		Assert.assertEquals(pkg, subPackage.getParent());
	}
}
