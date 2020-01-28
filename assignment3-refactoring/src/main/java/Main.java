import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is the Main class that instructs a CSV reader to process the given CSV file and
 * a message generator to create message files.
 */
public class Main {
  private static List<Person> persons;
  private static CsvReader csvReader;
  private static MessageGenerator messageGenerator;
  private static EmailSender emailSender;

  public static void main(String[] args) throws IOException, RecepientNotFoundException {
    // Check for args error: if any, print error message
    if (!checkArg(args)) {
      printUsageMsg(args);
    } else if (checkEmailArg(args)) { // Check if sending email
      emailSender = new EmailSender();
      // Grabs recepient full name
      String recepient = args[indexOfArg(("email-recepient"), args) + 1] + " "
          + args[indexOfArg(("email-recepient"), args) + 2];
      emailSender.sendEmail(persons, recepient);
    } else { // If no error, generate message files
      csvReader = new CsvReader();
      Path csvFile = Paths.get(args[indexOfArg("\\.csv", args)]);
      persons = new ArrayList<Person>();
      persons = csvReader.writeToPerson(persons, csvFile);

      Path txtFile = Paths.get(args[indexOfArg("\\.txt", args)]);
      Path outputDir = Paths.get(args[indexOfArg("output", args) + 1]);
      messageGenerator = new MessageGenerator();
      messageGenerator.generateMsg(persons, txtFile, outputDir);
    }
  }

  /**
   * Returns the index of the given pattern String as Int.
   * @param patternString the given pattern String
   * @param args the given arguments
   * @return the index of the given pattern String
   */
  private static int indexOfArg(String patternString, String[] args) {
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher;
    for (int i = 0; i < args.length; i++) {
      matcher = pattern.matcher(args[i]);
      if (matcher.find()) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Check for any missing arguments in the args and return a Boolean.
   * @param args the given arguments
   * @return if missing any argument
   */
  private static boolean checkArg(String[] args) {
    return checkArgExists("--output-dir", args) && checkArgExists("--csv-file", args)
        && (checkArgExists("--email", args) == checkArgExists("--email-template", args))
        && (checkArgExists("--letter", args) == checkArgExists("--letter-template", args));
  }

  private static boolean checkEmailArg(String[] args) {
    return checkArgExists("--send-email", args)
        && checkArgExists("--email-recepient", args);
  }

  /**
   * Helper method to find matching argument and return a Boolean.
   * @param patternString pattern String to match
   * @param args the given arguments
   * @return if a match is found
   */
  private static boolean checkArgExists(String patternString, String[] args) {
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(Arrays.toString(args));
    return matcher.find();
  }

  /**
   * Prints error message.
   * @param args the given arguments
   */
  private static void printUsageMsg(String[] args) {
    String error = Arrays.toString(args);
    System.out.println("An error has occurred:\n" + error + "\n");
    System.out.println("Usage:\n"
        + "\t--email\t\t\t\t\t\t\t\t\t\tonly generate email messages\n"
        + "\t--email-template <file>\t\taccept a filename that holds the email template.\n"
        + "\t\tRequired if --email is used\n\n"
        + "\t--letter\t\t\t\t\t\t\t\t\tonly generate letter messages\n"
        + "\t--letter-template <file>\taccept a filename that holds the letter template.\n"
        + "\t\tRequired if --letter is used\n\n"
        + "\t--output-dir <path>\t\t\t\taccept a filename that holds the email template.\n\n"
        + "\t--csv-file <path>\t\t\t\t\taccept the name of the csv file to process\n\n"
        + "Example:\n\t\t--email --email-template email-template.txt --output-dir emails --csv-file"
        + " customer.csv\n"
        + "\t\t--letter --letter-template letter-template.txt --output-dir letters --csv-file"
        + " customer.csv"
    );
  }
}
