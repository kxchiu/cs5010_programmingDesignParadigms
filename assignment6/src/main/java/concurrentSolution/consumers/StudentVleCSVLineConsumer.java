package concurrentSolution.consumers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StudentVleCSVLineConsumer extends CSVLineConsumer{

  private ConcurrentMap<String, ConcurrentMap<Integer, Integer>> compressedClicks;
  private ConcurrentMap<String, Integer> courseTotalClicks;

  public StudentVleCSVLineConsumer(BlockingQueue<String> buffer, ConcurrentMap<String,
      ConcurrentMap<Integer, Integer>> compressedClicks, ConcurrentMap<String, Integer> courseTotalClicks) {
    super(buffer);
    this.compressedClicks = compressedClicks;
    this.courseTotalClicks = courseTotalClicks;
  }

  @Override
  void consume(String longline) {
    String[] line = longline.replaceAll("\"", "").split(",");
    String codeModule = line[0];
    String codePresentation = line[1];
    Integer date = new Integer(line[4]);
    Integer sumClick = new Integer(line[5]);
    String course = codeModule + "_" + codePresentation;
    ConcurrentMap<Integer, Integer> updatedDateClickPair = compressedClicks.computeIfAbsent(course, k -> new ConcurrentHashMap<>());
    Integer old, newVal;
    do {
      old = updatedDateClickPair.computeIfAbsent(date, k -> 0);
      newVal = old + sumClick;
    } while (!updatedDateClickPair.replace(date, old, newVal));
    do {
      old = courseTotalClicks.computeIfAbsent(course, k -> 0);
      newVal = old + sumClick;
    } while (!courseTotalClicks.replace(course, old, newVal));
  }
}
