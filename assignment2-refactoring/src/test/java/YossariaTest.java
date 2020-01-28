import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YossariaTest {
	private Yossaria yossaria;

	@Before
	public void setUp() throws Exception {
		yossaria = new Yossaria("quarter");
	}

	@Test
	public void setColors() {
		this.yossaria.setColors("wardrobe");
		String actual = "[" + String.join(", ", this.yossaria.getColors()).trim() + "]";
		Assert.assertEquals("[Brown, Black, Bone, Brown, Black, Bone, Oxblood]", actual);
	}

	@Test
	public void getColors() {
		String actual = "[" + String.join(", ", this.yossaria.getColors()).trim() + "]";
		Assert.assertEquals("[Brown, Black, Bone]", actual);
	}

	@Test
	public void setMaxShelfNum() {
		Assert.assertEquals(3, this.yossaria.getMaxShelfNum());
	}
}