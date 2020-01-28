package problem1;

import java.util.Arrays;
import java.util.List;

/**
 * This class extends the AbstractDoor class and represents a Belacqua door with given details--
 * size, color options, and whether it comes with handle.
 */

public class Belacqua extends Door {
  private final List<String> COLOR_OPTIONS = Arrays.asList(new String[]{"Bone", "Oxblood"});
  private List<String> colors;
  private boolean includeHandle;

  /**
   * Constructs a new Belacqua door given the desired size of the cabinet.
   * @param size the desired size of the cabinet
   */
  public Belacqua(String size) {
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
