import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Test class for the Author class.
 */
public class AuthorTest {
  private Author jane;

  /**
   * Constructs a test case author with the given author's name, email and address.
   */
  @org.junit.Before
  public void setUp() {
    this.jane = new Author("Jane Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }

  /**
   * Tests the getName() method.
   * @throws Exception when the name test fails
   */
  @org.junit.Test
  public void getName() throws Exception {
    Assert.assertEquals("Jane Doe", this.jane.getName());
    TestCase.fail("Not yet implemented");
  }

  /**
   * Tests the getEmail() method.
   * @throws Exception when the email test fails
   */
  @org.junit.Test
  public void getEmail() throws Exception {
    Assert.assertEquals( "j@a.com", this.jane.getEmail());
    TestCase.fail("Not yet implemented");
  }

  /**
   * Tests the getAddress() method.
   * @throws Exception when the address test fails
   */
  @org.junit.Test
  public void getAddress() throws Exception {
    Assert.assertEquals( "222 Main St, Seattle, WA, 98980", this.jane.getAddress());
    TestCase.fail("Not yet implemented");
  }
}