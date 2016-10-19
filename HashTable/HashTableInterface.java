public interface HashTableInterface<K, V> {

  // If key already exists, update value
  void add(K key, V value);

  boolean exists(K key);

  V get(K key);

  void remove(K key);

}
