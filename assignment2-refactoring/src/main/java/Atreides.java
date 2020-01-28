import java.util.Arrays;
import java.util.List;

/**
 * This class extends the Cabinet class and represents a Atreides cabinet that sets a number
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
		setMaxShelfNum(size);
	}

	/**
	 * Sets the maximum shelves given the size of the cabinet.
	 * @param size the size of the cabinet
	 */
	public void setMaxShelfNum(String size) {
		if (size.equals("half")) {
			this.maxShelfNum = MAX_SHELF_NUM_HALF;
		} else {
			this.maxShelfNum = MAX_SHELF_NUM_QUARTER;
		}
	}

	/**
	 * Returns the available color options.
	 * @return the available color options
	 */
	public List<String> getColors() {
		return this.colors;
	}
}
