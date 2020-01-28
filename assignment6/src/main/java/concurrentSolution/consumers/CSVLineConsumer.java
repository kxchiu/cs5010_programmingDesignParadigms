package concurrentSolution.consumers;

import java.util.concurrent.BlockingQueue;

public abstract class CSVLineConsumer implements Runnable {

  protected final BlockingQueue<String> buffer;

  public CSVLineConsumer(BlockingQueue<String> buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
      while (true) {
        try {
          String line = buffer.take();
          if (line.equals("Poison")) {
            buffer.add("Poison");
            break;
          }
          consume(line);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
    }
  }

  abstract void consume(String line) throws InterruptedException;
}
