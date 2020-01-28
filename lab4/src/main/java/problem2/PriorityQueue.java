package problem2;

public interface PriorityQueue<E extends
    Comparable<E>> {

  void insert(E e);

  E remove() throws EmptyPriorityQueueException;

  E front() throws EmptyPriorityQueueException;

  boolean isEmpty();


}
