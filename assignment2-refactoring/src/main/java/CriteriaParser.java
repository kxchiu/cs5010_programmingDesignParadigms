import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class represents a criteria parser that reads from the user criteria and writes to a JSON
 * object.
 */
public class CriteriaParser {
	private static JSONObject criteriaDetails;
	private static final int FULL_HEIGHT = 72;
	private static final int HALF_SIZE_HEIGHT = 36;

	/**
	 * Constructs a new criteria parse.
	 */
	public CriteriaParser() {
		this.criteriaDetails = parseData();
	}

	/**
	 * Reads from given JSON file and returns the data as a JSON Object.
	 * @return the data
	 */
	public JSONObject parseData() {
		JSONParser jsonParser = new JSONParser();
		JSONObject criteriaObject = null;
		try (FileReader reader = new FileReader("criteria.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray requirementList = (JSONArray) obj;
			criteriaObject = (JSONObject) requirementList.get(0);
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return (JSONObject) criteriaObject.get("criteria");
	}

	/**
	 * Returns the desired width of the cabinet.
	 * @param criteria the given user criteria
	 * @return the desired width of the cabinet
	 */
	public static int getRequiredWidth(JSONObject criteria) {
		return Integer.parseInt((String) criteria.get("width"));
	}

	/**
	 * Converts the desired height into size as String and returns the String.
	 * @param criteria the given user criteria
	 * @return the converted desired size
	 */
	public static String convertHeightToSize(JSONObject criteria) {
		int height = Integer.parseInt((String) criteria.get("height"));
		if (height == FULL_HEIGHT) {
			return "wardrobe";
		} else if (height == HALF_SIZE_HEIGHT) {
			return "half";
		} else {
			return "quarter";
		}
	}

	/**
	 * Returns the desired number of shelves.
	 * @param criteria the given user criteria
	 * @return the desired number of shelves
	 */
	public static int getRequiredShelf(JSONObject criteria) {
		return Integer.parseInt((String) criteria.get("shelves"));
	}

	/**
	 * Returns the desired number of drawers.
	 * @param criteria the given user criteria
	 * @return the desired number of drawers
	 */
	public static int getRequiredDrawer(JSONObject criteria) {
		return Integer.parseInt((String) criteria.get("drawers"));
	}

	/**
	 * Returns the preferred color.
	 * @param criteria the given user criteria
	 * @return the preferred color
	 */
	public static String getRequiredColor(JSONObject criteria) {
		return (String) criteria.get("color");
	}

	/**
	 * Returns the desired mount option.
	 * @param criteria the given user criteria
	 * @return the desired mount option
	 */
	public static String getFloorOrWall(JSONObject criteria) {
		return (String) criteria.get("floorOrWall");
	}

	/**
	 * Returns the budget priority.
	 * @param criteria the given user criteria
	 * @return the budget priority
	 */
	public static boolean getBudgetPriority(JSONObject criteria) {
		String budget = (String) criteria.get("budgetPriority");
		return budget.equals("yes");
	}
}
