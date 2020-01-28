package concurrentSolution;

import concurrentSolution.consumers.AssessmentCSVLineConsumer;
import concurrentSolution.consumers.CoursesCSVLineConsumer;
import concurrentSolution.consumers.StudentVleCSVLineConsumer;
import concurrentSolution.producers.CSVLineProducer;
import concurrentSolution.writer.Writer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Driver {

  private static final Integer MAX_BUFFER_SIZE = 100;
  private static final Integer CONSUMER_COUNT = 50;

  private static String ouladDirectory; // A string for OULAD directory

  public static void main(String[] args)
      throws IOException, InterruptedException, ParseException {
    // Dummy args for self-checking purpose.
    //  (uncomment the following line when you want to run the Driver directly)
    args = new String[]{"-inputdir", "anonymisedData", "-assessment", "assessments.csv",
        "-courses", "courses.csv", "-studentVle", "studentVle.csv", "-highActivityThreshold", "1000"};

    // Create Options object and add options.
    Options options = new Options();
    for (EnumCommandLineArgumentOptions option: EnumCommandLineArgumentOptions.values()) {
      options.addOption(
          Option.builder()
              .required(option.getRequired())
              .longOpt(option.getArgument())
              .argName(option.getArgument())
              .hasArg(option.getHasArgument())
              .numberOfArgs(option.getNumberOfArguments())
              .valueSeparator(option.getValueSeparator())
              .desc(option.getDescription())
              .build()
      );
    }

    // Parse the command line.
    // If all options are present, we process the files.
    CommandLine cmd = new DefaultParser().parse(options, args);

    ouladDirectory = cmd.getOptionValue(EnumCommandLineArgumentOptions.INPUT_DIRECTORY.getArgument());
    String assessmentCSVFilename = cmd.getOptionValue(EnumCommandLineArgumentOptions.ASSESSMENT.getArgument());
    String coursesCSVFilename = cmd.getOptionValue(EnumCommandLineArgumentOptions.COURSES.getArgument());
    String studentVleCSVFilename = cmd.getOptionValue(EnumCommandLineArgumentOptions.STUDENTVLE.getArgument());

    // SET UP COURSES.CSV
    BlockingQueue<String> sharedCourseLineBuffer = new ArrayBlockingQueue<>(MAX_BUFFER_SIZE);
    Thread courseProducerThread = new Thread(new CSVLineProducer(sharedCourseLineBuffer,
        new FileReader(configureFilePath(coursesCSVFilename))));

    // SET UP STUDENTVLE.CSV
    BlockingQueue<String> sharedStudentVleLinesBuffer = new ArrayBlockingQueue<>(MAX_BUFFER_SIZE);
    Thread studentProducerThread = new Thread(new CSVLineProducer(sharedStudentVleLinesBuffer,
        new FileReader(configureFilePath(studentVleCSVFilename))));

    // SET UP ASSESSMENT.CSV
    BlockingQueue<String> sharedAssessmentLineBuffer = new ArrayBlockingQueue<>(MAX_BUFFER_SIZE);
    Thread assessmentProducerThread = new Thread(new CSVLineProducer(sharedAssessmentLineBuffer,
        new FileReader(configureFilePath(assessmentCSVFilename))));

    // Start counting time when the threads start.
    long startTime = System.nanoTime();

    studentProducerThread.start();
    courseProducerThread.start();
    assessmentProducerThread.start();

    // DATABASE
    ConcurrentMap<String, Integer> courseLengthPairs = new ConcurrentHashMap<>();
    ConcurrentMap<String, Map<Integer, String>> courseAssessments = new ConcurrentHashMap<>();
    ConcurrentMap<String, Integer> courseTotalClicks = new ConcurrentHashMap<>();
    ConcurrentMap<String, ConcurrentMap<Integer, Integer>> clicksCompressed = new ConcurrentHashMap<>();

    // Build consumer threads and run.
    List<Thread> studentConsumersThreads = buildStudentConsumersThreads(sharedStudentVleLinesBuffer, clicksCompressed, courseTotalClicks);
    List<Thread> courseConsumerThreads = buildCourseConsumerThreads(sharedCourseLineBuffer, courseLengthPairs);
    List<Thread> assessmentConsumerThreads = buildAssessmentConsumerThreads(sharedAssessmentLineBuffer, courseAssessments);

    // Join the producer and consumer threads when finished.
    courseProducerThread.join();
    assessmentProducerThread.join();
    studentProducerThread.join();

    ThreadsJoinable.joinThreads(courseConsumerThreads);
    ThreadsJoinable.joinThreads(assessmentConsumerThreads);
    ThreadsJoinable.joinThreads(studentConsumersThreads);

    // Use Writer to output the processed data.
    Writer writer = new Writer(courseLengthPairs, courseAssessments, clicksCompressed, courseTotalClicks);
    writer.writeSummary();

    Integer highActivityThreshold =
        new Integer(cmd.getOptionValue(EnumCommandLineArgumentOptions.HIGH_ACTIVITY.getArgument()));
    writer.writeHighActivitySummary(highActivityThreshold);


    // Print time to complete the program.
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000;
    System.out.println("It took " + duration + " ms to finish the program.");
  }

  private static String configureFilePath(String filename) {
    return ouladDirectory + File.separator + filename;
  }

  private static List<Thread> buildCourseConsumerThreads(BlockingQueue<String> sharedCourseLineBuffer,
                                                         Map<String, Integer> courseLengthPairs) {
    List<Thread> threadList = new ArrayList<>();
    for (int i = 0; i < CONSUMER_COUNT; i++) {
      Thread thread = new Thread(new CoursesCSVLineConsumer(sharedCourseLineBuffer, courseLengthPairs));
      threadList.add(thread);
      thread.start();
    }
    return threadList;
  }

  private static List<Thread> buildStudentConsumersThreads(BlockingQueue<String> sharedStudentVleLinesBuffer,
                                                           ConcurrentMap<String, ConcurrentMap<Integer, Integer>> clicksCompressed,
                                                           ConcurrentMap<String, Integer> courseTotalClicks) {
    List<Thread> threadList = new ArrayList<>();
    for (int i = 0; i < CONSUMER_COUNT; i++) {
      Thread thread = new Thread(new StudentVleCSVLineConsumer(sharedStudentVleLinesBuffer, clicksCompressed, courseTotalClicks));
      threadList.add(thread);
      thread.start();
    }
    return threadList;
  }

  private static List<Thread> buildAssessmentConsumerThreads(BlockingQueue<String> sharedAssessmentLineBuffer, ConcurrentMap<String, Map<Integer, String>> courseAssessments) {
    List<Thread> threadList = new ArrayList<>();
    for (int i = 0; i < CONSUMER_COUNT; i++) {
      Thread thread = new Thread(new AssessmentCSVLineConsumer(sharedAssessmentLineBuffer, courseAssessments));
      threadList.add(thread);
      thread.start();
    }
    return threadList;
  }

  /**
   * Returns the index of the given pattern String as Int.
   * @param patternString the given pattern String
   * @param args the given arguments
   * @return the index of the given pattern String
   */
  private static int indexOfArg(String patternString, String[] args) {
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher;
    for (int i = 0; i < args.length; i++) {
      matcher = pattern.matcher(args[i]);
      if (matcher.find()) {
        return i;
      }
    }
    return -1;
  }
}
