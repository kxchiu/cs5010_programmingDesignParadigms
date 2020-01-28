package problem2;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a media artist, which include actor, dancer, and filmmaker, with additional
 * given details--lists of movies, series, and other multimedia work the artist was involved with.
 */
public class MediaArtist extends Artist {
  private List<String> movies;
  private List<String> series;
  private List<String> others;

  /**
   * Creates a new media artist given the name, age, genre, and awards.
   * @param name the name of the artist
   * @param age the age of the artist
   * @param genre the genre of the artist
   * @param awards the awards received by the artist
   */
  public MediaArtist(String name, int age, String genre, List<String> awards) {
    super(name, age, genre, awards);
  }

  /**
   * Creates a new media artist given the additional details of the movies, TV series, and other
   * multimedia work that the artist is involved with.
   * @param name the name of the artist
   * @param age the age of the artist
   * @param genre the genre of the artist
   * @param awards the awards received by the artist
   * @param movies the movies the artist worked on
   * @param series the TV series the artist worked on
   * @param others the other multimedia work the artist worked on
   */
  public MediaArtist(String name, int age, String genre, List<String> awards, List<String> movies,
      List<String> series, List<String> others) {
    super(name, age, genre, awards);
    this.movies = movies;
    this.series = series;
    this.others = others;
  }

  /**
   * Returns the list of movies the artist was involved in.
   * @return the movies
   */
  public List<String> getMovies() {
    return this.movies;
  }

  /**
   * Returns the list of TV series the artist was involved in.
   * @return the series
   */
  public List<String> getSeries() {
    return this.series;
  }

  /**
   * Returns the list of other multimedia work the artist was involved in.
   * @return the others
   */
  public List<String> getOthers() {
    return this.others;
  }

  /**
   * Returns the artist's details as a String.
   * @return the artist's name, age, genre, awards, movies, series, and others
   */
  public String toString() {
    String str;
    str = "Name: " + this.getName() + "\n"
        + "Age: " + this.getAge() + "\n"
        + "Genre: " + this.getGenre() + "\n"
        + "Awards: " + this.getAwards() + "\n"
        + "Movies: " + this.movies + "\n"
        + "TV Series: " + this.series + "\n"
        + "Other Work: " + this.others    ;
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
    MediaArtist mediaArtist = (MediaArtist) o;
    return Objects.equals(this.getName(), mediaArtist.getName())
        && Float.compare(mediaArtist.getAge(), this.getAge()) == 0
        && Objects.equals(this.getGenre(), mediaArtist.getGenre())
        && Objects.equals(this.getAwards(), mediaArtist.getAwards())
        && Objects.equals(movies, mediaArtist.movies)
        && Objects.equals(series, mediaArtist.series)
        && Objects.equals(others, mediaArtist.others);
  }

  /**
   * Returns a hashcode of the artist's name, age, genre, and awards received.
   * @return the hashcode of the artist's details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.getAge(), this.getGenre(), this.getAwards(),
        movies, series, others);
  }
}
