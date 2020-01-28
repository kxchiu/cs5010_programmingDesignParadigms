package problem3;

/**
 * This class extends the Book class and represents an edited volume that stores the title,
 * author(s), published year, number of citations, publisher, and number of pages.
 */

public class EditedVolume extends Book {

  /**
   * Creates a new edited volume with the given details.
   * @param title the title of the edited volume
   * @param authors the author(s) of the edited volume
   * @param publishYear the published year of the edited volume
   * @param citation the number of citations
   * @param publisher the publisher of the edited volume
   * @param page the number of pages of the edited volume
   */
  public EditedVolume(String title, String[] authors, int publishYear, int citation,
      String publisher, int page) {
    super(title, authors, publishYear, citation, publisher, page);
  }

  //other meaningful methods, if any
}
