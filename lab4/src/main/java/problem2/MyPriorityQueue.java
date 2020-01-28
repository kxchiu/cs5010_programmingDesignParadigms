package problem2;

import java.util.Queue;

public class MyPriorityQueue<E extends
    Comparable<E>> implements PriorityQueue{

  private Comparable[] pQueue;
  private int index;

  public MyPriorityQueue(int capacity) {
    pQueue = new Comparable[capacity];
  }
  @Override
  public void insert(Comparable comparable) {
    if(index == pQueue.length){
      System.out.println("The priority queue is full.");

      //resizing
      Comparable[] q = new Comparable[pQueue.length * 2];
      for (int i = 0; i < pQueue.length; i++) {
        q[i] = pQueue[i];
      }
      this.pQueue = q;
    }
    pQueue[index] = comparable;
    index++;
    System.out.println("Inserting: "+ comparable);
  }

  @Override
  public Comparable remove() throws EmptyPriorityQueueException {

    this.empty();
    int maxIndex = 0;

    // find the index of the item with the highest priority
    for (int i=1; i<index; i++) {
      if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) {
        maxIndex = i;
      }
    }
    Comparable result = pQueue[maxIndex];
    System.out.println("removing: "+result);
    // move the last item into the empty slot
    index--;
    pQueue[maxIndex] = pQueue[index];
    return result;
  }

  @Override
  public Comparable front() throws EmptyPriorityQueueException {
    this.empty();

    return pQueue[0];
  }

  @Override
  public boolean isEmpty() {
    return index == 0;
  }

  public void empty() throws EmptyPriorityQueueException {
    if(this.isEmpty()){
      System.out.println("The priority queue is empty.");
      throw new EmptyPriorityQueueException("The priority queue is empty.");
    }
  }
}
