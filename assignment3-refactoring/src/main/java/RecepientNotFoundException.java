/**
 * This class represents a recepient not found exception that is thrown when the requested email
 * recepient is not found in the database.
 */
public class RecepientNotFoundException extends Exception {

	/**
	 * Constructs a new recepient not found exception.
	 * @param errorMessage the given error message (requested email recepient)
	 */
	public RecepientNotFoundException(String errorMessage) {
		super("Recepient: [ " + errorMessage + " ] was not found in the database.");
	}
}
