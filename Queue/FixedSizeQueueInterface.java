public interface FixedSizeQueueInterface<E> {

  // Adds value at end of available storage
  void enqueue(E value);

  // Returns value and removes least recently added element
  E dequeue();

  boolean isEmpty();

  boolean isFull();

}
