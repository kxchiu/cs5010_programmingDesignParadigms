package assignment4;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {
	private Section section;
	private int sectionNum;
	private int row;
	private int col;
	private int numRegSeatAvail;
	private int numWheelchairSeatAvail;

	@Before
	public void setUp() throws Exception {
		sectionNum = 2;
		row = 5;
		col = 10;
		section = new Section(sectionNum, row, col);
	}

	@Test
	public void getSectionNum() {
		Assert.assertEquals(sectionNum, this.section.getSectionNum());
	}

	@Test
	public void getNumRegSeat() {
		int regSeat = (row - 1) * col;
		Assert.assertEquals(regSeat, this.section.getNumRegSeat());
	}

	@Test
	public void getNumWheelchairSeat() {
		int wheelchairSeat = col;
		Assert.assertEquals(wheelchairSeat, this.section.getNumWheelchairSeat());
	}

	@Test
	public void updateNumRegSeat() {
		section.updateNumRegSeat(-5);
		Assert.assertEquals(35, this.section.getNumRegSeat());
	}

	@Test
	public void updateNumWheelchairSeat() {
		section.updateNumWheelchairSeat(-5);
		Assert.assertEquals(5, this.section.getNumWheelchairSeat());
	}

	@Test
	public void testEquals() {
		Section testSection = new Section(sectionNum, row, col);
		Assert.assertTrue(this.section.equals(testSection));
	}

	@Test
	public void testHashCode() {
		int hash = Objects.hash(sectionNum, row, col, 40, 10);
		Assert.assertEquals(hash, this.section.hashCode());
	}
}