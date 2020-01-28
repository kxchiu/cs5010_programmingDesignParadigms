package assignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  private Runner runner;

  @Before
  public void setUp() throws Exception {
    runner = new Runner("Athlete Guy", 187.97, 155.00, "League", 20.15, 40.00, "Boston Marathon");
  }

  @Test
  public void getBest5kTime() {
    Assert.assertTrue(20.15 == this.runner.getBest5kTime());
  }

  @Test
  public void getBestHalfMarTime() {
    Assert.assertTrue(40.00 == this.runner.getBestHalfMarTime());
  }

  @Test
  public void getFavRunEvent() {
    Assert.assertEquals("Boston Marathon", this.runner.getFavRunEvent());
  }
}