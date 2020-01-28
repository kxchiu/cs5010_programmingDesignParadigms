package problem3;

/**
 * This class extends the Book class and represents a textbook that stores the title, author(s),
 * published year, number of citations, publisher, and number of pages.
 */

public class Textbook extends Book {

  /**
   * Creates a new textbook record with given details.
   * @param title the title of the textbook
   * @param authors the author(s) of the textbook
   * @param publishYear the published year of the textbook
   * @param citation the number of citations
   * @param publisher the publisher of the textbook
   * @param page the number of pages
   */
  public Textbook(String title, String[] authors, int publishYear, int citation, String publisher,
      int page) {
    super(title, authors, publishYear, citation, publisher, page);
  }

  //other meaningful methods, if any
}
