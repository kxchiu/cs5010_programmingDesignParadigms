package assignment2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Restaurant class.
 */
public class RestaurantTest {
  private Restaurant testRestaurant;
  private Restaurant tempRestaurant;
  private String name;
  private Address address;
  private Menu menu;
  private boolean openOrClosed;

  @Before
  public void setUp() throws Exception {
    name = "testRestaurant";
    address = new Address("4510 University Way", "Seattle", "98105", "WA", "USA");
    List<String> meals = Arrays.asList("Burger", "Good Burger", "Better Burger");
    List<String> desserts = Arrays.asList("Dessert", "Good Dessert");
    List<String> beverages = Arrays.asList("Beverage", "Better Beverage", "Best Beverage");
    List<String> drinks = Arrays.asList("Only Drink");
    menu = new Menu(meals, desserts, beverages, drinks);
    testRestaurant = new Restaurant(name, address, menu, true);
    tempRestaurant = new Restaurant(name, address, menu, true);
  }

  @Test
  public void setName() {
    String newName = "TestSetName";
    this.testRestaurant.setName(newName);
    Assert.assertEquals("TestSetName", this.testRestaurant.getName());
  }

  @Test
  public void setAddress() {
    Address newAddress= new Address("4444 Brooklyn Ave", "Seattle", "98105", "WA", "USA");
    this.testRestaurant.setAddress(newAddress);
    Assert.assertEquals(newAddress, this.testRestaurant.getAddress());
  }

  @Test
  public void setMenu() {
    List<String> meals = Arrays.asList("Good Burger", "Better Burger", "Best Burger");
    List<String> desserts = Arrays.asList("Good Dessert");
    List<String> beverages = Arrays.asList("Better Beverage", "Best Beverage");
    List<String> drinks = Arrays.asList("Not Only Drink", "Another Drink");
    Menu newMenu = new Menu(meals, desserts, beverages, drinks);
    this.testRestaurant.setMenu(newMenu);
    Assert.assertEquals(newMenu, this.testRestaurant.getMenu());
  }

  @Test
  public void setOpenOrClosed() {
    this.testRestaurant.setOpenOrClosed(false);
    Assert.assertEquals(false, this.testRestaurant.getOpenOrClosed());
  }

  @Test
  public void testToString() {
    String str;
    str = "Name: testRestaurant\n"
        + "Address:\n" + this.testRestaurant.getAddress().toString() + "\n"
        + "Menu:\n" + this.testRestaurant.getMenu().toString() + "\n"
        + "Open/Closed: Open";
    Assert.assertEquals(str, this.testRestaurant.toString());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.testRestaurant.equals(tempRestaurant));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(tempRestaurant.getName(), tempRestaurant.getAddress(),
        tempRestaurant.getMenu(), tempRestaurant.getOpenOrClosed());
    Assert.assertEquals(hash, this.testRestaurant.hashCode());
  }
}