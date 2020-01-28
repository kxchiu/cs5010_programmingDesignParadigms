package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Slothrop class.
 */
public class SlothropTest {
  private Slothrop slothrop;

  @Before
  public void setUp() throws Exception {
    slothrop = new Slothrop("wardrobe");
  }

  @Test
  public void getIncludeHandle() {
    Assert.assertEquals(true, this.slothrop.getIncludeHandle());
  }

  @Test
  public void getColors() {
    String actual = "[" + String.join(", ", this.slothrop.getColors()).trim() + "]";
    Assert.assertEquals("[Brown, Black]", actual);
  }
}