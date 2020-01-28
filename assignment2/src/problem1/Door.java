package problem1;

import java.util.List;

/**
 * This class represents a abstract idea for a door product line with details--height, width, size.
 */
public class Door {
  private final int FULL_HEIGHT = 72;
  private final int HALF_SIZE_HEIGHT = 36;
  private final int QUARTER_SIZE_HEIGHT = 18;
  private final int FULL_WIDTH = 36;
  private int height;
  private int width;
  private String size;
  private List<String> colors;
  private boolean includeHandle;

  /**
   * Constructs an abstract door given the desired size.
   * @param size the desired size
   */
  public Door(String size) {
    this.width = FULL_WIDTH;
    this.size = size;
    setHeight(size);
    this.includeHandle = true;
  }

  /**
   * Sets the height to the corresponding height based on the size of the cabinet.
   * @param size the size of the door
   */
  private void setHeight(String size) {
    if (size.equals("half")) {
      this.height = HALF_SIZE_HEIGHT;
    } else if (size.equals("quarter")) {
      this.height = QUARTER_SIZE_HEIGHT;
    }
  }

  /**
   * Returns the size of the door.
   * @return the size of the door
   */
  public String getSize() {
    return this.size;
  }


  /**
   * Returns if the door includes handle.
   * @return if the door includes handle
   */
  public boolean getIncludeHandle() {
    return this.includeHandle;
  }

  /**
   * Returns the available color options.
   * @return the available color options
   */
  public List<String> getColors() {
    return this.colors;
  }

  /**
   * Returns the width of the door.
   * @return the width of the door
   */
  public int getWidth() {
    return this.width;
  }
}
