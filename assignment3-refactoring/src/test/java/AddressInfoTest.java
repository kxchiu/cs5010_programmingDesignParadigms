import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressInfoTest {
  private AddressInfo addressInfo;

  @Before
  public void setUp() throws Exception {
    addressInfo = new AddressInfo("Test company", "Test address", "Test city",
        "Test county", "Test state", "Test zip");
  }

  @Test
  public void getCompanyName() {
    Assert.assertEquals("Test company", this.addressInfo.getCompanyName());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("Test address", this.addressInfo.getAddress());
  }
  @Test
  public void getCity() {
    Assert.assertEquals("Test city", this.addressInfo.getCity());
  }

  @Test
  public void getCounty() {
    Assert.assertEquals("Test county", this.addressInfo.getCounty());
  }

  @Test
  public void getState() {
    Assert.assertEquals("Test state", this.addressInfo.getState());
  }

  @Test
  public void getZip() {
    Assert.assertEquals("Test zip", this.addressInfo.getZip());
  }

  @Test
  public void testToString() {
    String str;
    str = "Test company\n"
        + "Test address\n"
        + "Test city, Test state Test zip";
    Assert.assertEquals(str, this.addressInfo.toString());
  }

  @Test
  public void testEquals() {
    AddressInfo temp = new AddressInfo("Test company", "Test address", "Test city",
        "Test county", "Test state", "Test zip");
    Assert.assertTrue(this.addressInfo.equals(temp));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("Test company", "Test address", "Test city",
        "Test county", "Test state", "Test zip");
    Assert.assertEquals(hash, this.addressInfo.hashCode());
  }
}