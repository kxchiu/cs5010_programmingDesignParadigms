import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class represents a message generator that takes the email template and list of people and
 * generate a list of messages (email or letter) upon requested.
 */
public class MessageGenerator {

  /**
   * Constructs a message generator that reads the persons details and template and generates a list
   * of message files.
   */
  public MessageGenerator() {
  }

  /**
   * Reads the template file and outputs message files with replaced information from persons'
   * details.
   * @param persons the given list of persons
   * @param file the template file path
   * @param outputDir the given output directory
   * @throws IOException
   */
  public void generateMsg(List<Person> persons, Path file, Path outputDir) throws IOException {
    Charset charset = StandardCharsets.UTF_8;
    String original = new String(Files.readAllBytes(file), charset);
    for (Person person : persons) {
      String newFile = original;
      newFile = replaceWords(person, newFile);
      // Write file to a renamed path
      if (!Files.exists(outputDir)) {
        Files.createDirectory(outputDir);
      }
      Files.write(Paths.get(outputDir + "\\" + person.toString() + ".txt"), newFile.getBytes(charset));
    }
  }

  /**
   * Helper method to replace words in the file and returns file as a String.
   * @param person the given person
   * @param newFile the given file
   * @return the file with replaced words
   */
  private String replaceWords(Person person, String newFile) {
    return newFile.replaceAll("\\[\\[first_name]]", person.getFirstName())
        .replaceAll("\\[\\[last_name]]", person.getLastName())
        .replaceAll("\\[\\[company_name]]", person.getCompanyName())
        .replaceAll("\\[\\[address]]", person.getAddress())
        .replaceAll("\\[\\[city]]", person.getCity())
        .replaceAll("\\[\\[county]]", person.getCounty())
        .replaceAll("\\[\\[state]]", person.getState())
        .replaceAll("\\[\\[zip]]", String.valueOf(person.getZip()))
        .replaceAll("\\[\\[email]]", person.getEmail());
  }
}
