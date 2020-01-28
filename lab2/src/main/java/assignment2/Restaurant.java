package assignment2;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a restaurant given the details--restaurant's name, address information,
 * menu, and open/closed status.
 */
public class Restaurant {
  private String name;
  private Address address;
  private Menu menu;
  private boolean openOrClosed;

  /**
   * Constructs a new restaurants given the details--name, address, menu, and open/closed status.
   * @param name name of the restaurant
   * @param address address information of the restaurant
   * @param menu menu of the restaurant
   * @param openOrClosed open/closed status of the restaurant
   */
  public Restaurant(String name, Address address, Menu menu, boolean openOrClosed) {
    this.name = name;
    this.address = address;
    this.menu = menu;
    this.openOrClosed = openOrClosed;
  }

  /**
   * Constructs a new restaurants given the details--name, address details, menu details, and open/
   * closed status.
   * @param name name of the restaurant
   * @param streetAndNum street and number of the restaurant
   * @param city city where the restaurant is located
   * @param zip zip code
   * @param state state where the restaurant is located
   * @param country country where the restaurant is located
   * @param meals meals offered by the restaurant
   * @param desserts desserts offered by the restaurant
   * @param beverages beverages offered by the restaurant
   * @param drinks drinks offered by the restaurant
   * @param openOrClosed open/closed status of the restaurant
   */
  public Restaurant(String name, String streetAndNum, String city, String zip, String state,
      String country, List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks, boolean openOrClosed) {
    this.name = name;
    this.address = new Address(streetAndNum, city, zip, state, country);
    this.menu = new Menu(meals, desserts, beverages, drinks);
    this.openOrClosed = openOrClosed;
  }

  /**
   * Sets the name of the restaurant.
   * @param name name of the restaurant
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the address of the restaurant.
   * @param address address of the restaurant
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Sets the address of the restaurant given the address details.
   * @param streetAndNum the street and number of the restaurant
   * @param city the city where the restaurant is located
   * @param zip zip code
   * @param state the state where the restaurant is located
   * @param country the country where the restaurant is located
   */
  public void setAddress(String streetAndNum, String city, String zip, String state,
      String country) {
    this.address = new Address(streetAndNum, city, zip, state, country);
  }

  /**
   * Sets the menu of the restaurant.
   * @param menu menu of the restaurant
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * Sets the menu of the restaurant given the menu details.
   * @param meals the meals offered by the restaurant
   * @param desserts the desserts offered by the restaurant
   * @param beverages the beverages offered by the restaurant
   * @param drinks the drinks offered by the restaurant
   */
  public void setMenu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {
    this.menu = new Menu(meals, desserts, beverages, drinks);
  }

  /**
   * Sets the open/closed status of the restaurant.
   * @param openOrClosed the open/closed status of the restaurant
   */
  public void setOpenOrClosed(boolean openOrClosed) {
    this.openOrClosed = openOrClosed;
  }

  /**
   * Returns the name of the restaurant as String.
   * @return the name of the restaurant
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the address of the restaurant.
   * @return the address of the restaurant
   */
  public Address getAddress() {
    return this.address;
  }

  /**
   * Returns the menu of the restaurant.
   * @return the menu of the restaurant
   */
  public Menu getMenu() {
    return this.menu;
  }

  /**
   * Returns the open/closed status of the restaurant.
   * @return the open/closed status of the restaurant
   */
  public boolean getOpenOrClosed() {
    return this.openOrClosed;
  }

  /**
   * Returns the restaurant details as String.
   * @return the restaurant details
   */
  public String toString() {
    String str;
    str = "Name: " + this.getName() + "\n"
        + "Address:\n" + this.getAddress().toString() + "\n"
        + "Menu:\n" + this.getMenu().toString() + "\n"
        + "Open/Closed: ";
    if (this.getOpenOrClosed()) {
      str += "Open";
    } else {
      str += "Closed";
    }
    return str;
  }

  /**
   * Compares the given object to the restaurant and returns the result as Boolean.
   * @param o the given object
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
    Restaurant restaurant = (Restaurant) o;
    return Objects.equals(restaurant.name, this.name)
        && Objects.equals(restaurant.address, this.address)
        && Objects.equals(restaurant.menu, this.menu)
        && Objects.equals(restaurant.openOrClosed, this.openOrClosed);
  }

  /**
   * Returns a hash integer of the restaurant details.
   * @return a hash integer of the restaurant details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.getAddress(), this.getMenu(), this.getOpenOrClosed());
  }
}
