package problem1;

import java.util.Objects;

/**
 * This class represents a Transit Card that holds information to the card owner and the current
 * balance.
 */
public class TransitCard {
  private CardOwner cardOwner;
  private Integer dollar;
  private Integer cent;

  /**
   * Creates a new transit card with the given card owner as CardOwner and current balance as
   * Integer.
   * @param cardOwner the card owner of the transit card
   * @param dollar the dollar amount in the transit card's current balance
   * @param cent the cent amount in the transit card's current balance
   */
  public TransitCard(CardOwner cardOwner, int dollar, int cent) {
    this.cardOwner = cardOwner;
    this.dollar = dollar;
    this.cent = cent;
  }

  /**
   * Returns the dollar amount in the current balance.
   * @return the dollar amount in the current balance
   */
  public Integer getDollar() {
    return this.dollar;
  }

  /**
   * Returns the cent amount in the current balance.
   * @return the cent amount in the current balance
   */
  public Integer getCent() {
    return this.cent;
  }

  /**
   * Process the given deposit, first by checking the depositor's name, then by checking the
   * deposit amount; adds money to the current balance if all checked information is correct.
   * @param newDeposit the new deposit to the transit card
   */
  public void depositMoney(Deposit newDeposit) {
    if (!newDeposit.getFirstName().equals(this.cardOwner.getFirstName())
        || !newDeposit.getLastName().equals(this.cardOwner.getLastName())) {
      System.out.println("The name you entered does not match our system record. Please retry.");
    } else if ((newDeposit.getDollar() >= 50 && newDeposit.getCent() > 0)
        || newDeposit.getDollar() < 5) {
      System.out.println("Your deposit amount must be between $50 and $5. Please try again.");
    } else if (newDeposit.getCent() + this.cent >= 100) {
      this.dollar += newDeposit.getDollar() + 1;
      this.cent = (this.cent + newDeposit.getCent()) % 100;
    } else {
      this.dollar += newDeposit.getDollar();
      this.cent += newDeposit.getCent();
    }
  }

  /**
   * Returns the current balance of the Transit Card as String.
   * @return the current balance
   */
  public String toString() {
    String str;
    str = "" + this.getDollar() + ".";
    if (this.getCent() == 0) {
      str += "0";
    }
    str += this.getCent();
    return str;
  }

  /**
   * Compares the card information to another card.
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
    TransitCard transitCard = (TransitCard) o;
    return Float.compare(dollar, transitCard.dollar) == 0
        && Float.compare(cent, transitCard.cent) == 0
        && Objects.equals(transitCard.cardOwner, cardOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDollar(), this.getCent(), this.cardOwner);
  }
}
