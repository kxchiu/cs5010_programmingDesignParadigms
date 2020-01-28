import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 * This class represents a result generator that reads from the given user criteria requirements
 * and writes to a recommendation JSON file.
 */
public class ResultGenerator {
	private final int STANDARD_WIDTH = 36;
	private final String[] CABINET = {"Yossaria", "Luthien", "Atreides"};
	private final String[] DOOR = {"Slothrop", "Belacqua", "Gaga"};
	private final int MIN_FEET_PER_CABINET = 4;
	private final int MIN_CABINET_TO_COMBINE = 3;
	private JSONObject recommendation;
	private int numCabinet;
	private int requiredWidth;
	private String requiredHeight;
	private int requiredShelf;
	private int requiredDrawer;
	private String colorPreference;
	private String floorOrWall;
	private boolean budgetPriority;

	/**
	 * Constructs a new result generator given the requirement details.
	 * @param requiredWidth the required width
	 * @param requiredHeight the required height
	 * @param requiredShelf the required number of shelves
	 * @param requiredDrawer the required number of drawers
	 * @param colorPreference the color preference
	 * @param floorOrWall the floor or wall mount option
	 * @param budgetPriority the budget priority
	 */
	public ResultGenerator(int requiredWidth, String requiredHeight, int requiredShelf,
			int requiredDrawer, String colorPreference, String floorOrWall, boolean budgetPriority) {
		this.requiredWidth = requiredWidth;
		this.requiredHeight = requiredHeight;
		this.requiredShelf = requiredShelf;
		this.requiredDrawer = requiredDrawer;
		this.colorPreference = colorPreference;
		this.floorOrWall = floorOrWall;
		this.budgetPriority = budgetPriority;
		this.recommendation = new JSONObject();
	}

	/**
	 * Computes the various calculation and write to the recommendation list.
	 * @param requiredWidth the desired width of the cabinet
	 * @param requiredHeight the desired height/size of the cabinet
	 * @param requiredShelf the desired number of shelves
	 * @param requiredDrawer the desired number of drawers
	 * @param colorPreference the preferred color
	 * @param floorOrWall the desired mount option
	 * @param budgetPriority the budget priority
	 */
	public void calculates(int requiredWidth, String requiredHeight, int requiredShelf,
			int requiredDrawer, String colorPreference, String floorOrWall, boolean budgetPriority) {
		numCabinet = getNumCabinet(requiredWidth);

		// Creates the cabinet and door objects
		Yossaria yossaria = new Yossaria(requiredHeight);
		Luthien luthien = new Luthien(requiredHeight);
		Atreides atreides = new Atreides(requiredHeight);
		Slothrop slothrop = new Slothrop(requiredHeight);
		Belacqua belacqua = new Belacqua(requiredHeight);
		Gaga gaga = new Gaga(requiredHeight);

		// Calculates details
		calculateCabinet(this.recommendation, numCabinet, yossaria, luthien, atreides);
		calculateDoor(this.recommendation, numCabinet, slothrop, belacqua, gaga);
		calculateFeet(this.recommendation, numCabinet, requiredHeight);
		calculateDrawer(this.recommendation, numCabinet);
		calculateDoorParts(this.recommendation, numCabinet);
		calculateWallFixture(this.recommendation, numCabinet, requiredHeight);
	}

