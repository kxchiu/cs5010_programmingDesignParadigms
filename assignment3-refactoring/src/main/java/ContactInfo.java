import java.util.Objects;

/**
 * This class represents the contact information record for the Person object given the details--
 * phone number 1 and 2, email, and website.
 */
public class ContactInfo {
  private String phone1;
  private String phone2;
  private String email;
  private String website;

  /**
   * Constructs a new contact information with given details--phone numbers, email, and website.
   * @param phone1 the given phone number 1
   * @param phone2 the given phone number 2
   * @param email the given email address
   * @param website the given website
   */
  public ContactInfo(String phone1, String phone2, String email, String website) {
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.website = website;
  }

  /**
   * Returns the phone number 1 as String.
   * @return the phone number 1
   */
  public String getPhone1() {
    return this.phone1;
  }

  /**
   * Returns the phone number 2 as String.
   * @return the phone number 2
   */
  public String getPhone2() {
    return this.phone2;
  }

  /**
   * Returns the email address as String.
   * @return the email address
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Returns the website as String.
   * @return the website
   */
  public String getWebsite() {
    return this.website;
  }

  /**
   * Returns the full contact information details as String.
   * @return the full contact information details
   */
  public String toString() {
    String str;
    str = "Phone: " + getPhone1() + ", " + getPhone2() + "\n"
        + "Email: " + getEmail() + "\n"
        + "Website: " + getWebsite();
    return str;
  }

  /**
   * Compares the contact details.
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
    ContactInfo contactInfo = (ContactInfo) o;
    return Objects.equals(contactInfo.getPhone1(), this.getPhone1())
        && Objects.equals(contactInfo.getPhone2(), this.getPhone2())
        && Objects.equals(contactInfo.getEmail(), this.getEmail())
        && Objects.equals(contactInfo.getWebsite(), this.getWebsite());
  }

  /**
   * Returns a hash code from the contact details.
   * @return a hashcode from the contact details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getPhone1(), this.getPhone2(), this.getEmail(), this.getWebsite());
  }
}
