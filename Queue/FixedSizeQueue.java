public class FixedSizeQueue<E> implements FixedSizeQueueInterface<E>{

  Object[] array;
  int head;
  int tail;
  int size;
  int count;

  public FixedSizeQueue(int size) {
    array = new Object[size];
    head = 0;
    tail = 0;
    count = 0;
    this.size = size;
  }

  @Override
  public void enqueue(E value) {
    if (array[tail] == null) {
      array[tail++] = value;
      if (tail >= size) {
        tail = tail % size;
      }
      count++;
    } else {
      throw new OutOfMemoryError();
    }
  }

  @Override
  public E dequeue() {
    E value = (E) array[head];
    if (value != null) {
      array[head++] = null;
      if (head >= size) {
        head = head % size;
      }
    } else {
      throw new IndexOutOfBoundsException();
    }
    count--;
    return value;
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public boolean isFull() {
    return count == size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < count - 1; i++) {
      sb.append(array[(head+i) % size]);
      sb.append(", ");
    }
    if (count > 0) {
      sb.append(array[(head + (count - 1)) % size]);
    }
    sb.append("]");
    return sb.toString();
  }

  public void debug() {
    for (int i = 0; i < size; i++) {
      System.out.print(array[i]);
    }
    System.out.println();
  }

}
