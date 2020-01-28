package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Door class.
 */
public class DoorTest {
  private Door door;
  private boolean includeHandle;

  @Before
  public void setUp() throws Exception {
    door = new Door("wardrobe");
  }

  @Test
  public void getSize() {
    Assert.assertEquals("wardrobe", this.door.getSize());
  }

  @Test
  public void getIncludeHandle() {
    Assert.assertEquals(true, this.door.getIncludeHandle());
  }
}