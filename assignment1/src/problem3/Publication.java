package problem3;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents a general publication record that stores the title, author(s), published
 * year, and number of citations.
 */
public class Publication {
  private String title;
  private String[] authors;
  private Integer publishYear;
  private Integer citation;
  private final Integer CURRENT_YEAR = 2019;

  /**
   * An empty constructor for the Publication class.
   */
  public Publication() {
    //empty constructor for the Publication class
  }

  /**
   * Creates a new publication record given the details--title, authors, published year, and number
   * of citations.
   * @param title the title of the publication
   * @param authors the author(s) of the publication
   * @param publishYear the published year
   * @param citation the number of citations
   */
  public Publication(String title, String[] authors, int publishYear, int citation) {
    this.title = title;
    this.authors = authors;
    this.publishYear = publishYear;
    this.citation = citation;
  }

  /**
   * Returns the calculated base estimated impact of the publication as a double.
   * @return the estimated impact of the publication
   * @throws ImpactEstimationException when the publication is over 250 years old
   */
  public Double estimateImpact() throws ImpactEstimationException {
    int age = Math.max(CURRENT_YEAR - publishYear, 1);
    double base = ((double)citation) / age;

    if (age > 250) {
      throw new ImpactEstimationException("The publication is over 250 years old and "
          + "will not be counted toward estimated impact.");
    }

    if (age <= 3) {
      base += 100;
    }

    return base;
  }

  /**
   * Returns the title of the publication.
   * @return the title of the publication.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the author(s) of the publication.
   * @return the author(s) of the publication
   */
  public String getAuthors() {
    return Arrays.toString(this.authors);
  }

  /**
   * Returns the published year of the publication.
   * @return the published year of the publication
   */
  public Integer getPublishYear() {
    return this.publishYear;
  }

  /**
   * Returns the number of citations.
   * @return the number of citations
   */
  public Integer getCitation() {
    return this.citation;
  }

  /**
   * Sets the title of the publication.
   * @param newTitle the new title of the publication
   */
  public void setTitle(String newTitle) {
    this.title = newTitle;
  }

  /**
   * Sets the author(s) of the publication.
   * @param newAuthors the new author(s) of the publication
   */
  public void setAuthors(String[] newAuthors) {
    this.authors = newAuthors;
  }

  /**
   * Sets the published year of the publication.
   * @param newPublishYear the new published year of the publication
   */
  public void setPublishYear(int newPublishYear) {
    this.publishYear = newPublishYear;
  }

  /**
   * Sets the number of citations of the publication.
   * @param newCitation the new number of citations
   */
  public void setCitation(int newCitation) {
    this.citation = newCitation;
  }

  /**
   * Returns a String of the publication details.
   * @return a String of the publication details
   */
  public String toString() {
    String str;
    str = "Title: " + this.title + "\n" +
        "Authors: " + Arrays.toString(this.authors) + "\n" +
        "Published Year: " + this.publishYear + "\n" +
        "Number of Citations: " + this.citation;
    return str;
  }

  /**
   * Compares the publication to the object.
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
    Publication publication = (Publication) o;
    return Objects.equals(title, publication.title)
        && Objects.equals(authors, publication.authors)
        && Float.compare(publication.publishYear, publishYear) == 0
        && Float.compare(citation, publication.citation) == 0;
  }

  /**
   * Returns a hash code of the publication details.
   * @return a hash code of the publication details
   */
  @Override
  public int hashCode() {
    return Objects.hash(title, authors, publishYear, citation);
  }
}
