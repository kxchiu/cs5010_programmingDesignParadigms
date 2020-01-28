package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {
  private BaseballPlayer baseballPlayer;

  @Before
  public void setUp() throws Exception {
    baseballPlayer = new BaseballPlayer("Athlete Guy", 189.97, 155.00, "NL",
        "LA Dodgers", 0.312, 35);
  }

  @Test
  public void getTeam() {
    Assert.assertEquals("LA Dodgers", this.baseballPlayer.getTeam());
  }

  @Test
  public void getBatAvg() {
    Assert.assertTrue(0.312 == this.baseballPlayer.getBatAvg());
  }

  @Test
  public void getSeasonHR() {
    Assert.assertTrue(35 == this.baseballPlayer.getSeasonHR());
  }
}