package problem2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the MediaArtist class.
 */

public class MediaArtistTest {
  private MediaArtist john;
  List<String> testAwards;
  List<String> testMovies;
  List<String> testSeries;
  List<String> testOthers;

  @Before
  public void setUp() throws Exception {
    this.testAwards = Arrays.asList("one", "two", "three");
    this.testMovies = Arrays.asList("movie1", "movie2");
    this.testSeries = Arrays.asList("series1", "series2");
    this.testOthers = Arrays.asList("other1", "other2", "other3");
    this.john = new MediaArtist("John Doe", 21, "Anything", testAwards,
        testMovies, testSeries, testOthers);
  }

  @Test
  public void getMovies() {
    Assert.assertEquals(testMovies, this.john.getMovies());
  }

  @Test
  public void getSeries() {
    Assert.assertEquals(testSeries, this.john.getSeries());
  }

  @Test
  public void getOthers() {
    Assert.assertEquals(testOthers, this.john.getOthers());
  }

  @Test
  public void testToString() {
    String str;
    str = "Name: John Doe\n" +
        "Age: 21\n" +
        "Genre: Anything\n" +
        "Awards: [one, two, three]\n" +
        "Movies: [movie1, movie2]\n" +
        "TV Series: [series1, series2]\n" +
        "Other Work: [other1, other2, other3]";
    Assert.assertEquals(str, this.john.toString());
  }

  @Test
  public void testEquals() {
    MediaArtist testJohn = new MediaArtist("John Doe", 21, "Anything",
        testAwards, testMovies, testSeries, testOthers);
    Assert.assertTrue(this.john.equals(testJohn));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("John Doe", 21, "Anything", testAwards, testMovies,
        testSeries, testOthers);
    Assert.assertEquals(hash, this.john.hashCode());
  }
}