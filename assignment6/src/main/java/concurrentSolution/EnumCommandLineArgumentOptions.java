package concurrentSolution;

public enum EnumCommandLineArgumentOptions {

 INPUT_DIRECTORY( "inputdir", true, 1, ' ', "Input file directory.", true),
 ASSESSMENT( "assessment", true, 1, ' ', "Assessment CSV File.", true),
 COURSES( "courses", true, 1, ' ', "Courses CSV File.", true),
 STUDENTVLE( "studentVle", true, 1, ' ', "StudentVle CSV File.", true),
 HIGH_ACTIVITY("highActivityThreshold", true, 1, ' ', "High activity threshold value.", false);

 transient private String argument;
 transient private Boolean hasArgument;
 transient private Boolean required;
 transient private Integer numberOfArguments;
 transient private Character valueSeparator;
 transient private String description;

 EnumCommandLineArgumentOptions(final String argument, final Boolean hasArgument,
                final Integer numberOfArguments, final Character valueSeparator, final String description,
                                final Boolean required) {
  this.argument = argument;
  this.hasArgument = hasArgument;
  this.numberOfArguments = numberOfArguments;
  this.valueSeparator = valueSeparator;
  this.description = description;
  this.required = required;
 }

 public Boolean getRequired() {
  return required;
 }

 public String getArgument() {
  return argument;
 }

 public Boolean getHasArgument() {
  return hasArgument;
 }

 public Integer getNumberOfArguments() {
  return numberOfArguments;
 }

 public Character getValueSeparator() {
  return valueSeparator;
 }

 public String getDescription() {
  return description;
 }
}
