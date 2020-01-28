package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the symmetric equals() case if x = y, then y = x;
 * tests the 2nd contract for hashCode() case if x = y, then x.hashCode() == y.hashCode().
 */
public class PosnSymmetricTest {
  private Posn posn;
  private Integer x;
  private Integer y;

  @Before
  public void setUp() throws Exception {
    x = 4;
    y = 4;
    posn = new Posn(x, y);
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(this.posn.getX().equals(y), this.posn.getY().equals(x));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.posn.getX().hashCode(), this.posn.getY().hashCode());
  }
}