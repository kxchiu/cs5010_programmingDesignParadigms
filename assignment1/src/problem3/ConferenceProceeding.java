package problem3;

import java.util.Objects;

/**
 * This class extends the Article class and represents a conference proceeding that stores the
 * title, author(s), published year, number of citations, conference name, and conference
 * location.
 */

public class ConferenceProceeding extends Article {
  private String confName;
  private String confLocation;

  /**
   * Creates a new conference proceeding with given details.
   * @param title the title of the conference proceeding
   * @param authors the author(s) of the conference proceeding
   * @param publishYear the published year of the conference proceeding
   * @param citation the number of citations
   * @param confName the conference name
   * @param confLocation the conference location
   */
  public ConferenceProceeding(String title, String[] authors, int publishYear, int citation,
      String confName, String confLocation) {
    super(title, authors, publishYear, citation);
    this.confName = confName;
    this.confLocation = confLocation;
  }

  /**
   * Returns the name of the conference.
   * @return the name of the conference
   */
  public String getConfName() {
    return this.confName;
  }

  /**
   * Returns the location of the conference.
   * @return the location of the conference
   */
  public String getConfLocation() {
    return this.confLocation;
  }

  /**
   * Returns the conference proceeding details as String.
   * @return the conference proceeding details
   */
  public String toString() {
    String str;
    str = "Title: " + this.getTitle() + "\n" +
        "Authors: " + this.getAuthors() + "\n" +
        "Published Year: " + this.getPublishYear() + "\n" +
        "Number of Citations: " + this.getCitation() + "\n" +
        "Conference Name: " + this.getConfName() + "\n" +
        "Conference Location: " + this.getConfLocation();
    return str;
  }

  /**
   * Compares the conference proceedings.
   * @param o the object being compared to
   * @return true/false as the comparison result
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceProceeding conferenceProceeding = (ConferenceProceeding) o;
    return Objects.equals(this.getTitle(), conferenceProceeding.getTitle())
        && Objects.equals(this.getAuthors(), conferenceProceeding.getAuthors())
        && Float.compare(this.getPublishYear(), conferenceProceeding.getPublishYear()) == 0
        && Float.compare(this.getCitation(), conferenceProceeding.getCitation()) == 0
        && Objects.equals(this.getConfName(), conferenceProceeding.getConfName())
        && Objects.equals(this.getConfLocation(), conferenceProceeding.getConfLocation());
  }

  /**
   * Returns a hash code of the conference proceeding details.
   * @return a hash code of the conference proceeding details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTitle(), this.getAuthors(), this.getPublishYear(),
        this.getCitation(), this.getConfName(), this.getConfLocation());
  }
}
