import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class represents a CSV-file reader that reads the CSV file and generates Person record from
 * the file information.
 */
public class CsvReader {

  /**
   * Constructs a CSV reader that processes the given CSV file.
   */
  public CsvReader() {
  }

  /**
   * Reads from the CSV file and returns the persons details as a List of Person.
   * @param persons the list of persons to save to
   * @param file the given CSV file path
   * @return a list of persons details
   */
  public List<Person> writeToPerson(List<Person> persons, Path file) {
    try (InputStream in = Files.newInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      String line = null;
      while (!(line = reader.readLine()).equals("")) {
        System.out.println(line);
        line = line.replaceAll("\"", "");
        String[] personItems = line.split(",");
        Name tempName = new Name(personItems[0], personItems[1]);
        AddressInfo tempAddress = new AddressInfo(personItems[2], personItems[3], personItems[4],
            personItems[5], personItems[6], personItems[7]);
        ContactInfo tempContact = new ContactInfo(personItems[8],
            personItems[9], personItems[10], personItems[11]);
        Person tempPerson = new Person(tempName, tempAddress, tempContact);
        persons.add(tempPerson);
      }
    } catch (IOException x) {
      System.err.println(x);
    }
    return persons;
  }
}
