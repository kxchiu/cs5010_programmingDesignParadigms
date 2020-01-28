package problem2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Artist class.
 */

public class ArtistTest {
  private Artist john;

  @Before
  public void setUp() throws Exception {
    List<String> awards = Arrays.asList("one", "two", "three");
    this.john = new Artist("John Doe", 21, "Anything", awards);
  }

  @Test
  public void getName() {
    Assert.assertEquals("John Doe", this.john.getName());
  }

  @Test
  public void getAge() {
    Assert.assertEquals(21, this.john.getAge());
  }

  @Test
  public void getGenre() {
    Assert.assertEquals("Anything", this.john.getGenre());
  }

  @Test
  public void getAwards() {
    List<String> testAwards = Arrays.asList("one", "two", "three");
    Assert.assertEquals(testAwards, this.john.getAwards());
  }

  @Test
  public void testToString() {
    String str;
    str = "Name: John Doe\n"
        + "Age: 21\n"
        + "Genre: Anything\n"
        + "Awards: [one, two, three]";
    Assert.assertEquals(str, this.john.toString());
  }

  @Test
  public void testEquals() {
    List<String> testAwards = Arrays.asList("one", "two", "three");
    Artist testJohn = new Artist("John Doe", 21, "Anything", testAwards);
    Assert.assertTrue(this.john.equals(testJohn));
  }

  @Test
  public void testHashCode() {
    List<String> testAwards = Arrays.asList("one", "two", "three");
    int hash = Objects.hash("John Doe", 21, "Anything", testAwards);
    Assert.assertEquals(hash, this.john.hashCode());
  }
}