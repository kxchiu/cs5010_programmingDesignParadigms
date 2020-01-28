package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the reflexive equals() case if x.equals(x) should return true;
 * tests the 1st contract for hashCode() case where multiple invocations of x.hashCode() should
 * return the same result.
 */
public class PosnReflexiveTest {
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
    Assert.assertTrue(this.posn.getX().equals(x));
  }

  @Test
  public void testHashCode() {
    int hash = this.x.hashCode();
    Assert.assertEquals(hash, this.posn.getX().hashCode());
  }
}