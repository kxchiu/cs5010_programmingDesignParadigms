package problem2;

import java.util.List;

/**
 * This class extends the Artist class and represents a photographer with given details--name, age,
 * genre, and awards received.
 * This class leaves room for additional methods for the photographer.
 */

public class Photographer extends Artist {

  /**
   * Creates a new photographer with given details.
   * @param name the name of the photographer
   * @param age the age of the photographer
   * @param genre the genre of the photographer
   * @param awards the awards received by the photographer
   */
  public Photographer(String name, int age, String genre, List<String> awards) {
    super(name, age, genre, awards);
  }

  //other meaningful methods, if any
}
