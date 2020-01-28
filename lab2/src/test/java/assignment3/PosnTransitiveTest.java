package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the transitive equals() case if x = y and y = z, then x = z;
 * tests the 3rd contract for hashCode() case if x != y, then x.hashCode() != y.hashCode().
 */
public class PosnTransitiveTest {
  private Posn posn;
  private Posn posn2;
  private Integer x;
  private Integer y;
  private Integer z;

  @Before
  public void setUp() throws Exception {
    x = 4;
    y = 4;
    z = 4;
    posn = new Posn(x, y);
    posn2 = new Posn(y, z);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.posn.getX().equals(this.posn.getY()) ==
        this.posn2.getX().equals(this.posn2.getY()));
  }

  @Test
  public void testHashCode() {
    Integer v = 3;
    Posn posn3 = new Posn(x, v);
    Assert.assertTrue(posn3.getX().hashCode() != posn3.getY().hashCode());
  }
}