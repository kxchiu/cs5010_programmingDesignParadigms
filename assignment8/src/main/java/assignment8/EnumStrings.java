package assignment8;

public enum EnumStrings {
  NO_TITLE("No Title"),
  YES("y"),
  NO("n"),
  PLACEHOLDER_OPENER("<"),
  PLACEHOLDER_CLOSER(">");

  private String literal;

  EnumStrings(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
