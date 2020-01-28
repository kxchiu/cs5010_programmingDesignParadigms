package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Belacqua class.
 */
public class BelacquaTest {
  private Belacqua belacqua;

  @Before
  public void setUp() throws Exception {
    belacqua = new Belacqua("half");
  }

  @Test
  public void getIncludeHandle() {
    Assert.assertEquals(true, this.belacqua.getIncludeHandle());
  }

  @Test
  public void getColors() {
    String actual = "[" + String.join(", ", this.belacqua.getColors()).trim() + "]";
    Assert.assertEquals("[Bone, Oxblood]", actual);
  }
}