package assignment2;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Address class.
 */
public class AddressTest {
  private Address address;
  private Address tempAddress;
  private String streetAndNum;
  private String city;
  private String zip;
  private String state;
  private String country;

  @Before
  public void setUp() throws Exception {
    streetAndNum = "4510 University Way";
    city = "Seattle";
    zip = "98105";
    state = "WA";
    country = "USA";
    address = new Address(streetAndNum, city, zip, state, country);
    tempAddress = new Address(streetAndNum, city, zip, state, country);
  }

  @Test
  public void setStreetAndNum() {
    String newStreetAndNum = "4444 Brooklyn Ave";
    this.address.setStreetAndNum(newStreetAndNum);
    Assert.assertEquals(newStreetAndNum, this.address.getStreetAndNum());
  }

  @Test
  public void setCity() {
    String newCity = "Bellevue";
    this.address.setCity(newCity);
    Assert.assertEquals(newCity, this.address.getCity());
  }

  @Test
  public void setZip() {
    String newZip = "98108";
    this.address.setZip(newZip);
    Assert.assertEquals(newZip, this.address.getZip());
  }

  @Test
  public void setState() {
    String newState = "CA";
    this.address.setState(newState);
    Assert.assertEquals(newState, this.address.getState());
  }

  @Test
  public void setCountry() {
    String newCountry = "Canada";
    this.address.setCountry(newCountry);
    Assert.assertEquals(newCountry, this.address.getCountry());
  }

  @Test
  public void testToString() {
    String str;
    str = "4510 University Way\n"
        + "Seattle, WA 98105\n"
        + "USA";
    Assert.assertEquals(str, this.address.toString());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.address.equals(tempAddress));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(tempAddress.getStreetAndNum(), tempAddress.getCity(),
        tempAddress.getZip(),	tempAddress.getState(), tempAddress.getCountry());
    Assert.assertEquals(hash, this.address.hashCode());
  }
}