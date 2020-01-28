package problem3;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Conference Proceeding class.
 */

public class ConferenceProceedingTest {
  private ConferenceProceeding conferenceProceeding;
  private String confName;
  private String confLocation;
  private String[] authors;

  @Before
  public void setUp() throws Exception {
    this.confName = "Some Conf Name";
    this.confLocation = "Seattle";
    this.authors = new String[]{"Sir A", "Madam B", "Mister C"};
    this.conferenceProceeding = new ConferenceProceeding("Pub Title", authors,
        2019, 100, confName, confLocation);
  }

  @Test
  public void getConfName() {
    Assert.assertEquals("Some Conf Name", this.conferenceProceeding.getConfName());
  }

  @Test
  public void getConfLocation() {
    Assert.assertEquals("Seattle", this.conferenceProceeding.getConfLocation());
  }

  @Test
  public void testToString() {
    String str;
    str = "Title: Pub Title\n" +
        "Authors: [Sir A, Madam B, Mister C]\n" +
        "Published Year: 2019\n" +
        "Number of Citations: 100\n" +
        "Conference Name: Some Conf Name\n" +
        "Conference Location: Seattle";
    Assert.assertEquals(str, this.conferenceProceeding.toString());
  }

  @Test
  public void testEquals() {
    ConferenceProceeding testProceeding = new ConferenceProceeding("Pub Title", authors,
        2019, 100, confName, confLocation);
    Assert.assertTrue(this.conferenceProceeding.equals(testProceeding));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Pub Title", Arrays.toString(authors),
        2019, 100, confName, confLocation);
    Assert.assertEquals(hash, this.conferenceProceeding.hashCode());
  }
}