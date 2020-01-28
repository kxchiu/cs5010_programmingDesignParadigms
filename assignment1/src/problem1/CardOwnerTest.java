package problem1;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the CardOwner class.
 */

public class CardOwnerTest {
  private CardOwner john;

  @Before
  public void setUp() throws Exception {
    this.john = new CardOwner("John", "Doe", "401 Terry Ave N #103, Seattle, WA", "john@doe.com");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("John", this.john.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Doe", this.john.getLastName());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("401 Terry Ave N #103, Seattle, WA", this.john.getAddress());
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("john@doe.com", this.john.getEmail());
  }

  @Test
  public void testToString() {
    String str;
    str = "Name: John Doe" + "\n" +
        "Address: 401 Terry Ave N #103, Seattle, WA" + "\n" +
        "Email: john@doe.com";
    Assert.assertEquals(str, this.john.toString());
  }

  @Test
  public void testEquals() {
    CardOwner testOwner = new CardOwner("John", "Doe",
        "401 Terry Ave N #103, Seattle, WA", "john@doe.com");
    Assert.assertTrue(this.john.equals(testOwner));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("John", "Doe", "401 Terry Ave N #103, Seattle, WA", "john@doe.com");
    Assert.assertEquals(hash, this.john.hashCode());
  }
}