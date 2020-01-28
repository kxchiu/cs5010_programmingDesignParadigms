package Part2;

import Part3.HighActivity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
  public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    // Object of a class that has both produce()
    // and consume() methods
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    Producer producer =
        new Producer(
            queue,
            20,
            "/Users/Jocelyn_Ma/group_kxciu1217_bobabar_liaiwu/Assignment5/dummyData.csv",
            1000);
    Thread produce = new Thread(producer);

    produce.start();

    HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
    Consumer cons1 = new Consumer(queue, map, 1000);
    Consumer cons2 = new Consumer(queue, map, 1000); // test2

    Thread consume1 = new Thread(cons1);
    Thread consume2 = new Thread(cons2); // test2

    // Start all threads
    consume1.start();
    consume2.start();

    // produce ends first, then consume1, consume2 so on.

    produce.join();
    consume1.join();
    consume2.join();

    // DUMP
    HashMap<String, HashMap<Integer, Integer>> sumClicks = map;
    for (String name : sumClicks.keySet()) {
      String key = name.toString();
      String value = sumClicks.get(name).toString();
      System.out.println(key + " " + value);
    }
    Writer writer = new Writer();
    writer.getCourse(sumClicks);

    HighActivity highActivity = new HighActivity(map, 10);
  }
}
