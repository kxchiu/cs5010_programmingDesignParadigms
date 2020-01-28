import java.util.List;

/**
 * This class represents an abstract furniture class that represents a base furniture with a height,
 * width, and size.
 */
public abstract class AbstractFurniture {
	private final int FULL_HEIGHT = 72;
	private final int HALF_SIZE_HEIGHT = 36;
	private final int QUARTER_SIZE_HEIGHT = 18;
	private final int FULL_WIDTH = 36;
	private int height;
	private int width;
	private String size;
	private List<String> colors;

	/**
	 * Constructs a new abstract furniture object.
	 * @param size the given size
	 */
	public AbstractFurniture(String size) {
		setHeight(size);
		this.size = size;
		this.width = FULL_WIDTH;
	}

	/**
	 * Sets the size of the furniture based on the given size.
	 * @param size
	 */
	private void setHeight(String size) {
		if (size.equals("wardrobe")) {
			this.height = FULL_HEIGHT;
		} else if (size.equals("half")) {
			this.height = HALF_SIZE_HEIGHT;
		} else {
			this.height = QUARTER_SIZE_HEIGHT;
		}
	}

	/**
	 * Returns the height of the furniture.
	 * @return the height
	 */
	private int getHeight() {
		return this.height;
	}

	/**
	 * Returns the width of the furniture.
	 * @return the width
	 */
	private int getWidth() {
		return this.width;
	}

	/**
	 * Returns the size/height of the cabinet.
	 * @return the size/height of the cabinet
	 */
	public String getSize() {
		return this.size;
	}

	/**
	 * Returns the available color options.
	 * @return the available color options
	 */
	public List<String> getColors() {
		return this.colors;
	}
}