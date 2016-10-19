// Using linear probing
public class HashTable<K, V> implements HashTableInterface<K, V> {

  HashEntry[] array;

  public HashTable(int size) {
    array = new HashEntry[size];
  }

  private int hash(K key) {
    int hash = key.hashCode() % array.length;
    if (hash < 0) {
        return hash + array.length;
    }
    return hash;
  }

  @Override
  public void add(K key, V value) {
    HashEntry entry = new HashEntry(key, value);
    int hash = hash(key);
    int i = hash;
    do {
      if (array[i] == null) {
        array[i] = entry;
      } else if (array[i].key.equals(key)) {
        array[i].value = value;
      } else {
        i = (i + 1) % array.length;
      }
    } while (i != hash);
  }

  @Override
  public boolean exists(K key) {
    return getHelper(key) != null;
  }

  @Override
  public V get(K key) {
    HashEntry<K, V> entry = getHelper(key);
    if (entry != null) {
      return entry.value;
    }
    return null;
  }

  @Override
  public void remove(K key) {
    int hash = hash(key);
    int i = hash;
    do {
      if (array[i] != null && array[i].key.equals(key)) {
        array[i] = null;
      } else {
        i = (i + 1) % array.length;
      }
    } while (i != hash);
  }

  private HashEntry<K, V> getHelper(K key) {
    int hash = hash(key);
    int i = hash;
    do {
      if (array[i] != null && array[i].key.equals(key)) {
        return array[i];
      } else {
        i = (i + 1) % array.length;
      }
    } while (i != hash);
    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < array.length-1; i++) {
      if (array[i] != null) {
        sb.append(array[i]);
      }
    }
    if (array[array.length - 1] != null) {
      sb.append(array[array.length - 1]);
    }
    sb.append("]");
    return sb.toString();
  }

  private class HashEntry<K, V> {
    K key;
    V value;

    HashEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "{" + key + ", " + value + "}";
    }
  }
  
}
