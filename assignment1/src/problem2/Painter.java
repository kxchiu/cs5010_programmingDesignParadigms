package problem2;

import java.util.List;

/**
 * This class extends the Artist class and represents a painter with given details--name, age,
 * genre, and awards received.
 * This class leaves room for additional methods for the painter.
 */

public class Painter extends Artist {

  /**
   * Creates a new painter with given details.
   * @param name the name of the painter
   * @param age the age of the painter
   * @param genre the genre of the painter
   * @param awards the awards received by the painter
   */
  public Painter(String name, int age, String genre, List<String> awards) {
    super(name, age, genre, awards);
  }

  //other meaningful methods, if any
}
