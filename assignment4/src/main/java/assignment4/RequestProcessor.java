package assignment4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class represents a request processor that takes in a JSON Object and pulls out information.
 */
public class RequestProcessor extends VariableNames{
	private JSONObject requestDetails;

	/**
	 * Constructs a new request processor.
	 * @param fileName the given request file name
	 */
	public RequestProcessor(String fileName) {
		this.requestDetails = parseData(fileName);
	}

	/**
	 * Parse and return the data as a JSON Object.
	 * @param fileName the given request file name
	 * @return the data
	 */
	public JSONObject parseData(String fileName) {
		JSONParser jsonParser = new JSONParser();
		JSONObject request = null;
		try (FileReader reader = new FileReader(fileName)) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			request = (JSONObject) obj;
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return (JSONObject) request;
	}

	/**
	 * Returns the group name as String.
	 * @return the group name
	 */
	public String getGroupName() {
		return (String) this.requestDetails.get(VariableNames.VAR_GROUP);
	}

	/**
	 * Returns the leader name as String.
	 * @return the leader name
	 */
	public String getLeaderName() {
		return (String) this.requestDetails.get(VariableNames.VAR_LEADER);
	}

	/**
	 * Returns the number of regular attendees as int.
	 * @return the number of regular attendees
	 */
	public int getAttendee() {
		return Integer.parseInt((String) this.requestDetails.get(VariableNames.VAR_ATTENDEE));
	}

	/**
	 * Returns the number of wheelchair attendees as int.
	 * @return the number of wheelchair attendee
	 */
	public int getWheelchair() {
		return Integer.parseInt((String) this.requestDetails.get(VariableNames.VAR_WHEELCHAIR));
	}

	/**
	 * Compares an object to the request processor and returns result as Boolean.
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
		RequestProcessor that = (RequestProcessor) o;
		return requestDetails.equals(that.requestDetails);
	}

	/**
	 * Returns a hashcode of the request processor object.
	 * @return a hashcode of the request processor
	 */
	@Override
	public int hashCode() {
		return Objects.hash(requestDetails);
	}
}
