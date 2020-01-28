package problem2;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a general artist with given details--name, age, genre, and list of awards.
 */
public class Artist {
  private String name;
  private Integer age;
  private String genre;
  private List<String> awards;

  /**
   * Creates a new artist with the given name, age, genre, awards.
   * @param name the name of the artist
   * @param age the age of the artist
   * @param genre the genre of the artist
   * @param awards the awards received by the artist
   */
  public Artist(String name, int age, String genre, List<String> awards) {
    this.name = name;
    this.age = age;
    this.genre = genre;
    this.awards = awards;
  }

  /**
   * Returns the name of the artist.
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the age of the artist.
   * @return the age
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Returns the genre of the artist.
   * @return the genre
   */
  public String getGenre() {
    return this.genre;
  }

  /**
   * Returns the awards received by the artist.
   * @return the awards
   */
  public List<String> getAwards() {
    return this.awards;
  }

  /**
   * Returns the artist's name, age, genre, and award received as a String.
   * @return the artist's name, age, genre, awards received
   */
  public String toString() {
    String str;
    str = "Name: " + this.name + "\n"
        + "Age: " + this.age + "\n"
        + "Genre: " + this.genre + "\n"
        + "Awards: " + this.awards;
    return str;
  }

  /**
   * Compares the information of the given object to the artist.
   * @param o the object being compared
   * @return the comparison result in boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artist artist = (Artist) o;
    return Objects.equals(name, artist.name)
        && Float.compare(artist.age, age) == 0
        && Objects.equals(genre, artist.genre)
        && Objects.equals(awards, artist.awards);
  }

  /**
   * Returns a hashcode of the artist's name, age, genre, and awards received.
   * @return the hashcode of the artist's details
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, genre, awards);
  }
}
