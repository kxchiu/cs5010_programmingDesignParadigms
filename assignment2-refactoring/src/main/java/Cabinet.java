/**
 * This class represents the idea for a cabinet line with basic representation of product
 * details--height, width, depth, size, floor mount option, wall mount option, and earthquake
 * safety requirement.
 */
public class Cabinet extends AbstractFurniture {
	private final int FULL_DEPTH = 16;
	private final int MAX_SHELF_NUM_WARDROBE = 7;
	private final int MAX_SHELF_NUM_HALF = 3;
	private final int MAX_SHELF_NUM_QUARTER = 3;
	private int depth;
	private boolean floorMountOption;
	private boolean wallMountOption;
	private boolean earthquakeSafety;
	private int maxShelfNum;

	/**
	 * Constructs a cabinet given the size of the requirement.
	 * @param size the size of the cabinet
	 */
	public Cabinet(String size) {
		super(size);
		this.depth = FULL_DEPTH;
		this.earthquakeSafety = setEarthquakeSafety(size);
		this.floorMountOption = setFloorMountOption(size);
		this.wallMountOption = setWallMountOption(size);
		setMaxShelfNum(size);
	}

	/**
	 * Sets floor mount option given the size of the cabinet.
	 * @param size the size/height of the cabinet
	 * @return true if the size if wardrobe
	 */
	private boolean setFloorMountOption(String size) {
		return size.equals("wardrobe");
	}

	/**
	 * Returns the floor mount option availability.
	 * @return the floor mount option availability
	 */
	public boolean getFloorMountOption() {
		return this.floorMountOption;
	}

	/**
	 * Sets the wall mount option given the size of the cabinet.
	 * @param size the size of the cabinet
	 * @return true if the size is other than wardrobe
	 */
	private boolean setWallMountOption(String size) {
		return !size.equals("wardrobe");
	}

	/**
	 * eturns the wall mount option availability.
	 * @return the wall mount option availability
	 */
	public boolean getWallMountOption() {
		return this.wallMountOption;
	}

	/**
	 * Returns the earthquake safety requirement.
	 * @return the earthquake safety requirement
	 */
	public boolean getEarthquakeSafety() {
		return this.earthquakeSafety;
	}

	/**
	 * Sets the earthquake safety requirement based on the size of the cabinet.
	 * @param size the size of the cabinet
	 * @return true if size is wardrobe
	 */
	private boolean setEarthquakeSafety(String size) {
		return size.equals("wardrobe");
	}

	/**
	 * Sets the maximum number of shelves the cabinet can hold.
	 */
	public void setMaxShelfNum(String size) {
		if (size.equals("wardrobe")) {
			this.maxShelfNum = MAX_SHELF_NUM_WARDROBE;
		} else if (size.equals("half")) {
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
	 * Returns the depth of the cabinet.
	 * @return the depth of the cabinet
	 */
	public int getDepth() {
		return this.depth;
	}
}
