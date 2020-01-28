package Part2;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Writer {

  public void writeDataAtOnce(String filePath, List<String[]> list) {

    // first create file object for file placed at location
    // specified by filepath
    File file = new File(filePath + ".csv");

    try {
      // create FileWriter object with file as parameter
      FileWriter outputfile = new FileWriter(file);

      // create CSVWriter object filewriter object as parameter
      CSVWriter writer = new CSVWriter(outputfile);

      // write CSV

      writer.writeAll(list);

      // closing writer connection
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void getCourse(HashMap<String, HashMap<Integer, Integer>> map) {
    for (String courseNum : map.keySet()) {
      List<String[]> list = getClicks(map, courseNum);
      writeDataAtOnce(courseNum, list);
    }
  }

  public List<String[]> getClicks(HashMap<String, HashMap<Integer, Integer>> map, String course) {
    List<String[]> data = new ArrayList<String[]>();
    data.add(new String[] {"Date", "Total number of clicks"});
    for (int date : map.get(course).keySet()) {

      int clicks = map.get(course).get(date);
      data = this.addData(data, date, clicks);
    }
    return data;
  }

  public List<String[]> addData(List<String[]> data, int date, int clicks) {
    data.add(new String[] {String.valueOf(date), String.valueOf(clicks)});
    return data;
  }
}
