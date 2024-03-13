package io.javabrains.javacollections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
  public static void main(String[] args) {
    SortedSet<String> vocab = new TreeSet<>();

    vocab.add("mango");
    vocab.add("banana");
    vocab.add("pineapple");
    vocab.add("apple");

    String first = vocab.first();
    String last = vocab.last();

    System.out.println(vocab.headSet("mango"));
    System.out.println(vocab.tailSet("mango"));

    // vocab.subSet(first, last);
    System.out.println("vocab = " + vocab);
    System.out.println("first = " + first);
    System.out.println("last = " + last);
  }
}
