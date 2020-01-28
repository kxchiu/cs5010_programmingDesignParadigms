package problem3;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Publication class.
 */

public class PublicationTest {
  private Publication testPub;
  private String[] authors;

  @Before
  public void setUp() throws Exception {
    this.authors = new String[]{"Sir A", "Madam B", "Mister C"};
    this.testPub = new Publication("Pub Title", authors, 2019, 100);
  }

  @Test
  public void estimateImpact() throws ImpactEstimationException {
    double base = ((double)100) / 1 + 100;
    Assert.assertTrue(base == this.testPub.estimateImpact());
  }

  @Test
  public void getTitle() {
    Assert.assertEquals("Pub Title", this.testPub.getTitle());
  }

  @Test
  public void getAuthors() {
    Assert.assertEquals(Arrays.toString(authors), this.testPub.getAuthors());
  }

  @Test
  public void getPublishYear() {
    Assert.assertEquals(new Long(2019), new Long(this.testPub.getPublishYear()));
  }

  @Test
  public void getCitation() {
    Assert.assertEquals(new Long(100), new Long(this.testPub.getCitation()));
  }

  @Test
  public void setTitle() {
    this.testPub.setTitle("New Pub");
    Assert.assertEquals("New Pub", this.testPub.getTitle());
  }

  @Test
  public void setAuthors() {
    this.testPub.setAuthors(new String[]{"Sir A"});
    Assert.assertEquals("[Sir A]", this.testPub.getAuthors());
  }

  @Test
  public void setPublishYear() {
    this.testPub.setPublishYear(2018);
    Assert.assertEquals(new Long(2018), new Long(this.testPub.getPublishYear()));
  }

  @Test
  public void setCitation() {
    this.testPub.setCitation(200);
    Assert.assertEquals(new Long(200), new Long(this.testPub.getCitation()));
  }

  @Test
  public void testToString() {
    String str;
    str = "Title: Pub Title\n" +
        "Authors: [Sir A, Madam B, Mister C]\n" +
        "Published Year: 2019\n" +
        "Number of Citations: 100";
    Assert.assertEquals(str, this.testPub.toString());
  }

  @Test
  public void testEquals() {
    Publication test = new Publication("Pub Title", authors, 2019, 100);
    Assert.assertTrue(this.testPub.equals(test));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Pub Title", authors, 2019, 100);
    Assert.assertEquals(hash, this.testPub.hashCode());
  }
}