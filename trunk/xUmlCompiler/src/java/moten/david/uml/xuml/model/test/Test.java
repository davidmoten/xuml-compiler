package moten.david.uml.xuml.model.test;

import junit.framework.Assert;
import model.ModelFactory;
import moten.david.uml.xuml.model.util.SystemBase;

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
