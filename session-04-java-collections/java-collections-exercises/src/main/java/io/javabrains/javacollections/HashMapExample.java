package io.javabrains.javacollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample {
  public static void main(String[] args) {
    Map<Key, Value> myMap = new HashMap<>();

    myMap.put(new Key(1), new Value("Hello"));
    myMap.put(new Key(2), new Value("World"));

    System.out.println("myMap = " + myMap);

    // myMap.keySet(); // set of keys
    // mymap.values(); // collection of values
    for (Map.Entry<Key, Value> keyValueEntry : myMap.entrySet()) {
      System.out.println("keyValueEntry = " + keyValueEntry);
    }
  }
}

class Key {
  private int id;

  public Key(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
      return "Key{" + "id=" + this.id + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    Key other = (Key) obj;
    return this.id == other.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }
}

class Value {
  private String data;

  public Value(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Value{" + "data=" + this.data + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    Value other = (Value) obj;
    return this.data == other.data;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.data);
  }
}