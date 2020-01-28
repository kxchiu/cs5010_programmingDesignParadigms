import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private Person person;
  private Name name;
  private AddressInfo addressInfo;
  private ContactInfo contactInfo;

  @Before
  public void setUp() throws Exception {
    name = new Name("Test first", "Test last");
    addressInfo = new AddressInfo("Test company", "Test address", "Test city",
        "Test county", "Test state", "Test zip");
    contactInfo = new ContactInfo("123-456-7890", "098-765-4321", "test@email.com", "www.testwebsite.com");
    person = new Person(name, addressInfo, contactInfo);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Test first", this.person.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Test last", this.person.getLastName());
  }

  @Test
  public void getCompanyName() {
    Assert.assertEquals("Test company", this.person.getCompanyName());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("Test address", this.person.getAddress());
  }

  @Test
  public void getCity() {
    Assert.assertEquals("Test city", this.person.getCity());
  }

  @Test
  public void getCounty() {
    Assert.assertEquals("Test county", this.person.getCounty());
  }

  @Test
  public void getState() {
    Assert.assertEquals("Test state", this.person.getState());
  }

  @Test
  public void getZip() {
    Assert.assertEquals("Test zip", this.person.getZip());
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("test@email.com", this.person.getEmail());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Test first Test last", this.person.toString());
  }

  @Test
  public void testEquals() {
    Person temp = new Person(name, addressInfo, contactInfo);
    Assert.assertTrue(this.person.equals(temp));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Test first", "Test last", "Test company", "Test address", "Test city",
        "Test county", "Test state", "Test zip", "test@email.com");
    Assert.assertEquals(hash, this.person.hashCode());
  }
}