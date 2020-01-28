package assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VenueTest {
	private Venue venue;
	private int numSections;
	private int numRow;
	private int numCol;
	private int seatAvailable;
	private List<Section> sectionList;
	private Map<String, List<Integer>> groupToSect = new HashMap<String, List<Integer>>();
	private Map<String, GroupLeader> groupToLeader = new HashMap<String, GroupLeader>();

	@Before
	public void setUp() throws Exception {
		numSections = 3;
		numRow = 5;
		numCol = 10;
		venue = new Venue(numSections, numRow, numCol);
	}

	@Test
	public void getSeatAvailable() {
		int seatsAvail = numSections * numRow * numCol;
		Assert.assertEquals(seatsAvail, this.venue.getSeatAvailable());
	}

	@Test
	public void getNormalSeatAvail() {
		int normalSeats = numSections * (numRow -1) * numCol;
		Assert.assertEquals(normalSeats, this.venue.getNormalSeatAvail());
	}

	@Test
	public void getWheelchairSeatAvail() {
		int wheelchairSeats = numSections * numCol;
		Assert.assertEquals(wheelchairSeats, this.venue.getWheelchairSeatAvail());
	}

	@Test
	public void getSectionList() {
		List<Section> sections = new ArrayList<Section>();
		for (int i = 1; i <= numSections; i++) {
			sections.add(new Section(i, numRow, numCol));
		}
		Assert.assertEquals(sections, this.venue.getSectionList());
	}

	@Test
	public void testEquals() {
		Venue testVenue = new Venue(numSections, numRow, numCol);
		Assert.assertTrue(this.venue.equals(testVenue));
	}

	@Test
	public void testHashCode() {
		int hash = Objects.hash(3, 5, 10, 150);
		Assert.assertEquals(hash, this.venue.hashCode());
	}
}