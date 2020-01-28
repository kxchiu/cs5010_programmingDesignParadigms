import org.json.simple.JSONObject;

/**
 * This class represents the main that keeps track of the requirements, tells the criteria parser
 * to read data, and directs the result generator to generate a recommendation result from the user
 * requirements.
 */
public class Main {
	private static CriteriaParser criteriaParser;
	private static JSONObject criteriaDetails;
	private static ResultGenerator resultGenerator;
	private static int requiredWidth;
	private static String requiredHeight;
	private static int requiredShelf;
	private static int requiredDrawer;
	private static String colorPreference;
	private static String floorOrWall;
	private static boolean budgetPriority;
	private static int numCabinet;

	/**
	 * The main method that instructs the criteria parser to read the given JSON criteria file and
	 * the result generator to output a JSON recommendation file.
	 * @param args the args of the main method
	 */
	public static void main(String[] args) {
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
		resultGenerator.calculates(requiredWidth, requiredHeight, requiredShelf,
				requiredDrawer, colorPreference, floorOrWall, budgetPriority);
		resultGenerator.generateResult();
	}
}
