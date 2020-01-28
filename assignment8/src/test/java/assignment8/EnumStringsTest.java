package assignment8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnumStringsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getLiteral() {
		assertEquals("No Title", EnumStrings.NO_TITLE.getLiteral());
	}
}