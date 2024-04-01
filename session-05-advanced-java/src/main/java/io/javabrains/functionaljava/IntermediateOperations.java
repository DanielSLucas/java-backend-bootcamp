package io.javabrains.functionaljava;

import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
  public static void main(String[] args) {
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Stream<Integer> limitedStream = numbers.limit(5);
    limitedStream.forEach(System.out::println);


    numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Stream<Integer> evenStream = numbers.filter(num -> num % 2 == 0);
    Stream<Integer> firt2Evens = evenStream.limit(2);
    firt2Evens.forEach(System.out::println);


    numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers
      .limit(2)
      .filter(num -> num % 2 == 0)
      .forEach(System.out::println);


    Stream<String> names = Stream.of("apple", "banana", "mango", "strawberry");
    Stream<String> stringStream = names
      .map(String::toUpperCase)
      .peek(str -> System.out.println("Peek result: " + str))
      .filter(name -> name.length() < 6);
    
    System.out.println("Nothing of.peek printed so far");
    List<String> namesProcessed = stringStream.toList(); // need to call a terminal operation so the stream starts!
    // this happens due to the lazyness of the streams
    System.out.println(".peek printed!");


    numbers = Stream.of(1, 2, 9, 8, 3, 6, 4, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers
      .distinct() // remove duplicates
      .peek(System.out::println)
      .sorted() // sort the elements, but only when the stream is ended, 
      // it needs to consume the entire stream to be able to sort it
      .forEach(System.out::println);


    Stream<Integer> oddNumbers = Stream.of(1, 3, 5, 7, 9);
    Stream<Integer> evenNumbers = Stream.of(0, 2, 4, 6, 8);
    Stream.concat(evenNumbers, oddNumbers).forEach(System.out::println);


    Stream<Student> studentStream = Stream.of(
      new Student(1, "Foo"),
      new Student(2, "Bar"),
      new Student(3, "A")
    );

    List<String> studentNames = studentStream
      .filter(s -> s.getName().length() > 2)
      .map(Student::getName)
      .toList();

    System.out.println("studentNames = " + studentNames);
  }
}

class Student {
  int id;
  String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
