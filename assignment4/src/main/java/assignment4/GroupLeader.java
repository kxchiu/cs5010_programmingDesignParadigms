package assignment4;

import java.util.Objects;

/**
 * This class represents a group leader object that saves the leader name.
 */
public class GroupLeader {
	private String name;

	/**
	 * Constructs a new leader.
	 * @param name the name of the leader
	 */
	public GroupLeader(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the group leader.
	 * @return the name of the group leader
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Compares an object to the group leader and returns result as Boolean.
	 * @param o the passed-in object
	 * @return the comparison result
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GroupLeader that = (GroupLeader) o;
		return name.equals(that.name);
	}

	/**
	 * Returns a hashcode of the group leader object.
	 * @return a hashcode of the group leader
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * Returns the name detail of the group leader as String.
	 * @return the name detail of the group leader
	 */
	@Override
	public String toString() {
		return "GroupLeader{" +
				"name='" + name + '\'' +
				'}';
	}
}
