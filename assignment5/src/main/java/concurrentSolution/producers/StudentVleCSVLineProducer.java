package concurrentSolution.producers;

import concurrentSolution.dataClasses.AbstractCSVLine;
import concurrentSolution.dataClasses.StudentVleLine;

import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

public class StudentVleCSVLineProducer extends CSVLineProducer {

  public StudentVleCSVLineProducer(BlockingQueue<AbstractCSVLine> buffer, FileReader csvFile) {
    super(buffer, csvFile);
  }

  @Override
  AbstractCSVLine createCSVLineObject(String[] line) {
    StudentVleLine studentVleLine = new StudentVleLine();
    studentVleLine.setCodeModule(line[0]);
    studentVleLine.setCodePresentation(line[1]);
    studentVleLine.setIdStudent(line[2]);
    studentVleLine.setIdSite(line[3]);
    studentVleLine.setDate(line[4]);
    studentVleLine.setSumClick(line[5]);
    return studentVleLine;
  }
}
