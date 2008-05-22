package moten.david.uml.xuml.model.example.microwave;

import microwave.Microwave;
import microwave.ObjectFactory;
import microwave.ObjectInjector;

import org.junit.Assert;

import com.google.inject.Guice;

public class Test {

	@org.junit.Test
	public void test() throws InterruptedException {
		ObjectInjector.setInjector(Guice
				.createInjector(new MicrowaveInjectorModule()));
		MicrowaveBehaviour.timeIncrementMs = 5000;
		long smallTime = MicrowaveBehaviour.timeIncrementMs / 20;
		final Microwave microwave = ObjectFactory.instance.createMicrowave();
		microwave.setSerialNo("A12345678");
		Assert.assertNull(microwave.getLightOn());
		Assert.assertNull(microwave.getPowerTubeOn());
		// pressing the button without the microwave being plugged in has no
		// effect
		microwave.processEvent(new Microwave.EventButtonPressed());
		Thread.sleep(smallTime);
		Assert.assertNull(microwave.getLightOn());
		Assert.assertNull(microwave.getPowerTubeOn());
		// plug the microwave in
		microwave.processEvent(new Microwave.EventPluggedIn());
		Thread.sleep(smallTime);
		Assert.assertFalse(microwave.getLightOn());
		Assert.assertFalse(microwave.getPowerTubeOn());
		// now press the button, should be cooking
		microwave.processEvent(new Microwave.EventButtonPressed());
		Thread.sleep(smallTime);
		Assert.assertTrue(microwave.getLightOn());
		Assert.assertTrue(microwave.getPowerTubeOn());
		// closing the door again has no effect
		microwave.processEvent(new Microwave.EventDoorClosed());
		Thread.sleep(smallTime);
		Assert.assertTrue(microwave.getLightOn());
		Assert.assertTrue(microwave.getPowerTubeOn());
		// plugged in has no effect
		microwave.processEvent(new Microwave.EventPluggedIn());
		Thread.sleep(smallTime);
		Assert.assertTrue(microwave.getLightOn());
		Assert.assertTrue(microwave.getPowerTubeOn());
		// opening the door should cancel cooking
		microwave.processEvent(new Microwave.EventDoorOpened());
		Thread.sleep(smallTime);
		Assert.assertFalse(microwave.getLightOn());
		Assert.assertFalse(microwave.getPowerTubeOn());
		// now press the button, won't cook till we close the door
		microwave.processEvent(new Microwave.EventButtonPressed());
		Thread.sleep(smallTime);
		Assert.assertFalse(microwave.getLightOn());
		Assert.assertFalse(microwave.getPowerTubeOn());
		// close the door
		microwave.processEvent(new Microwave.EventDoorClosed());
		Thread.sleep(smallTime);
		Assert.assertFalse(microwave.getLightOn());
		Assert.assertFalse(microwave.getPowerTubeOn());
		// now press the button, should cook
		microwave.processEvent(new Microwave.EventButtonPressed());
		Thread.sleep(smallTime);
		Assert.assertTrue(microwave.getLightOn());
		Assert.assertTrue(microwave.getPowerTubeOn());

	}
}
