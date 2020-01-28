package problem3;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Journal class.
 */

public class JournalTest {
  private Journal testJournal;
  private String[] authors;
  private String publisher;
  private String[] editors;

  @Before
  public void setUp() throws Exception {
    this.authors = new String[]{"Sir A", "Madam B", "Mister C"};
    this.publisher = "Some Publisher";
    this.editors = new String[]{"Miss D, Boy E"};
    this.testJournal = new Journal("Pub Title", authors, 2019, 100, publisher, editors);
  }

  @Test
  public void getPublisher() {
    Assert.assertEquals("Some Publisher", this.testJournal.getPublisher());
  }

  @Test
  public void getEditors() {
    Assert.assertEquals("[Miss D, Boy E]", this.testJournal.getEditors());
  }

  @Test
  public void estimateImpact() throws ImpactEstimationException {
    double base = (((double)100) / 1 + 100) * 2;
    Assert.assertTrue(base == this.testJournal.estimateImpact());
  }

  @Test
  public void testToString() {
    String str;
    str = "Title: Pub Title\n" +
        "Authors: [Sir A, Madam B, Mister C]\n" +
        "Published Year: 2019\n" +
        "Number of Citations: 100\n" +
        "Publisher: Some Publisher\n" +
        "Editors: [Miss D, Boy E]";
    Assert.assertEquals(str, this.testJournal.toString());
  }

  @Test
  public void testEquals() {
    Journal test = new Journal("Pub Title", authors, 2019, 100, publisher, editors);
    Assert.assertTrue(this.testJournal.equals(test));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Pub Title", Arrays.toString(authors), 2019, 100, publisher,
        Arrays.toString(editors));
    Assert.assertEquals(hash, this.testJournal.hashCode());
  }
}