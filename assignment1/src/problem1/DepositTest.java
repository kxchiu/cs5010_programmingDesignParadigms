package problem1;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Deposit class.
 */

public class DepositTest {
  private Deposit newDeposit;

  @Before
  public void setUp() throws Exception {
    this.newDeposit = new Deposit(10, 90, "John", "Doe");
  }

  @Test
  public void getDollar() {
    Assert.assertEquals(10, this.newDeposit.getDollar());
  }

  @Test
  public void getCent() {
    Assert.assertEquals(90, this.newDeposit.getCent());
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("John", this.newDeposit.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Doe", this.newDeposit.getLastName());
  }

  @Test
  public void testToString() {
    String str;
    str = "Dollar: " + 10 + "\n" +
        "Cent: " + 90 + "\n" +
        "Name: John Doe";
    Assert.assertEquals(str, this.newDeposit.toString());
  }

  @Test
  public void testEquals() {
    Deposit testDeposit = new Deposit(10, 90, "John", "Doe");
    Assert.assertTrue(this.newDeposit.equals(testDeposit));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(10, 90, "John", "Doe");
    Assert.assertEquals(hash, this.newDeposit.hashCode());
  }
}