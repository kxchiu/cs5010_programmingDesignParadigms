package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents an arranger that manages the section arrangement and updates the requests.
 */
public class Arranger {

	/**
	 * Constructs a new arranger object.
	 */
	public Arranger() {
	}

	/**
	 * Makes the seat arrangement given the requirements.
	 * @param venue the venue to be arranged
	 * @param groupToSec the group-to-section map
	 * @param groupName the group name
	 * @param groupToLeader the group-to-leader map
	 * @param leaderName the group leader name
	 * @param numAttendee the number of regular attendee in the group
	 * @param numWheelchair the number of wheelchair attendee in the group
	 * @throws ReservationFailException - when the reservation fails
	 */
	public void arrange(Venue venue, HashMap<String, List<Integer>> groupToSec, String groupName,
			HashMap<String, GroupLeader> groupToLeader, String leaderName, int numAttendee,
			int numWheelchair)
			throws ReservationFailException {
		if (!checkVenueAvailable(venue, numAttendee, numWheelchair)) {
			throw new ReservationFailException("Venue currently unavailable for reservation.");
		} else {
			List<Section> sectionList = venue.getSectionList();
			List<Integer> sections = new ArrayList<Integer>();
			int attendeeToAdd = arrangeSection(sectionList, sections, numWheelchair, numAttendee);
			groupToSec.put(groupName, sections);
			groupToLeader.put(groupName, new GroupLeader(leaderName));
			if (attendeeToAdd > 0) {
				groupToSec.remove(groupName);
				throw new ReservationFailException("Unable to reserve for all attendees.");
			}
		}
	}

	/**
	 * Helper method to arrange section seats and returns the number of attendees left to be added.
	 * @param sectionList the list of sections in the venue
	 * @param sections a list of section numbers representing the sections attendees are added to
	 * @param numWheelchair the number of wheelchair attendees to be added
	 * @param numAttendee the number of regular attendees to be added
	 * @return the number of attendees left to be added
	 */
	private int arrangeSection(List<Section> sectionList, List<Integer> sections,
			int numWheelchair, int numAttendee) {
		int attendeeToAdd = numAttendee;
		for (Section section: sectionList) {
			if (attendeeToAdd > 0) {
				if (section.getNumWheelchairSeat() >= numWheelchair && section.getNumRegSeat() >= 1) {
					section.updateNumWheelchairSeat(numWheelchair);
					if (section.getNumRegSeat() < attendeeToAdd) {
						attendeeToAdd -= section.getNumRegSeat();
					} else {
						attendeeToAdd = 0;
					}
					section.updateNumRegSeat(attendeeToAdd);
					sections.add(section.getSectionNum());
				}
			}
		}
		return attendeeToAdd;
	}

	/**
	 * Returns if the venue has enough seats for regular and wheelchair attendees.
	 * @param venue the venue to be arranged
	 * @param numAttendee the number of regular attendee
	 * @param numWheelchair the number of wheelchair attendee
	 * @return if the venue has enough seats
	 */
	public boolean checkVenueAvailable(Venue venue, int numAttendee, int numWheelchair) {
		return venue.getNormalSeatAvail() >= numAttendee
				&& venue.getWheelchairSeatAvail() >= numWheelchair;
	}

	/**
	 * Make cancellation request for individuals.
	 * @param groupToSec the group-to-section mapping
	 * @param groupName the group name to be canceled
	 * @param venue the venue to be arranged
	 * @param numRegCancel the number of regular attendees to be removed
	 * @param numWheelCancel the number of wheelchair attendees to be removed
	 */
	public void requestCancellation(HashMap<String, List<Integer>> groupToSec, String groupName,
			Venue venue, int numRegCancel, int numWheelCancel) {
		List<Integer> sectionList = groupToSec.get(groupName);
		for (Section section : venue.getSectionList()) {
			for (int i = 0; i < sectionList.size(); i++) {
				if (sectionList.get(i) == section.getSectionNum()) {
					section.updateNumRegSeat(numRegCancel * -1);
					section.updateNumWheelchairSeat(numWheelCancel * -1);
				}
			}
		}
		groupToSec.remove(groupName);
	}
}
