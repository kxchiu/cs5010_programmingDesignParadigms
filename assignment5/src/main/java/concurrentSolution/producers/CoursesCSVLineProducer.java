package concurrentSolution.producers;

import concurrentSolution.dataClasses.AbstractCSVLine;
import concurrentSolution.dataClasses.CoursesCSVLine;

import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

public class CoursesCSVLineProducer extends CSVLineProducer {

  public CoursesCSVLineProducer(BlockingQueue<AbstractCSVLine> buffer, FileReader csvFile) {
    super(buffer, csvFile);
  }

  @Override
  AbstractCSVLine createCSVLineObject(String[] line) {
    CoursesCSVLine courseLine = new CoursesCSVLine();
    courseLine.setCodeModule(line[0]);
    courseLine.setCodePresentation(line[1]);
    courseLine.setCodePresentationLength(line[2]);
    return courseLine;
  }
}
