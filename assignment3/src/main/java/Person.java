import java.util.Objects;

/**
 * This class represents a person with information read from the given CSV file.
 */
public class Person {
  private Name name;
  private AddressInfo addressInfo;
  private ContactInfo contactInfo;

  /**
   * Constructs a new person with given information--name, address and contact information.
   * @param name the name of the person
   * @param addressInfo the address information of the person
   * @param contactInfo the contact information of the person
   */
  public Person(Name name, AddressInfo addressInfo, ContactInfo contactInfo) {
    this.name = name;
    this.addressInfo = addressInfo;
    this.contactInfo = contactInfo;
  }

  /**
   * Returns the first name.
   * @return the first name
   */
  public String getFirstName() {
    return this.name.getFirstName();
  }

  /**
   * Returns the last name.
   * @return the last name
   */
  public String getLastName() {
    return this.name.getLastName();
  }

  /**
   * Returns the company name.
   * @return the company name
   */
  public String getCompanyName() {
    return this.addressInfo.getCompanyName();
  }

  /**
   * Returns the address.
   * @return the address
   */
  public String getAddress() {
    return this.addressInfo.getAddress();
  }

  /**
   * Returns the city.
   * @return the city
   */
  public String getCity() {
    return this.addressInfo.getCity();
  }

  /**
   * Returns the county.
   * @return the county
   */
  public String getCounty() {
    return this.addressInfo.getCounty();
  }

  /**
   * Returns the state.
   * @return the state
   */
  public String getState() {
    return this.addressInfo.getState();
  }

  /**
   * Returns the ZIP code.
   * @return the ZIP code
   */
  public String getZip() {
    return this.addressInfo.getZip();
  }

  /**
   * Returns the email address.
   * @return the email address
   */
  public String getEmail() {
    return this.contactInfo.getEmail();
  }

  /**
   * Returns the full name of the person as String.
   * @return the full name
   */
  public String toString() {
    return this.getFirstName() + " " + this.getLastName();
  }

  /**
   * Compares the person details.
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
    Person person = (Person) o;
    return Objects.equals(person.getFirstName(), this.getFirstName())
        && Objects.equals(person.getLastName(), this.getLastName())
        && Objects.equals(person.getCompanyName(), this.getCompanyName())
        && Objects.equals(person.getAddress(), this.getAddress())
        && Objects.equals(person.getCity(), this.getCity())
        && Objects.equals(person.getCounty(), this.getCounty())
        && Objects.equals(person.getState(), this.getState())
        && Objects.equals(person.getZip(), this.getZip())
        && Objects.equals(person.getEmail(), this.getEmail());
  }

  /**
   * Returns a hash code from the person details.
   * @return a hashcode from the person details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName(), this.getCompanyName(),
        this.getAddress(), this.getCity(), this.getCounty(), this.getState(), this.getZip(),
        this.getEmail());
  }
}
