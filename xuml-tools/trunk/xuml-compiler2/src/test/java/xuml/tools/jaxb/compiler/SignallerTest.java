package xuml.tools.jaxb.compiler;

import org.junit.Test;

public class SignallerTest {

	private static class MyTest implements ReceivesSignal<MyTest> {
	}

	private static class MyEvent implements Event<MyTest> {
	}

	@Test
	public void testSignaller() {

		new Signaller().signal(MyTest.class, 1, new MyEvent());
	}
}
