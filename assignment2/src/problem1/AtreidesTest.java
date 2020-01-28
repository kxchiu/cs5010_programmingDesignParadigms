package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Atreides class.
 */

public class AtreidesTest {
  private Atreides atreides;


  @Before
  public void setUp() throws Exception {
    atreides = new Atreides("quarter");
  }

  @Test
  public void setMaxShelfNum() {
    Assert.assertEquals(1, this.atreides.getMaxShelfNum());
  }

  @Test
  public void getColors() {
    String actual = "[" + String.join(", ", this.atreides.getColors()).trim() + "]";
    Assert.assertEquals("[Brown, Bone]", actual);
  }
}