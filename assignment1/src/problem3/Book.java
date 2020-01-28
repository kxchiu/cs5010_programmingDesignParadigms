package problem3;

import java.util.Objects;

/**
 * This class extends the Publication class and represents a book that stores the title,
 * author(s), published year, number of citations, publisher, and number of pages.
 */

public class Book extends Publication {
  private String publisher;
  private Integer page;

  /**
   * Creates a new book record with given details--title, authors, published year, number of
   * citations, publisher, and number of pages.
   * @param title the title of the book
   * @param authors the author(s) of the book
   * @param publishYear the published year of the book
   * @param citation the number of citations
   * @param publisher the publisher of the book
   * @param page the number of pages
   */
  public Book(String title, String[] authors, int publishYear, int citation, String publisher,
      int page) {
    super(title, authors, publishYear, citation);
    this.publisher = publisher;
    this.page = page;
  }

  /**
   * Returns the publisher of the book.
   * @return the publisher of the book
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * Returns the number of pages.
   * @return the number of pages
   */
  public Integer getPage() {
    return this.page;
  }

  /**
   * Returns the estimated impact of the book.
   * @return the estimated impact
   * @throws ImpactEstimationException when the book is over 250 years old
   */
  @Override
  public Double estimateImpact() throws ImpactEstimationException {
    double base = super.estimateImpact();
    base *= 4;

    return base;
  }

  /**
   * Returns the book details as String.
   * @return the book details
   */
  public String toString() {
    String str;
    str = "Title: " + this.getTitle() + "\n" +
        "Authors: " + this.getAuthors() + "\n" +
        "Published Year: " + this.getPublishYear() + "\n" +
        "Number of Citations: " + this.getCitation() + "\n" +
        "Publisher: " + this.getPublisher() + "\n" +
        "Number of Page: " + this.getPage();
    return str;
  }

  /**
   * Compares the book to an object being passed to.
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
    Book book = (Book) o;
    return Objects.equals(this.getTitle(), book.getTitle())
        && Objects.equals(this.getAuthors(), book.getAuthors())
        && Float.compare(this.getPublishYear(), book.getPublishYear()) == 0
        && Float.compare(this.getCitation(), book.getCitation()) == 0
        && Objects.equals(this.getPublisher(), book.getPublisher())
        && Float.compare(this.getPage(), book.getPage()) == 0;
  }

  /**
   * Returns a hash code of the book details.
   * @return a hash code of the book details
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTitle(), this.getAuthors(), this.getPublishYear(),
        this.getCitation(), this.getPublisher(), this.getPage());
  }
}
