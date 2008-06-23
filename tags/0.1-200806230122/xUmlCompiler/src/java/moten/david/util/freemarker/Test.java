package moten.david.util.freemarker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import moten.david.util.text.UnderscoreFilterWriter;

import org.junit.Assert;

public class Test {

	@org.junit.Test
	public void test() throws IOException {
		test("hello_there", "HelloThere");
		test("hello", "Hello");
		test("hello_there", "helloThere");
		test("a_b", "AB");
		test("", "");
		test("hello_there_how_are_you", "HelloThereHowAreYou");
	}

	private void test(String expected, String input) throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(bytes);
		UnderscoreFilterWriter filter = new UnderscoreFilterWriter(out);
		filter.write(input);
		filter.close();
		Assert.assertEquals(expected, bytes.toString());

	}

}
