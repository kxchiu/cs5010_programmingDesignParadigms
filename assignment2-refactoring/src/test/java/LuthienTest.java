import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuthienTest {
	private Luthien luthien;

	@Before
	public void setUp() throws Exception {
		luthien = new Luthien("half");
	}

	@Test
	public void setMaxShelfNum() {
		Assert.assertEquals(3, this.luthien.getMaxShelfNum());
	}

	@Test
	public void setMaxDrawerNum() {
		Assert.assertEquals(1, this.luthien.getMaxDrawerNum());
	}

	@Test
	public void getColors() {
		String actual = "[" + String.join(", ", this.luthien.getColors()).trim() + "]";
		Assert.assertEquals("[Black, Bone]", actual);
	}
}