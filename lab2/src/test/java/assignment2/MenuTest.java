package assignment2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Menu class.
 */
public class MenuTest {
  private Menu menu;
  private Menu tempMenu;
  List<String> meals;
  List<String> desserts;
  List<String> beverages;
  List<String> drinks;

  @Before
  public void setUp() throws Exception {
    List<String> meals = Arrays.asList("Burger", "Good Burger", "Better Burger");
    List<String> desserts = Arrays.asList("Dessert", "Good Dessert");
    List<String> beverages = Arrays.asList("Beverage", "Better Beverage", "Best Beverage");
    List<String> drinks = Arrays.asList("Only Drink");
    menu = new Menu(meals, desserts, beverages, drinks);
    tempMenu = new Menu(meals, desserts, beverages, drinks);
  }

  @Test
  public void setMeals() {
    List<String> newMeals = Arrays.asList("Burger", "Good Burger");
    this.menu.setMeals(newMeals);
    Assert.assertEquals(newMeals, this.menu.getMeals());
  }

  @Test
  public void setDesserts() {
    List<String> newDesserts = Arrays.asList("Dessert", "Good Dessert", "Better Dessert");
    this.menu.setDesserts(newDesserts);
    Assert.assertEquals(newDesserts, this.menu.getDesserts());
  }

  @Test
  public void setBeverages() {
    List<String> newBeverages = Arrays.asList("Best Beverage");
    this.menu.setBeverages(newBeverages);
    Assert.assertEquals(newBeverages, this.menu.getBeverages());
  }

  @Test
  public void setDrinks() {
    List<String> newDrinks = Arrays.asList("Not Only Drink", "But Also Drink");
    this.menu.setDrinks(newDrinks);
    Assert.assertEquals(newDrinks, this.menu.getDrinks());
  }

  @Test
  public void testToString() {
    String str;
    str = "Meals: Burger, Good Burger, Better Burger\n"
        + "Desserts: Dessert, Good Dessert\n"
        + "Beverages: Beverage, Better Beverage, Best Beverage\n"
        + "Drinks: Only Drink";
    Assert.assertEquals(str, this.menu.toString());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.menu.equals(tempMenu));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(tempMenu.getMeals(), tempMenu.getDesserts(), tempMenu.getBeverages(),
        tempMenu.getDrinks());
    Assert.assertEquals(hash, this.menu.hashCode());
  }
}