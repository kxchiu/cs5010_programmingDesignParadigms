package concurrentSolution.consumers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AssessmentCSVLineConsumer extends CSVLineConsumer {
  private ConcurrentMap<String, Map<Integer, String>> courseAssessments;

  public AssessmentCSVLineConsumer(BlockingQueue<String> buffer,
                                   ConcurrentMap<String, Map<Integer, String>>  courseAssessments) {
    super(buffer);
    this.courseAssessments = courseAssessments;
  }

  @Override
  void consume(String longline) {
    String[] line = longline.replaceAll("\"\"","\"N/A\"").replaceAll("\"", "").split(",");
    String codeModule = line[0];
    String codePresentation = line[1];
    String course = codeModule + "_" + codePresentation;
    String assessmentType = line[3];
    Integer date = line[4].equals("N/A") ? 0 : new Integer(line[4]);
    Map<Integer, String> old, newVal;
    do {
      old = courseAssessments.computeIfAbsent(course, k -> new HashMap<>());
      old.put(date, assessmentType);
      newVal = old;
    } while (!courseAssessments.replace(course, old, newVal));

  }
}
