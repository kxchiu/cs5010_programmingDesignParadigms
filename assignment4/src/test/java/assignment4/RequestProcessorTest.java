package assignment4;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestProcessorTest {
	private RequestProcessor requestProcessor;
	private JSONObject requestDetails;

	@Before
	public void setUp() throws Exception {
		requestProcessor = new RequestProcessor("request.json");
		requestDetails = requestProcessor.parseData("request.json");
	}

	@Test
	public void parseData() {
		JSONParser jsonParser = new JSONParser();
		JSONObject request = null;
		try (FileReader reader = new FileReader("request.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			request = (JSONObject) obj;
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(request, this.requestProcessor.parseData("request.json"));
	}

	@Test
	public void getGroupName() {
		String groupName = (String) this.requestDetails.get(VariableNames.VAR_GROUP);
		Assert.assertEquals(groupName, this.requestProcessor.getGroupName());
	}

	@Test
	public void getLeaderName() {
		String leaderName = (String) this.requestDetails.get(VariableNames.VAR_LEADER);
		Assert.assertEquals(leaderName, this.requestProcessor.getLeaderName());
	}

	@Test
	public void getAttendee() {
		int numAtt = 3;
		Assert.assertEquals(numAtt, this.requestProcessor.getAttendee());
	}

	@Test
	public void getWheelchair() {
		int numWhe = Integer.parseInt((String) this.requestDetails.get(VariableNames.VAR_WHEELCHAIR));
		Assert.assertEquals(numWhe, this.requestProcessor.getWheelchair());
	}

	@Test
	public void testEquals() {
		RequestProcessor testProcessor = new RequestProcessor("request.json");
		Assert.assertTrue(this.requestProcessor.equals(testProcessor));
	}

	@Test
	public void testHashCode() {
		int hash = Objects.hash(requestDetails);
		Assert.assertEquals(hash, this.requestProcessor.hashCode());
	}
}