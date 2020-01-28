import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecepientNotFoundExceptionTest {
	private RecepientNotFoundException recepientNotFoundException;

	@Before
	public void setUp() throws Exception {
		recepientNotFoundException = new RecepientNotFoundException("Test Recepient Name");
	}

	@Test(expected= RecepientNotFoundException.class)
	public void testReservationFailExceptionTest() throws RecepientNotFoundException {
		throw recepientNotFoundException;
	}
}