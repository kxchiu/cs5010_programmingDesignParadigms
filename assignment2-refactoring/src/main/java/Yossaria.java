import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class extends the AbstractCabinet class and represents a Yossaria cabinet that sets a number
 * of details--size, color options, and maximum number of shelves.
 */
public class Yossaria extends Cabinet {
	private final int MAX_SHELF_NUM_QUARTER = 3;
	private List<String> colors;
	private int maxShelfNum;

	/**
	 * Constructs a new Yossaria cabinet given the desired size.
	 * @param size the desired size of the cabinet
	 */
	public Yossaria(String size) {
		super(size);
		this.colors = new ArrayList<String>();
		setColors(size);
		setMaxShelfNum(size);
	}

	/**
	 * Adds the color Oxblood when the cabinet size is wardrobe.
	 * @param size the size of the cabinet
	 */
	public void setColors(String size) {
		this.colors.addAll(Arrays.asList("Brown", "Black", "Bone"));
		if (size.equals("wardrobe")) {
			this.colors.add("Oxblood");
		}
	}

	/**
	 * Sets the maximum shelves given the size of the cabinet.
	 * @param size the size of the cabinet
	 */
	public void setMaxShelfNum(String size) {
		if (size.equals("quarter")) {
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
	 * Returns the available color options.
	 * @return the available color options
	 */
	public List<String> getColors() {
		return this.colors;
	}
}
