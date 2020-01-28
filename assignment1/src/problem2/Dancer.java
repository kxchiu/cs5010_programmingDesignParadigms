package problem2;

import java.util.List;

/**
 * This class extends the MediaArtist class and represents a dancer with given details--name, age,
 * genre, awards received, and lists of movies, TV series and other multimedia work the dancer is
 * involved in.
 * This class leaves room for additional methods for the dancer.
 */

public class Dancer extends MediaArtist {

  /**
   * Creates a new dancer with given details.
   * @param name the name of the dancer
   * @param age the age of the dancer
   * @param genre the genre of the dancer
   * @param awards the awards received by the dancer
   * @param movies the movies the dancer was involved with
   * @param series the TV series the dancer was involved with
   * @param others the other multimedia work the dancer was involved with
   */
  public Dancer(String name, int age, String genre, List<String> awards, List<String> movies,
      List<String> series, List<String> others) {
    super(name, age, genre, awards, movies, series, others);
  }

  //other meaningful methods, if any
}
