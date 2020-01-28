package assignment4;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupLeaderTest {
	private GroupLeader groupLeader;
	private String name;

	@Before
	public void setUp() throws Exception {
		name = "Test Leader";
		groupLeader = new GroupLeader(name);
	}

	@Test
	public void getName() {
		Assert.assertEquals(name, this.groupLeader.getName());
	}

	@Test
	public void testEquals() {
		GroupLeader testLeader = new GroupLeader(name);
		Assert.assertTrue(this.groupLeader.equals(testLeader));
	}

	@Test
	public void testHashCode() {
		int hash = Objects.hash(name);
		Assert.assertEquals(hash, this.groupLeader.hashCode());
	}

	@Test
	public void testToString() {
		String str = "GroupLeader{name='Test Leader'}";
		Assert.assertEquals(str, this.groupLeader.toString());
	}
}