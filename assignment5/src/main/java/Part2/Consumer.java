package Part2;

import concurrentSolution.dataClasses.AbstractCSVLine;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable{
  private BlockingQueue<String> blockingQueue;
  private HashMap<String, HashMap<Integer, Integer>> sumClicks;
  //----
  private Thread worker;
  private final AtomicBoolean running = new AtomicBoolean(false);
  private int interval;


  public Consumer(BlockingQueue<String> blockingQueue, HashMap<String, HashMap<Integer, Integer>> map, int sleepInterval) {
    this.blockingQueue = blockingQueue;
    this.sumClicks = map;
    this.interval = sleepInterval;
  }

  //----
  public void start() {
    worker = new Thread(this);
    worker.start();
  }

  public void stop() {
    running.set(false);
  }

  @Override
  public void run() {
    running.set(true);
    while (running.get()) {
      synchronized (this) {
        // consumer thread waits while list
        // is empty

        if (blockingQueue.contains("stop") && blockingQueue.size() == 1) {
          break;
        }
        while (blockingQueue.size() == 0)
        {
          System.out.println("waiting--C---");
          try {

            wait(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }


        // to retrive the ifrst job in the list
        String info = null;
        try {
          info = blockingQueue.take();
          if (info == "stop") {
            break;
          }
          getClicks(courseInfo(info));
          System.out.println("Consumer consumed-" + info);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }


        // Wake up producer thread
        notifyAll();

        // and sleep

      }
    }
}


  public String[] courseInfo(String line) {
    String[] courseInfo = line.split(",");


    return courseInfo;
  }

  public void getClicks(String[] s) {
    if (!sumClicks.containsKey(s[0] + "_" + s[1])) {
      HashMap<Integer, Integer> codeToDateToClicks = new HashMap<>();
      codeToDateToClicks.put(Integer.parseInt(s[4]), Integer.parseInt(s[5]));
      sumClicks.put(s[0] + "_" + s[1], codeToDateToClicks);
    } else if (!sumClicks.get(s[0] + "_" + s[1]).containsKey(Integer.parseInt(s[4]))) {
      sumClicks.get(s[0] + "_" + s[1]).put(Integer.parseInt(s[4]), Integer.parseInt(s[5]));
    } else {
      int clicks = sumClicks.get(s[0] + "_" + s[1]).get(Integer.parseInt(s[4]));
      sumClicks.get(s[0] + "_" + s[1]).put(Integer.parseInt(s[4]), clicks + Integer.parseInt(s[5]));
    }
  }

  public HashMap<String, HashMap<Integer, Integer>> getSumClicks() {
    return this.sumClicks;
  }
}
