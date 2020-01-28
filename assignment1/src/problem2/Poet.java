package problem2;

import java.util.List;

/**
 * This class extends the Artist class and represents a poet with given details--name, age,
 * genre, and awards received.
 * This class leaves room for additional methods for the poet.
 */

public class Poet extends Artist {

  /**
   * Creates a new poet with given details.
   * @param name the name of the poet
   * @param age the age of the poet
   * @param genre the genre of the poet
   * @param awards the awards received by the poet
   */
  public Poet(String name, int age, String genre, List<String> awards) {
    super(name, age, genre, awards);
  }

  //other meaningful methods, if any
}
