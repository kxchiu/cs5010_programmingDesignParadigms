package Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer implements Runnable {
  private BlockingQueue<String> blockingQueue;
  private int capacity;
  private String fileName;
  private int interval;

  public Producer(
      BlockingQueue<String> blockingQueue, int capacity, String fileName, int sleepInterval) {
    this.blockingQueue = blockingQueue;
    this.capacity = capacity;
    this.fileName = fileName;
    this.interval = sleepInterval;
  }

  public void run() {

    String line;
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
      bufferedReader.readLine();
      int value = 0;
      while ((line = bufferedReader.readLine()) != null) {
        synchronized (this) {
          if (blockingQueue.contains(line)) {
            continue;
          }
          // producer thread waits while list
          // is full
          while (blockingQueue.size() >= capacity) {
            try {
              System.out.println("waiting--P---");
              wait(1000);

            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("Producer produced-" + value + " " + line);

          // to insert the jobs in the list
          blockingQueue.add(line);
          value++;

          // notifies the consumer thread that
          // now it can start consuming
          notifyAll();
        }
      }
      if (line == null) {
        blockingQueue.add("stop");
      }

    } catch (IOException e) {
      Thread.currentThread().interrupt();
      System.out.println("Problem reading the CSV file!");
      e.printStackTrace();
    }
  }

  public BlockingQueue<String> getBlockingQueue() {
    return this.blockingQueue;
  }
}
