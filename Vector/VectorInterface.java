public interface VectorInterface<E> {
  
  // Returns the number of items
  int size();

  // Returns the number of items it can hold without expanding
  int capacity();

  boolean isEmpty();

  // Returns item at given index, throws exception if out of range
  E get(int index);

  void add(E item);

  // Inserts item at index, shifts that index's value and trailing elements to the right
  void add(E item, int index);

  // Inserts at beginning of vector
  void prepend(E item);

  // Remove from end, return value
  E pop();

  // Delete item at index, shifting all trailing elements left
  void delete(int index);

  // Looks for value and removes the index holding it (even if in multiple places)
  void remove(E item);

  // Looks for value and returns first index with that value, -1 if not found
  int find(E item);

}
