package concurrentSolution.producers;

import com.opencsv.CSVReader;
import concurrentSolution.dataClasses.AbstractCSVLine;

import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

public abstract class CSVLineProducer implements Runnable {

  protected BlockingQueue<AbstractCSVLine> buffer;
  protected FileReader csvFile;
  protected final Integer MAX_CAPACITY = 10;

  public CSVLineProducer(BlockingQueue<AbstractCSVLine> buffer, FileReader csvFile) {
    this.buffer = buffer;
    this.csvFile = csvFile;
  }

  abstract AbstractCSVLine createCSVLineObject(final String[] line);

  protected void produce(AbstractCSVLine line) throws InterruptedException {
    synchronized (buffer) {
      while (buffer.size() == MAX_CAPACITY) {
        System.out.println("Buffer is full " + Thread.currentThread().getName() + " is waiting, size " + buffer.size());
        buffer.wait();
      }
      Thread.sleep(2000);
      buffer.put(line);
      System.out.println("Produced: " + line);
      buffer.notifyAll();
    }
  }

  @Override
  public void run() {
    String[] line;
    try (CSVReader reader = new CSVReader(csvFile)) {
      reader.skip(1); //skip header
      while ((line = reader.readNext()) != null) {
        try {
          produce(createCSVLineObject(line));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
