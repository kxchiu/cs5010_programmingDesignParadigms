package Part3;

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; /////

public class HighActivity {

  private List<String[]> rows;

  public HighActivity(HashMap<String, HashMap<Integer, Integer>> map, int threshold)
      throws FileNotFoundException {
    identify(map, threshold);
    write(threshold);
  }

  public void identify(HashMap<String, HashMap<Integer, Integer>> map, int threshold)
      throws FileNotFoundException {
    rows = new ArrayList<>();
    rows.add(new String[] {"module_presentation", "date", "total_clicks"});
    for (String csv : map.keySet()) {
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csv + ".csv"))) {
        bufferedReader.readLine();
        int value = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          String[] dateToClicks = line.split(",");
          String clicks = dateToClicks[1].replaceAll("\"", "");
          if (Integer.parseInt(clicks) >= threshold) {
            String[] row = new String[3];
            row[0] = csv;
            row[1] = dateToClicks[0].replaceAll("\"", "");
            row[2] = clicks;
            rows.add(row);
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void write(int threshold) {
    File file = new File("activity-" + String.valueOf(threshold) + ".csv");

    try {
      // create FileWriter object with file as parameter
      FileWriter outputfile = new FileWriter(file);

      // create CSVWriter object filewriter object as parameter
      CSVWriter writer = new CSVWriter(outputfile);

      // write CSV

      writer.writeAll(rows);

      // closing writer connection
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
