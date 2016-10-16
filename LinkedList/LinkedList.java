public class LinkedList<E> implements LinkedListInterface<E> {

  Node<E> head;
  Node<E> tail;
  int size;

  public LinkedList() {
    size = 0;
    head = new Node<>();
    tail = new Node<>();
    head.next = tail;
    tail.back = head;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public E get(int index) {
    rangeCheck(index);
    Node<E> node = head.next;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node.value;
  }

  @Override
  public void addFront(E value) {
    Node<E> node = new Node<>(value);
    addHelper(head, node, head.next);
    size++;
  }

  @Override
  public E popFront() {
    Node<E> node = head.next;
    removeHelper(head, head.next.next);
    size--;
    return node.value;
  }

  @Override
  public void add(E value) {
    Node<E> node = new Node<>(value);
    addHelper(tail.back, node, tail);
    size++;
  }

  @Override
  public E popBack() {
    Node<E> node = tail.back;
    removeHelper(tail.back.back, tail);
    size--;
    return node.value;
  }

  @Override
  public E front() {
    return head.next.value;
  }

  @Override
  public E back() {
    return tail.back.value;
  }

  @Override
  public void insert(E value, int index) {
    rangeCheckForAdd(index);
    Node<E> node = new Node<>(value);
    Node<E> current = head.next;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    addHelper(current.back, node, current);
    size++;
  }

  @Override
  public void erase(int index) {
    rangeCheck(index);
    Node<E> node = head.next;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    removeHelper(node.back, node.next);
    size--;
  }

  @Override
  public E getNFromEnd(int n) {
    rangeCheck(n);
    Node<E> node = tail.back;
    for (int i = 0; i < n; i++) {
      node = node.back;
    }
    return node.value;
  }

  @Override
  public void reverse() {
    if (size > 1) {
      Node<E> current = head.next;
      Node<E> follow = current.next;
      for (int i = 0; i < size; i++) {
        removeHelper(current.back, current.next);
        addHelper(head, current, head.next);
        current = follow;
        follow = current.next;
      }
    }
  }

  @Override
  public void removeValue(E value) {
    Node<E> node = head.next;
    while (node != null) {
      if (node.value == value) {
        removeHelper(node.back, node.next);
        size--;
        break;
      }
      node = node.next;
    }
  }

  private void addHelper(Node<E> left, Node<E> middle, Node<E> right) {
    left.next = middle;
    middle.back = left;
    middle.next = right;
    right.back = middle;
  }

  private void removeHelper(Node<E> left, Node<E> right) {
    left.next = right;
    right.back = left;
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

  @Override
  public String toString() {
    if (isEmpty()) {
      return "[]";
    } else if (size == 1) {
      return "[" + head.next.value + "]";
    }
    StringBuilder sb = new StringBuilder();
    Node<E> node = head.next;
    sb.append("[");
    for (int i = 0; i < size - 1; i++) {
      sb.append(node.value);
      sb.append(", ");
      node = node.next;
    }
    sb.append(node.value);
    sb.append("]");
    return sb.toString();
  }

  // Node class
  private class Node<E> {
    E value;
    Node<E> back;
    Node<E> next;

    Node() {}

    Node(E value) {
      this.value = value;
    }
  }

}
