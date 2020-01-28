package problem1;

import java.util.Objects;

/**
 * This class represents a deposit transaction with the deposit amount and the name of the person
 * doing the deposit to the card.
 */
public class Deposit {
  private Integer dollar;
  private Integer cent;
  private String firstName;
  private String lastName;

  /**
   * Creates a deposit transaction with the given amount of deposit and the first and last name of
   * the person.
   * @param dollar the dollar amount in the deposit
   * @param cent the cent amount in the deposit
   * @param firstName the first name of the person depositing the money
   * @param lastName the lsat name of the person depositing  the money
   */
  public Deposit(int dollar, int cent, String firstName, String lastName) {
    this.dollar = dollar;
    this.cent = cent;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the dollar amount in the deposit.
   * @return the dollar
   */
  public int getDollar() {
    return this.dollar;
  }

  /**
   * Returns the cent amount in the deposit.
   * @return the cent
   */
  public int getCent() {
    return this.cent;
  }

  /**
   * Returns the first name of the person depositing the money.
   * @return the firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the last name of the person depositing the money.
   * @return the lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the deposit information as String.
   * @return the deposit information
   */
  public String toString() {
    String str;
    str = "Dollar: " + this.getDollar() + "\n"
        + "Cent: " + this.getCent() + "\n"
        + "Name: " + this.getFirstName() + " " + this.getLastName();
    return str;
  }

  /**
   * Compares the deposit information to another deposit.
   * @param o the object being compared to
   * @return true/false as the comparison result
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) o;
    return Float.compare(this.dollar, deposit.dollar) == 0
        && Float.compare(this.cent, deposit.cent) == 0
        && Objects.equals(deposit.firstName, this.firstName)
        && Objects.equals(deposit.lastName, this.lastName);
  }

  /**
   * Returns a hash code from the deposit information.
   * @return a hash code of the deposit information
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getDollar(), this.getCent(), this.getFirstName(),
        this.getLastName());
  }
}
