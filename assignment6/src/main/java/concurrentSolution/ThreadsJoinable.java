package concurrentSolution;

import java.util.List;

public interface ThreadsJoinable {

  static void joinThreads(List<Thread> threads) throws InterruptedException {
    for (Thread thread: threads) {
      thread.join();
    }
  }
}