	/**
	 * Writes the recommendation to a JSON file.
	 */
	public void generateResult() {
		// Output result to a JSON file
		System.out.println("\nJSON Object: " + recommendation);
		try (FileWriter file = new FileWriter("\\recommendation.json")) {
			file.write(recommendation.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the number of cabinets needed.
	 * @param requiredWidth the desired width of the cabinet
	 * @return the number of cabinets needed
	 */
	private int getNumCabinet(int requiredWidth) {
		return requiredWidth / STANDARD_WIDTH;
	}

	/**
	 * Helper method to find the recommended cabinet.
	 * @param recommendation the recommendation
	 * @param givenNumCabinet the given number of required cabinets
	 * @param yossaria the Yossaria cabinet
	 * @param luthien the Luthien cabinet
	 * @param atreides the Atreides cabinet
	 */
	private void calculateCabinet(JSONObject recommendation, int givenNumCabinet,
			Yossaria yossaria, Luthien luthien, Atreides atreides) {
		if (requiredHeight.equals("wardrobe")) {
			this.recommendation.put(CABINET[0], givenNumCabinet);
		} else if (checkDrawerMatch()) {
			this.recommendation.put(CABINET[1], givenNumCabinet);
		} else {
			if (checkShelfMatch(atreides, givenNumCabinet)) {
				this.recommendation.put(CABINET[2], givenNumCabinet);
			} else {
				// Update required number of cabinet to meet desired number of shelves
				numCabinet = requiredShelf / atreides.getMaxShelfNum();
				this.recommendation.put(CABINET[2], numCabinet);
			}
		}
	}

	/**
	 * Helper method to find the type and number of doors.
	 * @param recommendation the recommendation list
	 * @param numCabinet the need number of cabinets
	 * @param slothrop the Slothrop door
	 * @param belaqua the Belaqua door
	 * @param gaga the Gaga door
	 */
	private void calculateDoor(JSONObject recommendation, int numCabinet,
			Slothrop slothrop, Belacqua belaqua, Gaga gaga) {
		if (requiredHeight.equals("wardrobe")) {
			findColorOption(recommendation, slothrop, colorPreference);
		} else {
			if (!budgetPriority) {
				recommendation.put(DOOR[2], numCabinet);
			}
		}
	}

	/**
	 * Helper method to find the number of feets needed.
	 * @param recommendation the recommendation list
	 * @param numCabinet the need number of cabinets
	 * @param requiredHeight the desired height/size of the cabinet
	 */
	private void calculateFeet(JSONObject recommendation, int numCabinet,
			String requiredHeight) {
		int totalFeet = numCabinet * MIN_FEET_PER_CABINET;
		if (recommendation.containsKey(CABINET[0]) && requiredHeight.equals("wardrobe")) {
			totalFeet = 0;
		} else if (numCabinet / MIN_CABINET_TO_COMBINE >= 1) {
			totalFeet -= (numCabinet / MIN_FEET_PER_CABINET) * 2;
		}
		recommendation.put("Feet", totalFeet);
	}

	/**
	 * Helper method to find the number of drawers needed.
	 * @param recommendation the recommendation list
	 * @param numCabinet the needed number of cabinets
	 */
	private void calculateDrawer(JSONObject recommendation, int numCabinet) {
		if (recommendation.containsKey(CABINET[1])) {
			recommendation.put("18 in. Drawer", numCabinet);
		} else {
			recommendation.put("18 in. Drawer", 0);
		}
	}

	/**
	 * Helper method to find the number of other door parts needed.
	 * @param recommendation the recommendation list
	 * @param numCabinet the needed number of cabinets
	 */
	private void calculateDoorParts(JSONObject recommendation, int numCabinet) {
		if (recommendation.containsKey(CABINET[2])) {
			recommendation.put("Door Handle", numCabinet);
		} else {
			recommendation.put("Door Handle", 0);
		}
		recommendation.put("Door Hinge", numCabinet * 2);
	}

	/**
	 * Helper method to find the number of wall fixture needed.
	 * @param recommendation the recommendation list
	 * @param numCabinet the need number of cabinets
	 * @param requiredHeight the desired height/size of the cabinet
	 */
	private void calculateWallFixture(JSONObject recommendation, int numCabinet,
			String requiredHeight) {
		if (recommendation.containsKey(CABINET[0]) && requiredHeight.equals("wardrobe")) {
			recommendation.put("Wall Fixture", numCabinet);
		} else {
			recommendation.put("Wall Fixture", 0);
		}
	}

	/**
	 * Checks if the desired number of drawer is more than zero.
	 * @return if the desired number of drawer is more than zero
	 */
	private boolean checkDrawerMatch() {
		return requiredDrawer > 0;
	}

	/**
	 * Checks if the recommended number of cabinets can match the desired number of shelves.
	 * @param cabinet the recommended cabinet
	 * @param numCabinet the needed number of cabinets
	 * @return if the recommended cabinet can meet the desired number of shelves
	 */
	private boolean checkShelfMatch(Cabinet cabinet, int numCabinet) {
		return cabinet.getMaxShelfNum() * numCabinet >= requiredShelf;
	}

	/**
	 * Finds the color option of the door.
	 * @param recommendation the recommendation list
	 * @param door the door product
	 * @param colorPreference the preferred color
	 */
	private void findColorOption(JSONObject recommendation, Door door,
			String colorPreference) {
		if (checkColorMatch(door, colorPreference)) {
			recommendation.put(DOOR[0], numCabinet);
		} else {
			recommendation.put(DOOR[1], numCabinet);
		}
	}

	/**
	 * Returns if the door match the user's preferred color.
	 * @param door the door product
	 * @param colorPreference the preferred color
	 * @return if the door match the user's preferred color
	 */
	private boolean checkColorMatch(Door door, String colorPreference) {
		return door.getColors().contains(colorPreference);
	}
}
