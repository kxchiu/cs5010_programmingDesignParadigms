package assignment4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReservationFailExceptionTest {
	private ReservationFailException reservationFailException;

	@Before
	public void setUp() throws Exception {
		reservationFailException = new ReservationFailException("Test Message");
	}

	@Test(expected= ReservationFailException.class)
	public void testReservationFailExceptionTest() throws ReservationFailException {
		throw reservationFailException;
	}
}