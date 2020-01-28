import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabinetTest {
	private Cabinet cabinet;

	@Before
	public void setUp() throws Exception {
		cabinet = new Cabinet("wardrobe");
	}

	@Test
	public void getFloorMountOption() {
		Assert.assertEquals(true, this.cabinet.getFloorMountOption());
	}

	@Test
	public void getWallMountOption() {
		Assert.assertEquals(false, this.cabinet.getWallMountOption());
	}

	@Test
	public void getEarthquakeSafety() {
		Assert.assertEquals(true, this.cabinet.getEarthquakeSafety());
	}

	@Test
	public void setMaxShelfNum() {
		Assert.assertEquals(7, this.cabinet.getMaxShelfNum());
	}

	@Test
	public void getDepth() {
		Assert.assertEquals(16, this.cabinet.getDepth());
	}
}