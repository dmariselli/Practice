public class HashTableTester {

  public static void main(String[] args) {
    System.out.println("Adding with Replacement: " + simpleAddTest());
    System.out.println("Adding with Probing: " + complexAddTest());
    System.out.println("Get value: " + getTest());
    System.out.println("Remove: " + removeTest());
  }

  public static boolean simpleAddTest() {
    HashTable<Integer, Integer> ht = new HashTable<>(5);
    ht.add(1, 1);
    boolean test = ht.get(1) == 1;
    ht.add(1, 2);
    test &= ht.get(1) == 2;
    return test;
  }

  public static boolean complexAddTest() {
    HashTable<Integer, Integer> ht = new HashTable<>(5);
    boolean test = true;
    for (int i = 1; i < 6; i++) {
      ht.add(i, i);
      test &= ht.exists(i);
    }
    ht.add(6, 6);
    test &= !ht.exists(6);
    return test;
  }

  public static boolean getTest() {
    HashTable<String, String> ht = new HashTable<>(5);
    ht.add("Number", "One");
    boolean test = ht.exists("Number");
    test &= ht.get("Number") == "One";
    return test;
  }

  public static boolean removeTest() {
    HashTable<String, String> ht = new HashTable<>(5);
    ht.add("Number", "One");
    boolean test = ht.exists("Number");
    ht.remove("Number");
    test &= !ht.exists("Number");
    return test;
  }

}
