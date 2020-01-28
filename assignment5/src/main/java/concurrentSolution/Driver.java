package concurrentSolution;

import concurrentSolution.dataClasses.AbstractCSVLine;
import concurrentSolution.producers.CSVLineProducer;
import concurrentSolution.producers.CoursesCSVLineProducer;
import concurrentSolution.producers.StudentVleCSVLineProducer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Driver {

  public static void main(String[] args) throws FileNotFoundException{
    BlockingQueue<AbstractCSVLine> sharedCourseLineBuffer = new LinkedBlockingDeque<>();
    BlockingQueue<AbstractCSVLine> sharedStudentVleLinesBuffer = new LinkedBlockingDeque<>();

    FileReader courses = new FileReader("./dataset/courses.csv");
    FileReader dummyData = new FileReader("./dataset/dummyData.csv");

    CSVLineProducer coursesCSVLineProducer = new CoursesCSVLineProducer(sharedCourseLineBuffer, courses);
    new Thread(coursesCSVLineProducer).start();
    CSVLineProducer studentVleCSVLineProducer = new StudentVleCSVLineProducer(sharedStudentVleLinesBuffer,
        dummyData);
    new Thread(studentVleCSVLineProducer).start();

//    Thread c = new Thread(new Consumer(shared_buffer));
  }
}
