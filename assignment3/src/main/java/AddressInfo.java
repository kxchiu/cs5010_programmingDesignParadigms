import java.util.Objects;

/**
 * This class represents an address information record for the Person object with given details--
 * address, city, county, state, and zip code.
 */
public class AddressInfo {
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;

  /**
   * Constructs a new address information with given details.
   * @param companyName the company name
   * @param address the physical address
   * @param city the city
   * @param county the county
   * @param state the state
   * @param zip the zip code
   */
  public AddressInfo(String companyName, String address, String city,
      String county, String state, String zip) {
    this.companyName = companyName;
    this.address = address;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
  }

  /**
   * Returns the company name as String.
   * @return the company name
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * Returns the physical address as String.
   * @return the physical address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Returns the city as String.
   * @return the city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Returns the county as String.
   * @return the county
   */
  public String getCounty() {
    return this.county;
  }

  /**
   * Returns the state as String.
   * @return the state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Returns the ZIP code as String.
   * @return the ZIP code
   */
  public String getZip() {
    return this.zip;
  }

  /**
   * Returns the full address information as String.
   * @return the full address information
   */
  public String toString() {
    String str;
    str = getCompanyName() + "\n"
        + getAddress() + "\n"
        + getCity() + ", " + getState() + " " + getZip();
    return str;
  }

  /**
   * Compares the address details.
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
    AddressInfo addressInfo = (AddressInfo) o;
    return Objects.equals(addressInfo.getCompanyName(), this.getCompanyName())
        && Objects.equals(addressInfo.getAddress(), this.getAddress())
        && Objects.equals(addressInfo.getCity(), this.getCity())
        && Objects.equals(addressInfo.getCounty(), this.getCounty())
        && Objects.equals(addressInfo.getState(), this.getState())
        && Objects.equals(addressInfo.getZip(), this.getZip());
  }

  /**
   * Returns a hash code from the address details.
   * @return a hashcode from the address details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getCompanyName(), this.getAddress(), this.getCity(), this.getCounty(),
    this.getState(), this.getZip());
  }
}
