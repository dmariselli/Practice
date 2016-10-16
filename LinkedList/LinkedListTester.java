public class LinkedListTester {

  public static void main(String[] args) {
    System.out.println("Add to front: " + addToFrontTest());
    System.out.println("Add to back: " + addToBackTest());
    System.out.println("Remove from front: " + removeFromFrontTest());
    System.out.println("Remove from back: " + removeFromBackTest());
    System.out.println("Get front: " + getFrontTest());
    System.out.println("Get back: " + getBackTest());
    System.out.println("Add after empty: " + addAfterEmptyTest());
    System.out.println("Reverse list: " + reverseTest());
    System.out.println("Insert into list: " + insertTest());
    System.out.println("Erase an index entry: " + eraseTest());
    System.out.println("Get N from end of list: " + getNFromEndTest());
  }

  public static boolean addToFrontTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.addFront(i);
    }
    boolean test = true;
    for (int i = 9; i >= 0; i--) {
      test &= (list.get(i) == 9-i);
    }
    return test && (list.size == 10) && (!list.isEmpty());
  }

  public static boolean addToBackTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    boolean test = true;
    for (int i = 0; i < 10; i++) {
      test &= (list.get(i) == i);
    }
    return test && (list.size == 10) && (!list.isEmpty());
  }

  public static boolean removeFromFrontTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    boolean test = true;
    for (int i = 0; i < 10; i++) {
      test &= (list.popFront() == i);
    }
    return test && (list.size == 0) && (list.isEmpty());
  }

  public static boolean removeFromBackTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    boolean test = true;
    for (int i = 0; i < 10; i++) {
      test &= (list.popBack() == 9-i);
    }
    return test && (list.size == 0) && (list.isEmpty());
  }

  public static boolean getFrontTest() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    return list.front() == 1;
  }

  public static boolean getBackTest() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    return list.back() == 2;
  }

  public static boolean addAfterEmptyTest() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    boolean test = (list.size() == 1);
    list.popBack();
    test &= (list.size() == 0) && (list.isEmpty());
    list.add(2);
    test &= (list.size() == 1) && (!list.isEmpty() && (list.get(0) == 2));
    return test;
  }

  public static boolean reverseTest() {
    LinkedList<Integer> list = new LinkedList<>();
    boolean test = true;
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    list.reverse();
    for (int i = 9; i >= 0; i--) {
      test &= (list.get(9-i) == i);
    }
    return test;
  }

  public static boolean insertTest() {
    LinkedList<Integer> list = new LinkedList<>();
    list.insert(1, 0);
    list.insert(2, 0);
    list.insert(3, 1);
    return (list.get(0) == 2) && (list.get(1) == 3) && (list.get(2) == 1);
  }

  public static boolean eraseTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    list.erase(4);
    return (list.get(3) == 3) && (list.get(4) == 5) && (list.size() == 9);
  }

  public static boolean getNFromEndTest() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    return (list.getNFromEnd(3) == 6) && (list.getNFromEnd(8) == 1);
  }

}
