import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactInfoTest {
  private ContactInfo contactInfo;

  @Before
  public void setUp() throws Exception {
    contactInfo = new ContactInfo("123-456-7890", "098-765-4321", "test@email.com", "www.testwebsite.com");
  }

  @Test
  public void getPhone1() {
    Assert.assertEquals("123-456-7890", this.contactInfo.getPhone1());
  }

  @Test
  public void getPhone2() {
    Assert.assertEquals("098-765-4321", this.contactInfo.getPhone2());
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("test@email.com", this.contactInfo.getEmail());
  }

  @Test
  public void getWebsite() {
    Assert.assertEquals("www.testwebsite.com", this.contactInfo.getWebsite());
  }

  @Test
  public void testToString() {
    String str;
    str = "Phone: 123-456-7890, 098-765-4321\n"
        + "Email: test@email.com\n"
        + "Website: www.testwebsite.com";
    Assert.assertEquals(str, this.contactInfo.toString());
  }

  @Test
  public void testEquals() {
    ContactInfo temp = new ContactInfo("123-456-7890", "098-765-4321", "test@email.com", "www.testwebsite.com");
    Assert.assertTrue(this.contactInfo.equals(temp));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("123-456-7890", "098-765-4321", "test@email.com", "www.testwebsite.com");
    Assert.assertEquals(hash, this.contactInfo.hashCode());
  }
}