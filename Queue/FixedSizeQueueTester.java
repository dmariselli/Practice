public class FixedSizeQueueTester {

  public static void main(String[] args) {
    System.out.println("Simple enqueue and dequeue: " + queueTest());
    System.out.println("Complex enqueue and dequeue: " + hardQueueTest());
  }

  public static boolean queueTest() {
    FixedSizeQueue<Integer> queue = new FixedSizeQueue<>(5);
    boolean test;
    for (int i = 1; i < 6; i++) {
      queue.enqueue(i);
    }
    test = queue.isFull();
    for (int i = 1; i < 6; i++) {
      test &= queue.dequeue() == i;
    }
    return test && queue.isEmpty() && ! queue.isFull();
  }

  public static boolean hardQueueTest() {
    FixedSizeQueue<Integer> queue = new FixedSizeQueue<>(5);
    boolean test;
    test = queue.isEmpty();
    queue.enqueue(1);
    queue.enqueue(2);
    test &= queue.dequeue() == 1;
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    test &= queue.dequeue() == 2;
    test &= queue.dequeue() == 3;
    queue.enqueue(7);
    test &= queue.dequeue() == 4;
    test &= queue.dequeue() == 5;
    test &= queue.dequeue() == 6;
    test &= queue.dequeue() == 7;
    return test;
  }

}
