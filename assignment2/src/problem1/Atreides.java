package problem1;

import java.util.Arrays;
import java.util.List;

/**
 * This class extends the AbstractCabinet class and represents a Atreides cabinet that sets a number
 * of details--size, color options, and maximum number of shelves.
 */

public class Atreides extends Cabinet {
  private final List<String> COLOR_OPTIONS = Arrays.asList("Brown", "Bone");
  private final int MAX_SHELF_NUM_HALF = 3;
  private final int MAX_SHELF_NUM_QUARTER = 1;
  private List<String> colors;
  private int maxShelfNum;

  /**
   * Constructs a new Atreides cabinet given the desired size.
   * @param size the desired size of the cabinet
   */
  public Atreides(String size) {
    super(size);
    this.colors = COLOR_OPTIONS;
    this.maxShelfNum = setMaxShelfNum(size);
  }

  /**
   * Sets the maximum shelves given the size of the cabinet.
   * @param size the size of the cabinet
   */
  public int setMaxShelfNum(String size) {
    if (size.equals("half")) {
      return MAX_SHELF_NUM_HALF;
    } else {
      return MAX_SHELF_NUM_QUARTER;
    }
  }

  /**
   * Returns the maximum number of shelves the cabinet can hold.
   * @return the maximum number of shelves
   */
  public int getMaxShelfNum() {
    return this.maxShelfNum;
  }

  /**
   * Returns the available color options.
   * @return the available color options
   */
  public List<String> getColors() {
    return this.colors;
  }
}
