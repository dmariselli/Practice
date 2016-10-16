public class VectorTester {

  public static void main(String[] args) {
    System.out.println("Adding Values: " + addTest());
    System.out.println("Add and Resize: " + addResizeTest());
    System.out.println("Remove Values: " + removeTest());
    System.out.println("Remove and Resize: " + removeResizeTest());
    System.out.println("isEmpty: " + isEmptyTest());
    System.out.println("Prepend Values: " + prependTest());
    System.out.println("Inserting Values: " + insertionTest());
  }

  public static boolean addTest() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 16; i++) {
      vector.add(i);
    }
    return  (vector.size() == 16) && (vector.capacity() == 16) &&
            (vector.get(0) == 0) && (vector.get(15) == 15);
  }

  public static boolean addResizeTest() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 16; i++) {
      vector.add(i);
    }
    vector.add(17);
    return (vector.size() == 17) && (vector.capacity() == 32);
  }

  public static boolean removeTest() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 16; i++) {
      vector.add(i);
    }
    boolean test = (vector.size() == 16) && (vector.capacity == 16);
    vector.remove(14);
    return test && (vector.get(14) == 15);
  }

  public static boolean removeResizeTest() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 5; i++) {
      vector.add(i);
    }
    boolean test = (vector.size() == 5) && (vector.capacity == 16);
    vector.pop();
    return test && (vector.size() == 4) && (vector.capacity == 8);
  }

  public static boolean isEmptyTest() {
    Vector<Integer> vector = new Vector<>();
    boolean test = vector.isEmpty();
    vector.add(1);
    test &= (vector.isEmpty() == false);
    vector.remove(1);
    return test && (vector.isEmpty());
  }

  public static boolean prependTest() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 5; i++) {
      vector.add(i);
    }
    vector.prepend(20);
    return (vector.get(0) == 20) && (vector.size() == 6);
  }

  public static boolean insertionTest() {
    Vector<Integer> vector = new Vector<>();
    boolean test = false;
    vector.add(20, 0);  
    try {
      vector.add(40, 2);
    } catch (IndexOutOfBoundsException e) {
      test = true;
    }
    vector.add(40, 0);
    return test && (vector.get(0) == 40) && (vector.get(1) == 20);
  }
}
