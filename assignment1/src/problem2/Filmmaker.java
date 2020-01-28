package problem2;

import java.util.List;

/**
 * This class extends the MediaArtist class and represents a filmmaker with given details--name,
 * age, genre, awards received, and lists of movies, TV series and other multimedia work the
 * filmmaker is involved in.
 * This class leaves room for additional methods for the filmmaker.
 */

public class Filmmaker extends MediaArtist {

  /**
   * Creates a new filmmaker with given details.
   * @param name the name of the filmmaker
   * @param age the age of the filmmaker
   * @param genre the genre of the filmmaker
   * @param awards the awards received by the filmmaker
   * @param movies the movies the filmmaker was involved with
   * @param series the TV series the filmmaker was involved with
   * @param others the other multimedia work the filmmaker was involved with
   */
  public Filmmaker(String name, int age, String genre, List<String> awards, List<String> movies,
      List<String> series, List<String> others) {
    super(name, age, genre, awards, movies, series, others);
  }

  //other meaningful methods, if any
}
