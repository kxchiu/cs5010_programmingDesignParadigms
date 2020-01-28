package problem3;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class extends the Article class and represents a journal that stores the title, author(s),
 * published year, number of citations, published year, and editors.
 */

public class Journal extends Article {
  private String publisher;
  private String[] editors;

  /**
   * Creates a new journal with given details.
   * @param title the title of the journal
   * @param authors the author(s) of the journal
   * @param publishYear the published year of the journal
   * @param citation the number of citations
   * @param publisher the publisher of the journal
   * @param editors the editor(s) of the journal
   */
  public Journal(String title, String[] authors, int publishYear, int citation, String publisher,
      String[] editors) {
    super(title, authors, publishYear, citation);
    this.publisher = publisher;
    this.editors = editors;
  }

  /**
   * Returns the publisher of the journal.
   * @return the publisher of the journal
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * Returns the editors of the journal.
   * @return the editors of the journal
   */
  public String getEditors() {
    return Arrays.toString(this.editors);
  }

  /**
   * Calculates the estimated impact of the journal.
   * @return the estimated impact of the journal
   * @throws ImpactEstimationException when the journal is over 250 years old
   */
  @Override
  public Double estimateImpact() throws ImpactEstimationException {
    double base = super.estimateImpact();
    base *= 2;

    return base;
  }

  /**
   * Returns the details of the journal as String.
   * @return the details of the journal
   */
  public String toString() {
    String str;
    str = "Title: " + this.getTitle() + "\n" +
        "Authors: " + this.getAuthors() + "\n" +
        "Published Year: " + this.getPublishYear() + "\n" +
        "Number of Citations: " + this.getCitation() + "\n" +
        "Publisher: " + this.getPublisher() + "\n" +
        "Editors: " + this.getEditors();
    return str;
  }

  /**
   * Compares the journal to the given object.
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
    Journal journal = (Journal) o;
    return Objects.equals(this.getTitle(), journal.getTitle())
        && Objects.equals(this.getAuthors(), journal.getAuthors())
        && Float.compare(this.getPublishYear(), journal.getPublishYear()) == 0
        && Float.compare(this.getCitation(), journal.getCitation()) == 0
        && Objects.equals(this.getPublisher(), journal.getPublisher())
        && Objects.equals(this.getEditors(), journal.getEditors());
  }

  /**
   * Returns a hash code of the journal details.
   * @return a hash code of the journal details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTitle(), this.getAuthors(), this.getPublishYear(),
        this.getCitation(), this.getPublisher(), this.getEditors());
  }
}
