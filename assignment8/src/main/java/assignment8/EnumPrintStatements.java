package assignment8;

public enum EnumPrintStatements {

  UNKNOWN_COMMAND("Unknown command. Please respond again."),
  ASK_ANOTHER_SENTENCE("Would you like another one? (y/n)"),
  WHITESPACE_LINE(""),
  ASK_WHICH_JSON("Which would you like to use? (q to quit)"),
  STATE_AVAILABLE_GRAMMARS("The following grammars are available:"),
  LOADING_GRAMMARS("Loading gramars...");

  private String string;

  EnumPrintStatements(String string) {
    this.string = string;
  }

  public void printString() {
    System.out.println(this.string);
  }
}
