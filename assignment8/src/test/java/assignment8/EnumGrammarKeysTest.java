package assignment8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnumGrammarKeysTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void getKey() {
		assertEquals("start", EnumGrammarKeys.START.getKey());
	}
}