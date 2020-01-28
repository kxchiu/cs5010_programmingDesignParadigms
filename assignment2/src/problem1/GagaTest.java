package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Gaga class.
 */
public class GagaTest {
  private Gaga gaga;

  @Before
  public void setUp() throws Exception {
    gaga = new Gaga("half");
  }

  @Test
  public void getIncludeHandle() {
    Assert.assertEquals(false, this.gaga.getIncludeHandle());
  }

  @Test
  public void getColors() {
    String actual = "[" + String.join(", ", this.gaga.getColors()).trim() + "]";
    Assert.assertEquals("[Black, Bone, Oxblood]", actual);
  }
}