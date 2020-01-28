package problem1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import problem1.Queue;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class QueueTest {

  Queue<Integer> queue;

  @Before
  public void setUp() throws Exception {
    queue = (Queue<Integer>) new LinkedList<Integer>();
  }

  @After
  public void tearDown() throws Exception {
    queue = null;
    assertNull(queue);
  }

  @Test
  public void enqueue() {
    queue.enqueue(1);
    assertEquals(queue.dequeue(), 1);
  }

  @Test
  public void dequeue() {
    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(queue.dequeue(), 1);
    assertEquals(queue.dequeue(), 2);
  }

  @Test
  public void front() {
    queue.enqueue(1);
    assertEquals(java.util.Optional.ofNullable(queue.front()), 1);
  }
}