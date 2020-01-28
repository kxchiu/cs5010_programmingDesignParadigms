package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AthleteTest {
	private Athlete athlete;

	@Before
	public void setUp() throws Exception {
		athlete = new Athlete("Athlete Guy", 187.97, 155.00, "League");
	}

	@Test
	public void getAthletesName() {
		Assert.assertEquals("Athlete Guy", this.athlete.getAthletesName());
	}

	@Test
	public void getHeight() {
		Assert.assertTrue(187.97 == this.athlete.getHeight());
	}

	@Test
	public void getWeight() {
		Assert.assertTrue((155.00 == this.athlete.getWeight()));
	}

	@Test
	public void getLeague() {
		Assert.assertEquals("League", this.athlete.getLeague());
	}
}