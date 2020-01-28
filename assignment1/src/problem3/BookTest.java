package problem3;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Book test.
 */

public class BookTest {
  private Book testBook;
  private String[] authors;
  private String publisher;

  @Before
  public void setUp() throws Exception {
    this.authors = new String[]{"Sir A", "Madam B", "Mister C"};
    this.publisher = "Some Publisher";
    this.testBook = new Book("Pub Title", authors, 2019, 100, publisher, 199);
  }

  @Test
  public void getPublisher() {
    Assert.assertEquals("Some Publisher", this.testBook.getPublisher());
  }

  @Test
  public void getPage() {
    Assert.assertEquals(new Long(199), new Long(this.testBook.getPage()));
  }

  @Test
  public void estimateImpact() throws ImpactEstimationException {
    double base = (((double)100) / 1 + 100) * 4;
    Assert.assertTrue(base == this.testBook.estimateImpact());
  }

  @Test
  public void testToString() {
    String str;
    str = "Title: Pub Title\n" +
        "Authors: [Sir A, Madam B, Mister C]\n" +
        "Published Year: 2019\n" +
        "Number of Citations: 100\n" +
        "Publisher: Some Publisher\n" +
        "Number of Page: 199";
    Assert.assertEquals(str, this.testBook.toString());
  }

  @Test
  public void testEquals() {
    Book test = new Book("Pub Title", authors, 2019, 100, publisher, 199);
    Assert.assertTrue(this.testBook.equals(test));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Pub Title", Arrays.toString(authors), 2019, 100, publisher, 199);
    Assert.assertEquals(hash, this.testBook.hashCode());
  }
}