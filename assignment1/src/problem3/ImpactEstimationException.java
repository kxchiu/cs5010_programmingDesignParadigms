package problem3;

/**
 * This class represents the exception to be thrown when the publication is over 260 years old.
 */

public class ImpactEstimationException extends Exception {
  public ImpactEstimationException(String s) {
    super(s);
  }
}
