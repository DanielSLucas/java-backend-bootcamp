package io.javabrains.functionaljava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsDemo {
  public static void main(String[] args) throws IOException {
    // .stream() api
    List<String> names = List.of("Foo", "Bar", "Baz");
    Stream<String> stream = names.stream();
    stream.forEach(System.out::println);

    // Array
    int[] numbers = { 1, 2, 3, 4, 5};
    Arrays.stream(numbers).forEach(System.out::println);

    // Stream.of
    Stream
      .of("mango", "banana", "strawberry")
      .forEach(System.out::println);

    // Built in APIs that return stream
    Stream<String> lines = Files.lines(Paths.get("test.txt"));
    lines.forEach(System.out::println);
    lines.close();

    // Stream.generate
    Stream
      .generate(new Random()::nextDouble)
      .limit(10)
      .forEach(System.out::println);

    // Strem.iterate
    Stream
      .iterate(0, x -> x + 2)
      .limit(10)
      .forEach(System.out::println);
  }
}
