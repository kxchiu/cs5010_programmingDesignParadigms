package assignment1;

/**
 * Class BaseballPlayer contains information about a player, including player's name, their height,
 * weight, league, team, batting average and season home-runs.
 */
public class BaseballPlayer extends Athlete {
  private String team;
  private Double batAvg;
  private Integer seasonHR;

  /**
   * Constructs a new baseball player, based upon all of the provided input parameters.
   * @param athletesName - containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
   * @param team - athlete's team
   * @param batAvg - athlete's batting average
   * @param seasonHR - athlete's season home-runs
   */
  public BaseballPlayer(String athletesName, Double height, Double weight,
      String league, String team, Double batAvg, Integer seasonHR) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.batAvg = batAvg;
    this.seasonHR = seasonHR;
  }

  /**
   * Returns the player's team as String.
   * @return the player's team
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Returns the player's batting average as Double.
   * @return the player's batting average
   */
  public Double getBatAvg() {
    return this.batAvg;
  }

  /**
   * Retunrs the player's season home-runs as Integer.
   * @return the player's season home-runs
   */
  public Integer getSeasonHR() {
    return this.seasonHR;
  }
}