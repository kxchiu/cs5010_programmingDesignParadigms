package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the consistent equals() case if x = y, then x.equals(y) should return true given that the
 * value of x and y remained the unaltered.
 */
public class PosnConsistentTest {
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
    Assert.assertTrue(this.posn.getX().equals(this.posn.getY())
        && !this.posn.getX().equals(this.posn.getY() + 1));
  }
}