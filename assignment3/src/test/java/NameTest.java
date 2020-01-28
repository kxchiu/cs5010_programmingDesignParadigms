import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Test first", "Test last");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Test first", this.name.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Test last", this.name.getLastName());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Test firstTest last", this.name.toString());
  }

  @Test
  public void testEquals() {
    Name temp = new Name("Test first", "Test last");
    Assert.assertTrue(this.name.equals(temp));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Test first", "Test last");
    Assert.assertEquals(hash, this.name.hashCode());
  }
}