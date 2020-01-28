package assignment4;

/**
 * This class represents a reservation fail exception that is thrown when the reservation request
 * failed.
 */
public class ReservationFailException extends Exception {

	/**
	 * Constructs a new reservation fail exception with given error message.
	 * @param errorMessage the given error message
	 */
	public ReservationFailException(String errorMessage) {
		super("Reservation failed: " + errorMessage);
	}
}
