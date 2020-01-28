/**
 * This class represents a door product line with details--height, width, size.
 */
public class Door extends AbstractFurniture{
	private boolean includeHandle;

	/**
	 * Constructs a door given the desired size.
	 * @param size the desired size
	 */
	public Door(String size) {
		super(size);
		this.includeHandle = true;
	}

	/**
	 * Returns if the door includes handle.
	 * @return if the door includes handle
	 */
	public boolean getIncludeHandle() {
		return this.includeHandle;
	}
}
