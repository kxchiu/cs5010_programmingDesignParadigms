public enum EnumGrammarKeys {
  GRAMMAR_TITLE("grammartitle"),
  START("start");

  private String key;

  EnumGrammarKeys(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
