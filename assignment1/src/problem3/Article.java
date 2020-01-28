package problem3;

/**
 * This class extends the Publication class and represents an Article that stores the title,
 * author(s), published year, and number of citations.
 */

public class Article extends Publication {

  /**
   * Creates a new article record with given details--title, authors, published year, and number
   * of citations.
   * @param title the title of the article
   * @param authors the author(s) of the article
   * @param publishYear the published year of the article
   * @param citation the number of citations
   */
  public Article(String title, String[] authors, int publishYear, int citation) {
    super(title, authors, publishYear, citation);
  }
}