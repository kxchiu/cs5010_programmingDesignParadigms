package problem1;

import java.util.Objects;
import org.junit.Assert;

/**
 * Test class for the TransitCard class.
 */

public class TransitCardTest {
  private TransitCard newCard;
  private CardOwner john;
  private Deposit newDeposit;

  @org.junit.Before
  public void setUp() throws Exception {
    this.john = new CardOwner("John", "Doe", "401 Terry Ave N #103, Seattle, WA", "john@doe.com");
    this.newCard = new TransitCard(john, 10, 10);
    this.newDeposit = new Deposit(10, 90, "John", "Doe");
  }

  @org.junit.Test
  public void depositMoney() {
    newCard.depositMoney(newDeposit);
    Assert.assertEquals("21.00", this.newCard.toString());
  }

  @org.junit.Test
  public void getDollar() {
    Assert.assertEquals(new Long(10), new Long(this.newCard.getDollar()));
  }

  @org.junit.Test
  public void getCent() {
    Assert.assertEquals(new Long(10), new Long(this.newCard.getCent()));
  }

  @org.junit.Test
  public void testToString() {
    String str;
    str = "10.10";
    Assert.assertEquals(str, this.newCard.toString());
  }

  @org.junit.Test
  public void testEquals() {
    TransitCard testCard = new TransitCard(john, 10, 10);
    Assert.assertTrue(this.newCard.equals(testCard));
  }

  @org.junit.Test
  public void testHashCode() {
    int hash = Objects.hash(10, 10, john);
    Assert.assertEquals(hash, this.newCard.hashCode());
  }
}