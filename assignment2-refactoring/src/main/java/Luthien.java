import java.util.Arrays;
import java.util.List;

/**
 * This class extends the Cabinet class and represents a Luthien cabinet that sets a number
 * of details--size, color options, and maximum number of shelves.
 */
public class Luthien extends Cabinet {
	private final List<String> COLOR_OPTIONS = Arrays.asList("Black", "Bone");
	private final int MAX_SHELF_NUM_HALF = 3;
	private final int MAX_SHELF_NUM_QUARTER = 1;
	private final int MAX_DRAWER_NUM = 1;
	private final int LUTHIEN_DEPTH = 18;
	private List<String> colors;
	private int depth;
	private int maxShelfNum;
	private int maxDrawerNum;

	/**
	 * Constructs a new Luthien cabinet given the desired size.
	 * @param size the desired size of the cabinet
	 */
	public Luthien(String size) {
		super(size);
		this.colors = COLOR_OPTIONS;
		this.depth = LUTHIEN_DEPTH;
		setMaxShelfNum(size);
		setMaxDrawerNum(size);
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
	 * Returns the maximum number of shelves the cabinet can hold.
	 * @return the maximum number of shelves
	 */
	public int getMaxShelfNum() {
		return this.maxShelfNum;
	}

	/**
	 * Sets the maximum drawer given the size of the cabinet.
	 * @param size the size of the cabinet
	 */
	public void setMaxDrawerNum(String size) {
		this.maxDrawerNum = MAX_DRAWER_NUM;
	}

	/**
	 * Returns the maximum number of drawers the cabinet can hold.
	 * @return the maximum number of drawers
	 */
	public int getMaxDrawerNum() {
		return this.maxDrawerNum;
	}

	/**
	 * Returns the available color options.
	 * @return the available color options
	 */
	public List<String> getColors() {
		return this.colors;
	}
}
