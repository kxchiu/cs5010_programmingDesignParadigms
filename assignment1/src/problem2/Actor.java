package problem2;

import java.util.List;

/**
 * This class extends the MediaArtist class and represents an actor with given details--name, age,
 * genre, awards received, and lists of movies, TV series and other multimedia work the actor is
 * involved in.
 * This class leaves room for additional methods for the actor.
 */

public class Actor extends MediaArtist {

  /**
   * Creates a new actor with given details.
   * @param name the name of the actor
   * @param age the age of the actor
   * @param genre the genre of the actor
   * @param awards the awards received by the actor
   * @param movies the movies the actor was involved with
   * @param series the TV series the actor was involved with
   * @param others the other multimedia work the actor was involved with
   */
  public Actor(String name, int age, String genre, List<String> awards, List<String> movies,
      List<String> series, List<String> others) {
    super(name, age, genre, awards, movies, series, others);
  }

  //other meaningful methods, if any
}
