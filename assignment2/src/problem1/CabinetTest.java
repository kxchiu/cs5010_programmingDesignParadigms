package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Cabinet class.
 */
public class CabinetTest {
  private Cabinet cabinet;

  @Before
  public void setUp() throws Exception {
    cabinet = new Cabinet("wardrobe");
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(72, this.cabinet.getHeight());
  }

  @Test
  public void setHeight() {
    this.cabinet.setHeight("half");
    Assert.assertEquals(36, this.cabinet.getHeight());
  }

  @Test
  public void getWidth() {
    Assert.assertEquals(36, this.cabinet.getWidth());
  }

  @Test
  public void getDepth() {
    Assert.assertEquals(16, this.cabinet.getDepth());
  }

  @Test
  public void getSize() {
    Assert.assertEquals("wardrobe", this.cabinet.getSize());
  }

  @Test
  public void getFloorMountOption() {
    Assert.assertEquals(true, this.cabinet.getFloorMountOption());
  }

  @Test
  public void getWallMountOption() {
    Assert.assertEquals(false, this.cabinet.getWallMountOption());
  }

  @Test
  public void getEarthquakeSafety() {
    Assert.assertEquals(true, this.cabinet.getEarthquakeSafety());
  }

  @Test
  public void getMaxShelfNum() {
    Assert.assertEquals(7, this.cabinet.getMaxShelfNum());
  }
}