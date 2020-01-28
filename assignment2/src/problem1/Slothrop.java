package problem1;

import java.util.Arrays;
import java.util.List;

/**
 * This class extends the AbstractDoor class and represents a Slothrop door with given details--
 * size, color options, and whether it comes with handle.
 */
public class Slothrop extends Door {
  private final List<String> COLOR_OPTIONS = Arrays.asList(new String[]{"Brown", "Black"});
  private List<String> colors;
  private boolean includeHandle;

  /**
   * Constructs a new Slothrop door given the desired size of the cabinet.
   * @param size the desired size of the cabinet
   */
  public Slothrop(String size) {
    super(size);
    this.colors = COLOR_OPTIONS;
    this.includeHandle = true;
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
}
