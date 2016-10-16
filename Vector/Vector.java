public class Vector<E> implements VectorInterface<E> {
  Object[] array;
  int size;
  int capacity;

  public Vector() {
    array = new Object[16];
    size = 0;
    capacity = 16;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int capacity() {
    return capacity;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public E get(int index) {
    rangeCheck(index);
    return (E) array[index];
  }

  @Override
  public void add(E item) {
    if (size == capacity) {
      resize(capacity*2);
    }
    array[size++] = item;
  }

  @Override
  public void add(E toAdd, int index) {
    rangeCheckForAdd(index);
    if (size == capacity) {
      insertAndResize(toAdd, index, capacity*2);
    }
    size++;
    for (int i = index; i < size; i++) {
      E item = (E) array[i];
      array[i] = toAdd;
      toAdd = item;
    }
  }

  @Override
  public void prepend(E item) {
    add(item, 0);
  }

  @Override
  public E pop() {
    E item = (E) array[size-1];
    delete(size-1);
    if (size <= (capacity / 4)) {
      resize(capacity / 2);
    }
    return item;
  }

  @Override
  public void delete(int index) {
    rangeCheck(index);
    for (int i = index + 1; i < size; i++) {
      array[i-1] = array[i];
    }
    array[--size] = null;
  }

  @Override
  public void remove(E item) {
    int index = find(item);
    while (index != -1) {
      delete(index);
      index = find(item);
    }
  }

  @Override
  public int find(E item) {
    for (int i = 0; i < size; i++) {
      if (array[i].equals(item)) {
        return i;
      }
    }
    return -1;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void rangeCheckForAdd(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void insertAndResize(E toAdd, int index, int newCapacity) {
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < index; i++) {
      newArray[i] = array[i];
    }
    newArray[index] = toAdd;
    for (int i = index + 1; i < capacity + 1; i++) {
      newArray[i] = array[i];
    }
    capacity = newCapacity;
  }

  private void resize(int newCapacity) {
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
    capacity = newCapacity;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size - 1; i++) {
      sb.append(array[i]);
      sb.append(", ");
    }
    sb.append(array[size - 1]);
    sb.append("]");
    return sb.toString();
  }

}
