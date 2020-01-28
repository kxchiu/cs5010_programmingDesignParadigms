package assignment2;

import java.util.Objects;

/**
 * This class represents the address information of the restaurant given the details--street and
 * number, city, zip code, state and country.
 */
public class Address {
  private String streetAndNum;
  private String city;
  private String zip;
  private String state;
  private String country;

  /**
   * Constructs a new address given the address details.
   * @param streetAndNum the street and number
   * @param city the city
   * @param zip the zip code
   * @param state the state
   * @param country the country
   */
  public Address(String streetAndNum, String city, String zip, String state, String country) {
    this.streetAndNum = streetAndNum;
    this.city = city;
    this.zip = zip;
    this.state = state;
    this.country = country;
  }

  /**
   * Sets the street and number.
   * @param streetAndNum the street and number
   */
  public void setStreetAndNum(String streetAndNum) {
    this.streetAndNum = streetAndNum;
  }

  /**
   * Sets the city.
   * @param city the city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Sets the zip code.
   * @param zip the zip code
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * Sets the state.
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Sets the country.
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Returns the street and number.
   * @return the street and number
   */
  public String getStreetAndNum() {
    return this.streetAndNum;
  }

  /**
   * Returns the city.
   * @return the city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Returns the zip code.
   * @return the zip code
   */
  public String getZip() {
    return this.zip;
  }

  /**
   * Returns the state.
   * @return the state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Returns the country.
   * @return the country
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Returns the address information as String.
   * @return the address information
   */
  public String toString() {
    String str;
    str = this.getStreetAndNum() + "\n"
        + this.getCity() + ", " + this.getState() + " " + this.getZip() + "\n"
        + this.getCountry();
    return str;
  }

  /**
   * Compares the given object to the address.
   * @param o the given object
   * @return the comparison result
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(address.streetAndNum, this.streetAndNum)
        && Objects.equals(address.city, this.city)
        && Objects.equals(address.zip, this.zip)
        && Objects.equals(address.state, this.state)
        && Objects.equals(address.country, this.country);
  }

  /**
   * Returns a hash integer of the address information.
   * @return a hash integer of the address information
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getStreetAndNum(), this.getCity(), this.getZip(),
        this.getState(), this.getCountry());
  }
}
