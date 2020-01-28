package concurrentSolution.producers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class CSVLineProducer implements Runnable {

  protected BlockingQueue<String> buffer;
  protected FileReader csvFile;

  public CSVLineProducer(BlockingQueue<String> buffer, FileReader csvFile) {
    this.buffer = buffer;
    this.csvFile = csvFile;
  }

  protected void produce(String line) throws InterruptedException {
    buffer.put(line);
  }

  @Override
  public void run() {
    String line;
    try (BufferedReader reader = new BufferedReader(csvFile)){
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        try {
          produce(line);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      while (true) {
        try {
          buffer.put("Poison");
          break;
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
