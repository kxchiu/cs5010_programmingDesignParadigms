package assignment1;

/**
 * Class Athlete contains information about an athlete, including athlete's name, their height,
 * weight and league.
*/
public class Athlete {
  private String athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName - containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
  */
  public Athlete(String athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName - containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *               187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
  */
  public Athlete(String athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * Returns athlete's name as an object Name.
   * @return athlete's name
  */
  public String getAthletesName() {
    return athletesName;
  }

  /**
   * Returns athlete's height as a Double.
   * @return athlete's height
  */
  public Double getHeight() {
    return height;
  }

  /**
   * Returns athlete's weight as a Double.
   * @return athlete's weight
  */
  public Double getWeight() {
    return weight;
  }

  /**
   * Returns athlete's league as a String.
   * @return athlete's league
  */
  public String getLeague() {
    return league;
  }
}