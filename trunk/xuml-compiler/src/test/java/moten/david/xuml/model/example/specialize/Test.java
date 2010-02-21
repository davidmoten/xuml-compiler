package moten.david.xuml.model.example.specialize;

import java.lang.reflect.Method;

import org.junit.Assert;

import specialize.Fiction;
import specialize.NonFiction;
import specialize.ObjectFactory;

public class Test {

	@org.junit.Test
	public void testCreate() {
		Fiction fiction = ObjectFactory.instance.createFiction();
		Assert.assertNotNull(fiction.getWriting());
		NonFiction nonFiction = ObjectFactory.instance.createNonFiction();
		Assert.assertNotNull(nonFiction.getWriting());
		noSuchMethod(ObjectFactory.class, "createWriting");
	}

	public void noSuchMethod(Class<?> c, String methodName) {
		try {
			Method m = c.getMethod(methodName, new Class<?>[] {});
			System.out.println(m);
			Assert.fail(methodName + " method should not exist");
		} catch (SecurityException e) {
			Assert.fail("security exception: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			// that's fine
		}
	}

	@org.junit.Test
	public void testCompoundSpecializations() {
		Assert.assertNotNull(ObjectFactory.instance.createHardCover()
				.getWriting());
		Assert.assertNotNull(ObjectFactory.instance.createSoftCover()
				.getWriting());
		Assert.assertNotNull(ObjectFactory.instance.createElectronicText()
				.getElectronicEdition().getWriting());
	}

}
