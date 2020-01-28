package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents a venue with a given number of sections, and number of rows and columns for
 * each. It keeps track of the group-to-section and group-to-leader arrangement information.
 */
public class Venue {
	private int numSections;
	private int numRow;
	private int numCol;
	private int seatAvailable;
	private List<Section> sectionList;
	private Map<String, List<Integer>> groupToSect = new HashMap<String, List<Integer>>();
	private Map<String, GroupLeader> groupToLeader = new HashMap<String, GroupLeader>();

	/**
	 * Constructs a new venue given the number of sections, and number of rows and columns for each.
	 * @param numSections the number of sections in the venue
	 * @param numRow the number of rows in each section
	 * @param numCol the number of columns in each section
	 */
	public Venue(int numSections, int numRow, int numCol) {
		this.numSections = numSections;
		this.numRow = numRow;
		this.numCol = numCol;
		this.seatAvailable = calculateSeatAvailable(numSections, numRow, numCol);
		this.sectionList = createSection(numSections, numRow, numCol);
	}

	/**
	 * Create and return a list of sections.
	 * @param numSections the number of sections in the venue
	 * @return a list of sections
	 */
	private List<Section> createSection(int numSections, int numRow, int numCol) {
		List<Section> sections = new ArrayList<Section>();
		for (int i = 1; i <= numSections; i++) {
			sections.add(new Section(i, numRow, numCol));
		}
		return sections;
	}

	/**
	 * Calculate and returns a initial total number of seats available.
	 * @param numSections the number of sections in the venue
	 * @param numRow the number of rows in each section
	 * @param numCol the number of columns in each section
	 * @return the initial total number of seats available
	 */
	private int calculateSeatAvailable(int numSections, int numRow, int numCol) {
		return numSections * numRow * numCol;
	}

	/**
	 * Returns the current total number of seats available in the venue.
	 * @return the current total number of seats available
	 */
	public int getSeatAvailable() {
		return this.seatAvailable;
	}

	/**
	 * Returns the total number of regular seats available in the venue.
	 * @return the total number of regular seats available
	 */
	public int getNormalSeatAvail() {
		int currSeatAvail = 0;
		for (Section section : this.sectionList) {
			currSeatAvail += section.getNumRegSeat();
		}
		return currSeatAvail;
	}

	/**
	 * Returns the total number of wheelchair seats available in the venue.
	 * @return the total number of wheelchair seats available
	 */
	public int getWheelchairSeatAvail() {
		int currSeatAvail = 0;
		for (Section section : this.sectionList) {
			currSeatAvail += section.getNumWheelchairSeat();
		}
		return currSeatAvail;
	}

	/**
	 * Returns the list of sections in the venue.
	 * @return the list of sections
	 */
	public List<Section> getSectionList() {
		return this.sectionList;
	}

	/**
	 * Takes the group name and returns the group leader name.
	 * @param groupName the group name
	 * @return the group leader name
	 */
	public GroupLeader getLeaderByGroupName(String groupName) {
		return this.groupToLeader.get(groupName);
	}

	/**
	 * Compares an object to the venue and returns result as Boolean.
	 * @param o the passed-in object
	 * @return the comparison result
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Venue venue = (Venue) o;
		return numSections == venue.numSections &&
				numRow == venue.numRow &&
				numCol == venue.numCol &&
				seatAvailable == venue.seatAvailable &&
				sectionList.equals(venue.sectionList) &&
				groupToSect.equals(venue.groupToSect) &&
				groupToLeader.equals(venue.groupToLeader);
	}

	/**
	 * Returns a hashcode of the venue object.
	 * @return a hashcode of the venue
	 */
	@Override
	public int hashCode() {
		return Objects
				.hash(numSections, numRow, numCol, seatAvailable);
	}
}
