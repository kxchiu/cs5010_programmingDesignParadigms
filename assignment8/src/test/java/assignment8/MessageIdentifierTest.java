package assignment8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageIdentifierTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getValue() {
		int idf = 20;
		assertEquals(idf, (long)MessageIdentifier.CONNECT_RESPONSE.getValue());
	}

	@Test
	public void getEnum() {
	}
}