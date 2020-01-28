package problem2;

import java.util.List;

/**
 * This class extends the Artist class and represents a musician with given details--name, age,
 * genre, and awards received.
 * This class leaves room for additional methods for the musician.
 */

public class Musician extends Artist {

  /**
   * Creates a new musician with given details.
   * @param name the name of the musician
   * @param age the age of the musician
   * @param genre the genre of the musician
   * @param awards the awards received by the musician
   */
  public Musician(String name, int age, String genre, List<String> awards) {
    super(name, age, genre, awards);
  }

  //other meaningful methods, if any
}
