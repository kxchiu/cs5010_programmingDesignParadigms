import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoorTest {
	private Door door;
	private boolean includeHandle;

	@Before
	public void setUp() throws Exception {
		door = new Door("wardrobe");
	}

	@Test
	public void getIncludeHandle() {
		Assert.assertEquals(true, this.door.getIncludeHandle());
	}
}