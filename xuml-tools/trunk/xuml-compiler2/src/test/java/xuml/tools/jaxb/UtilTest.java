package xuml.tools.jaxb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testToTableName() {
		assertEquals("hello_there",
				Util.camelCaseToLowerUnderscore("HelloThere"));
	}

	@Test
	public void testToTableNameSequenceOfCapitals() {
		assertEquals("hello_there",
				Util.camelCaseToLowerUnderscore("HelloTHERE"));
	}

	@Test
	public void testToTableNameSequenceOfCapitalsFollowedByLowerCase() {
		assertEquals("hello_there",
				Util.camelCaseToLowerUnderscore("HelloTHEre"));
	}

}
