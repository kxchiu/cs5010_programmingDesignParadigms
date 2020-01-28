package problem1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class represents a furniture recommendation calculator that roughly finds some combination
 * based on the given user criteria--desired width, height, number of shelves and drawers, colors,
 * floor vs. wall mount, and budget.
 */
public class FurnitureCalculator {
  private static final int FULL_HEIGHT = 72;
  private static final int HALF_SIZE_HEIGHT = 36;
  private static final int QUARTER_SIZE_HEIGHT = 18;
  private static final int STANDARD_WIDTH = 36;
  private static final String[] CABINET = {"Yossaria", "Luthien", "Atreides"};
  private static final String[] DOOR = {"Slothrop", "Belacqua", "Gaga"};
  private static final int MIN_FEET_PER_CABINET = 4;
  private static final int MIN_CABINET_TO_COMBINE = 3;
  private static int requiredWidth;
  private static String requiredHeight;
  private static int requiredShelf;
  private static int requiredDrawer;
  private static String colorPreference;
  private static String floorOrWall;
  private static boolean budgetPriority;
  private static int numCabinet;

  /**
   * The main method that reads the given JSON criteria file and outputs a JSON recoomendation file.
   * @param args the args of the main method
   */
  public static void main(String[] args) {
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader("C:\\Users\\Kevin\\WorkSpace\\CS5010\\"
        + "Student_repo_Chen_wei_Chiu\\assignment2\\src\\problem1\\criteria.json")) {
      // Read JSON file
      Object obj = jsonParser.parse(reader);

      JSONArray requirementList = (JSONArray) obj;
      JSONObject criteriaObject = (JSONObject) requirementList.get(0);
      JSONObject criteriaDetails = (JSONObject) criteriaObject.get("criteria");

      // Finds user criteria
      requiredWidth = getRequiredWidth(criteriaDetails);
      requiredHeight = convertHeightToSize(criteriaDetails);
      requiredShelf = getRequiredShelf(criteriaDetails);
      requiredDrawer = getRequiredDrawer(criteriaDetails);
      colorPreference = getRequiredColor(criteriaDetails);
      floorOrWall = getFloorOrWall(criteriaDetails);
      budgetPriority = getBudgetPriority(criteriaDetails);

      // Calculates recommendation
      JSONObject recommendation = new JSONObject();
      calculates(requiredWidth, requiredHeight, requiredShelf, requiredDrawer, colorPreference,
          floorOrWall, budgetPriority, recommendation);

      // Output result to a JSON file
      System.out.println("\nJSON Object: " + recommendation);
      try (FileWriter file = new FileWriter("C:\\Users\\Kevin\\WorkSpace\\CS5010\\"
          + "Student_repo_Chen_wei_Chiu\\assignment2\\src\\problem1\\recommendation.json")) {
        file.write(recommendation.toJSONString());
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the desired width of the cabinet.
   * @param criteria the given user criteria
   * @return the desired width of the cabinet
   */
  private static int getRequiredWidth(JSONObject criteria) {
    return Integer.parseInt((String) criteria.get("width"));
  }

  /**
   * Converts the desired height into size as String and returns the String.
   * @param criteria the given user criteria
   * @return the converted desired size
   */
  private static String convertHeightToSize(JSONObject criteria) {
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
  private static int getRequiredShelf(JSONObject criteria) {
    return Integer.parseInt((String) criteria.get("shelves"));
  }

  /**
   * Returns the desired number of drawers.
   * @param criteria the given user criteria
   * @return the desired number of drawers
   */
  private static int getRequiredDrawer(JSONObject criteria) {
    return Integer.parseInt((String) criteria.get("drawers"));
  }

  /**
   * Returns the preferred color.
   * @param criteria the given user criteria
   * @return the preferred color
   */
  private static String getRequiredColor(JSONObject criteria) {
    return (String) criteria.get("color");
  }

  /**
   * Returns the desired mount option.
   * @param criteria the given user criteria
   * @return the desired mount option
   */
  private static String getFloorOrWall(JSONObject criteria) {
    return (String) criteria.get("floorOrWall");
  }

  /**
   * Returns the budget priority.
   * @param criteria the given user criteria
   * @return the budget priority
   */
  private static boolean getBudgetPriority(JSONObject criteria) {
    String budget = (String) criteria.get("budgetPriority");
    return budget.equals("yes");
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
  private static void calculates(int requiredWidth, String requiredHeight, int requiredShelf,
      int requiredDrawer, String colorPreference, String floorOrWall, boolean budgetPriority,
      JSONObject recommendation) {
    numCabinet = getNumCabinet(requiredWidth);

    // Creates the cabinet and door objects
    Yossaria yossaria = new Yossaria(requiredHeight);
    Luthien luthien = new Luthien(requiredHeight);
    Atreides atreides = new Atreides(requiredHeight);
    Slothrop slothrop = new Slothrop(requiredHeight);
    Belacqua belacqua = new Belacqua(requiredHeight);
    Gaga gaga = new Gaga(requiredHeight);

    // Calculates details
    calculateCabinet(recommendation, numCabinet, yossaria, luthien, atreides);
    calculateDoor(recommendation, numCabinet, slothrop, belacqua, gaga);
    calculateFeet(recommendation, numCabinet, requiredHeight);
    calculateDrawer(recommendation, numCabinet);
    calculateDoorParts(recommendation, numCabinet);
    calculateWallFixture(recommendation, numCabinet, requiredHeight);
  }

  /**
   * Returns the number of cabinets needed.
   * @param requiredWidth the desired width of the cabinet
   * @return the number of cabinets needed
   */
  private static int getNumCabinet(int requiredWidth) {
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
  private static void calculateCabinet(JSONObject recommendation, int givenNumCabinet,
      Yossaria yossaria, Luthien luthien, Atreides atreides) {
    if (requiredHeight.equals("wardrobe")) {
      recommendation.put(CABINET[0], givenNumCabinet);
    } else if (checkDrawerMatch()) {
      recommendation.put(CABINET[1], givenNumCabinet);
    } else {
      if (checkShelfMatch(atreides, givenNumCabinet)) {
        recommendation.put(CABINET[2], givenNumCabinet);
      } else {
        // Update required number of cabinet to meet desired number of shelves
        numCabinet = requiredShelf / atreides.getMaxShelfNum();
        recommendation.put(CABINET[2], numCabinet);
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
  private static void calculateDoor(JSONObject recommendation, int numCabinet,
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
  private static void calculateFeet(JSONObject recommendation, int numCabinet,
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
  private static void calculateDrawer(JSONObject recommendation, int numCabinet) {
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
  private static void calculateDoorParts(JSONObject recommendation, int numCabinet) {
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
  private static void calculateWallFixture(JSONObject recommendation, int numCabinet,
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
  private static boolean checkDrawerMatch() {
    return requiredDrawer > 0;
  }

  /**
   * Checks if the recommended number of cabinets can match the desired number of shelves.
   * @param cabinet the recommended cabinet
   * @param numCabinet the needed number of cabinets
   * @return if the recommended cabinet can meet the desired number of shelves
   */
  private static boolean checkShelfMatch(Cabinet cabinet, int numCabinet) {
    return cabinet.getMaxShelfNum() * numCabinet >= requiredShelf;
  }

  /**
   * Finds the color option of the door.
   * @param recommendation the recommendation list
   * @param door the door product
   * @param colorPreference the preferred color
   */
  private static void findColorOption(JSONObject recommendation, Door door,
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
  private static boolean checkColorMatch(Door door, String colorPreference) {
    return door.getColors().contains(colorPreference);
  }
}
