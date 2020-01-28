package concurrentSolution.consumers;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CoursesCSVLineConsumer extends CSVLineConsumer {

  private Map<String, Integer> courseLengthPairs;

  public CoursesCSVLineConsumer(
      BlockingQueue<String> buffer, Map<String, Integer> courseLengthPairs) {
    super(buffer);
    this.courseLengthPairs = courseLengthPairs;
  }

  @Override
  void consume(String longline) {
    String[] line = longline.replaceAll("\"", "").split(",");
    String codeModule = line[0];
    String codePresentation = line[1];
    Integer modulePresentationLength = new Integer(line[2]);
    String course = codeModule + "_" + codePresentation;
    courseLengthPairs.put(course, modulePresentationLength);
  }
}
