package problem2;

import static org.junit.Assert.*;

public class MyPriorityQueueTest {
  private MyPriorityQueue q;
  @org.junit.Before
  public void setUp() throws Exception {
    q = new MyPriorityQueue(5);
    q.insert(34);
    q.insert(20);
    q.insert(3);
    q.insert(10);
    q.insert(20);
    q.insert(3);
    q.insert(10);
  }

  @org.junit.Test
  public void insert() throws EmptyPriorityQueueException {
    Comparable[] pQueue = new Comparable[5];
    pQueue[0] = 34;
    assertTrue(pQueue[0] == q.front());
  }

  @org.junit.Test
  public void remove() throws EmptyPriorityQueueException {
    Comparable[] pQueue = new Comparable[5];
    pQueue[0] = 34;
    pQueue[1] = 20;
    pQueue[2] = 3;
    assertTrue(q.remove() == pQueue[0]);
  }

  @org.junit.Test
  public void front() throws EmptyPriorityQueueException {
    Comparable[] pQueue = new Comparable[5];
    pQueue[0] = 20;
    pQueue[1] = 3;
    assertTrue(q.front() == pQueue[0]);
  }

  @org.junit.Test
  public void isEmpty() {}

  @org.junit.Test
  public void empty() {}
}