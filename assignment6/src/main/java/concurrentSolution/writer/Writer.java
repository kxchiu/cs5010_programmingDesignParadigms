package concurrentSolution.writer;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class Writer {
  Map<String, Integer> courseLengthPairs;
  ConcurrentMap<String, Map<Integer, String>> courseAssessments;
  ConcurrentMap<String, ConcurrentMap<Integer, Integer>> clicksCompressed;
  ConcurrentMap<String, Integer> courseTotalClicks;
  transient private String outputDirectory = "output";
  transient private String[] summaryHeaderFormat = new String[] {"date", "normalized_date", "total_clicks",
      "relative_clicks","assessment_type"};
  transient private String[] highActivityHeaderFormat = new String[] {"module_presentation", "date", "total_clicks"};

  public Writer(Map<String, Integer> courseLengthPairs, ConcurrentMap<String, Map<Integer, String>> courseAssessments, ConcurrentMap<String, ConcurrentMap<Integer, Integer>> clicksCompressed, ConcurrentMap<String, Integer> courseTotalClicks) {
    this.courseLengthPairs = courseLengthPairs;
    this.courseAssessments = courseAssessments;
    this.clicksCompressed = clicksCompressed;
    this.courseTotalClicks = courseTotalClicks;
  }

  public void writeHighActivitySummary(int threshold) throws IOException {
    List<String[]> rows = new ArrayList<>();
    rows.add(highActivityHeaderFormat);
    for (Map.Entry<String, ConcurrentMap<Integer, Integer>> entry: clicksCompressed.entrySet()) {
      for (Map.Entry<Integer, Integer> pair: entry.getValue().entrySet()) {
        if (pair.getValue() >= threshold) {
          rows.add(new String[] {entry.getKey(), String.valueOf(pair.getKey()), String.valueOf(pair.getValue())});
        }
      }
    }

    createDirectoryIfAbsent(outputDirectory);

    CSVWriter outputFile = new CSVWriter(new FileWriter(new File(outputDirectory + File.separator +
        "activity-" + threshold + ".csv")));
    outputFile.writeAll(rows);
    outputFile.close();
  }

  public void writeSummary() throws IOException {
    for (Map.Entry<String, ConcurrentMap<Integer, Integer>> course : clicksCompressed.entrySet()) {
      List<String[]> rows = new ArrayList<>();
      rows.add(summaryHeaderFormat);
      String courseName = course.getKey();
      ConcurrentMap<Integer, Integer> courseInfo = course.getValue();
      Integer courseLength = courseLengthPairs.get(courseName);
      Integer totalClicks = courseTotalClicks.get(courseName);
      Map<Integer, String> assessments = courseAssessments.get(courseName);
      for (Map.Entry<Integer, Integer> dateClickPair : courseInfo.entrySet()) {
        Integer date = dateClickPair.getKey();
        Integer dayClicks = dateClickPair.getValue();
        Double normalizedDate = calculateNormalizedDate(date, courseLength);
        Double relativeClicks = calculateRelativeClicks(date, courseLength, dayClicks, totalClicks);
        String dayAssessment = assessments.getOrDefault(date, "N/A");
        rows.add(new String[]{
            String.valueOf(date),
            String.format("%.2f", normalizedDate),
            String.valueOf(totalClicks),
            String.format("%.2f", relativeClicks),
            String.valueOf(dayAssessment),
        });
      }

      createDirectoryIfAbsent(outputDirectory);

      CSVWriter outputFile =
          new CSVWriter(new FileWriter(new File(outputDirectory + File.separator + course.getKey() + ".csv")));
      outputFile.writeAll(rows);
      outputFile.close();
    }
  }

  private static void createDirectoryIfAbsent(String directory) {
    Path path = Paths.get(directory);
    if (!Files.exists(path)) {
      try {
        Files.createDirectories(path);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private Double calculateRelativeClicks(Integer date, Integer length, Integer dayClicks,
                                         Integer totalClicks) {
    Integer activePeriod = length - date;
    Double dailyAverageClicks = new Double(totalClicks) / new Double(activePeriod);
    return dayClicks/dailyAverageClicks;
  }

  private Double calculateNormalizedDate(Integer date, Integer length) {
    return new Double(date) / new Double(length);
  }



}
