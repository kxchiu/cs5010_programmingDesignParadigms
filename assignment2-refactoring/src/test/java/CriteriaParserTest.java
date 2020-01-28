import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriteriaParserTest {
	private CriteriaParser criteriaParser;
	private JSONObject criteriaDetails;

	@Before
	public void setUp() throws Exception {
		criteriaParser = new CriteriaParser();
		criteriaDetails = criteriaParser.parseData();
	}

	@Test
	public void parseData() {
	}

	@Test
	public void getRequiredWidth() {
		Assert.assertEquals(72, criteriaParser.getRequiredWidth(criteriaDetails));
	}

	@Test
	public void convertHeightToSize() {
		Assert.assertEquals("wardrobe", criteriaParser.convertHeightToSize(criteriaDetails));
	}

	@Test
	public void getRequiredShelf() {
		int shelf = Integer.parseInt((String) criteriaDetails.get("shelves"));
		Assert.assertEquals(3, criteriaParser.getRequiredShelf(criteriaDetails));
	}

	@Test
	public void getRequiredDrawer() {
		Assert.assertEquals(0, criteriaParser.getRequiredDrawer(criteriaDetails));
	}

	@Test
	public void getRequiredColor() {
		Assert.assertEquals("Oxblood", criteriaParser.getRequiredColor(criteriaDetails));
	}

	@Test
	public void getFloorOrWall() {
		Assert.assertEquals("floor", criteriaParser.getFloorOrWall(criteriaDetails));
	}

	@Test
	public void getBudgetPriority() {
		Assert.assertEquals(false, criteriaParser.getBudgetPriority(criteriaDetails));
	}
}