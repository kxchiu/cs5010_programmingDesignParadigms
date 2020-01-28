package assignment1;

/**
 * Class Runner contains information about a runner, including runner's name, their height,
 * weight, league, best 5K and half-marathon time, and favorite running event.
 */
public class Runner extends Athlete {
  private Double best5kTime;
  private Double bestHalfMarTime;
  private String favRunEvent;

  /**
   * Constructs a new runner, based upon all of the provided input parameters.
   * @param athletesName - containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
   * @param best5kTime - best 5K time
   * @param bestHalfMarTime - best half-marathon time
   * @param favRunEvent - athlete's favorite running event
   */
  public Runner(String athletesName, Double height, Double weight, String league, double best5kTime,
      double bestHalfMarTime, String favRunEvent) {
    super(athletesName, height, weight, league);
    this.best5kTime = best5kTime;
    this.bestHalfMarTime = bestHalfMarTime;
    this.favRunEvent = favRunEvent;
  }

  /**
   * Returns the runner's best 5K time as Double.
   * @return the runner's best 5K time
   */
  public Double getBest5kTime() {
    return this.best5kTime;
  }

  /**
   * Returns the runner's best half-marathon time as Double.
   * @return the runner's best half-marathon time
   */
  public Double getBestHalfMarTime() {
    return this.bestHalfMarTime;
  }

  /**
   * Returns the runner's favorite running event as String.
   * @return the runner's favorite running event
   */
  public String getFavRunEvent() {
    return this.favRunEvent;
  }
}
