package assignment2;

import java.util.List;
import java.util.Objects;

/**
 * This class represents the menu of a restaurant given the details--meals, desserts, beverages, and
 * drinks.
 */
public class Menu {
  List<String> meals;
  List<String> desserts;
  List<String> beverages;
  List<String> drinks;

  /**
   * Constructs a new menu given the details.
   * @param meals the meals
   * @param desserts the desserts
   * @param beverages the beverages
   * @param drinks the drinks
   */
  public Menu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this. drinks = drinks;
  }

  /**
   * Sets the meals on the menu.
   * @param meals the meals
   */
  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  /**
   * Sets the desserts on the menu.
   * @param desserts the desserts
   */
  public void setDesserts(List<String> desserts) {
    this.desserts = desserts;
  }

  /**
   * Sets the beverages on the menu.
   * @param beverages the beverages
   */
  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  /**
   * Sets the drinks on the menu.
   * @param drinks the drinks
   */
  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }

  /**
   * Returns the meals.
   * @return the meals
   */
  public List<String> getMeals() {
    return this.meals;
  }

  /**
   * Returns the desserts.
   * @return the desserts
   */
  public List<String> getDesserts() {
    return this.desserts;
  }

  /**
   * Returns the beverages.
   * @return the beverages
   */
  public List<String> getBeverages() {
    return this.beverages;
  }

  /**
   * Returns the drinks.
   * @return the drinks
   */
  public List<String> getDrinks() {
    return this.drinks;
  }

  /**
   * Returns the menu details as String.
   * @return the menu details
   */
  public String toString() {
    String str;
    str = "Meals: " + String.join(", ", this.getMeals()) + "\n"
        + "Desserts: " + String.join(", ", this.getDesserts()) + "\n"
        + "Beverages: " + String.join(", ", this.getBeverages()) + "\n"
        + "Drinks: " + String.join(", ", this.getDrinks());
    return str;
  }

  /**
   * Compares the given object to the menu and returns the result as Boolean.
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
    Menu menu = (Menu) o;
    return Objects.equals(menu.meals, this.meals)
        && Objects.equals(menu.desserts, this.desserts)
        && Objects.equals(menu.beverages, this.beverages)
        && Objects.equals(menu.drinks, this.drinks);
  }

  /**
   * Returns a hash integer of the menu details.
   * @return a hash integer of the menu details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getMeals(), this.getDesserts(), this.getBeverages(), this.getDrinks());
  }
}
