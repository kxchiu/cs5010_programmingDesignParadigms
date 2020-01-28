package assignment4;

import java.util.Objects;

/**
 * This class represents a section of the venue, with given number of rows and columns.
 */
public class Section {
	private int sectionNum;
	private int row;
	private int col;
	private int numRegSeatAvail;
	private int numWheelchairSeatAvail;

	/**
	 * Constructs a new section with given section number, number of rows and columns.
	 * @param sectionNum the section number
	 * @param row the number of rows
	 * @param col the number of columns
	 */
	public Section(int sectionNum, int row, int col) {
		this.sectionNum = sectionNum;
		this.row = row;
		this.col = col;
		this.numRegSeatAvail = calculateNumRegSeat(row, col);
		this.numWheelchairSeatAvail = col;
	}

	/**
	 * Returns the initial number of regular seats.
	 * @param row the number of rows
	 * @param col the number of columns
	 * @return the initial number of regular seats
	 */
	private int calculateNumRegSeat(int row, int col) {
		return (row - 1) * col;
	}

	/**
	 * Returns the section number.
	 * @return the section number
	 */
	public int getSectionNum() {
		return this.sectionNum;
	}

	/**
	 * Returns the number of regular seats available in the section.
	 * @return the number of regular seats
	 */
	public int getNumRegSeat() {
		return this.numRegSeatAvail;
	}

	/**
	 * Returns the number of wheelchair seats available in the section.
	 * @return the number of wheelchair seats
	 */
	public int getNumWheelchairSeat() {
		return this.numWheelchairSeatAvail;
	}

	/**
	 * Updates the number of regular seats available in the section.
	 * @param update the number of regular seats to be updated
	 */
	public void updateNumRegSeat(int update) {
		this.numRegSeatAvail += update;
	}

	/**
	 * Updates the number of regular seats available in the section.
	 * @param update the number of regular seats to be updated
	 */
	public void updateNumWheelchairSeat(int update) {
		this.numWheelchairSeatAvail += update;
	}

	/**
	 * Compares an object to the section and returns result as Boolean.
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
		Section section = (Section) o;
		return sectionNum == section.sectionNum &&
				row == section.row &&
				col == section.col &&
				numRegSeatAvail == section.numRegSeatAvail &&
				numWheelchairSeatAvail == section.numWheelchairSeatAvail;
	}

	/**
	 * Returns a hashcode of the section.
	 * @return a hashcode of the section
	 */
	@Override
	public int hashCode() {
		return Objects.hash(sectionNum, row, col, numRegSeatAvail, numWheelchairSeatAvail);
	}
}
