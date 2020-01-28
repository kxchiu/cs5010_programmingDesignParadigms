package problem1;

import java.util.Objects;

/**
 * This class represents a card owner with details--first and last name, address, and email address.
 */
public class CardOwner {
  private String firstName;
  private String lastName;
  private String address;
  private String email;

  /**
   * Creates a new card owner given the person's first and last name, address, and email address
   * as Strings.
   * @param firstName the card owner's first name
   * @param lastName the card owner's last name
   * @param address the card owner's physical address
   * @param email the card owner's email address
   */
  public CardOwner(String firstName, String lastName, String address, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
  }

  /**
   * Returns the first name of the card owner.
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the last name of the card owner.
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the physical address of the card owner.
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Returns the email address of the card owner.
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Returns the full information of the card owner as String.
   * @return the card owner details
   */
  public String toString() {
    String str;
    str = "Name: " + this.getFirstName() + " " + this.getLastName() + "\n"
        + "Address: " + this.getAddress() + "\n"
        + "Email: " + this.getEmail();
    return str;
  }

  /**
   * Compares the card owner details.
   * @param o the object being compared to
   * @return true/false from the comparison
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardOwner cardOwner = (CardOwner) o;
    return Objects.equals(cardOwner.firstName, this.firstName)
        && Objects.equals(cardOwner.lastName, this.lastName)
        && Objects.equals(cardOwner.address, this.address)
        && Objects.equals(cardOwner.email, this.email);
  }

  /**
   * Returns a hash code from the card owner details.
   * @return a hashcode from the card owner details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName(), this.getAddress(),
        this.getEmail());
  }
}
