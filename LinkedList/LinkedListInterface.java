public interface LinkedListInterface<E> {

  // Returns number of data elements in list
  int size();

  // Returns true if empty
  boolean isEmpty();

  // Returns the value of the nth item
  E get(int index);

  // Adds an item to the front of the list
  void addFront(E item);

  // Remove front item and return its value
  E popFront();

  // Adds an item at the end
  void add(E item);

  // Removes end item and returns its value
  E popBack();

  // Get value of front item
  E front();

  // Get value of end item
  E back();

  // Insert value at index
  void insert(E item, int index);

  // Removes node at given index
  void erase(int index);

  // Returns the value of the node at nth position from the end of the list
  E getNFromEnd(int n);

  // Reverses the list
  void reverse();

  // Removes the first item in the list with this value
  void removeValue(E item);

}
