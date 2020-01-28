import java.util.Objects;

/**
 * This class represents the name of an Person object that stores its first and last name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Creates a new name object that stores the first and last name.
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name.
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the last name.
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the full name of the Name as String.
   * @return the full name
   */
  public String toString() {
    return this.firstName + this.lastName;
  }

  /**
   * Compares the name details.
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
    Name name = (Name) o;
    return Objects.equals(name.firstName, this.firstName)
        && Objects.equals(name.lastName, this.lastName);
  }

  /**
   * Returns a hash code from the name details.
   * @return a hashcode from the name details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName());
  }
}
