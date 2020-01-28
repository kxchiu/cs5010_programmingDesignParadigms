import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultGeneratorTest {
	private ResultGenerator resultGenerator;
	private CriteriaParser criteriaParser;
	private JSONObject criteriaDetails;
	private int requiredWidth;
	private String requiredHeight;
	private int requiredShelf;
	private int requiredDrawer;
	private String colorPreference;
	private String floorOrWall;
	private boolean budgetPriority;
	private JSONObject recommendation;

	@Before
	public void setUp() throws Exception {
		criteriaParser = new CriteriaParser();
		criteriaDetails = criteriaParser.parseData();

		// Finds user criteria
		requiredWidth = criteriaParser.getRequiredWidth(criteriaDetails);
		requiredHeight = criteriaParser.convertHeightToSize(criteriaDetails);
		requiredShelf = criteriaParser.getRequiredShelf(criteriaDetails);
		requiredDrawer = criteriaParser.getRequiredDrawer(criteriaDetails);
		colorPreference = criteriaParser.getRequiredColor(criteriaDetails);
		floorOrWall = criteriaParser.getFloorOrWall(criteriaDetails);
		budgetPriority = criteriaParser.getBudgetPriority(criteriaDetails);

		resultGenerator = new ResultGenerator(requiredWidth, requiredHeight, requiredShelf,
				requiredDrawer, colorPreference, floorOrWall, budgetPriority);
	}

	@Test
	public void calculates() {
		resultGenerator.calculates(requiredWidth, requiredHeight, requiredShelf,
				requiredDrawer, colorPreference, floorOrWall, budgetPriority);
	}
}