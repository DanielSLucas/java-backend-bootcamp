package io.javabrains.javacollections;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
  public static void main(String[] args) {
    NavigableSet<LocalDateTime> appointments = new TreeSet<>();

    appointments.add(LocalDateTime.of(2023, 03, 04, 10, 30));
    appointments.add(LocalDateTime.of(2023, 03, 04, 11, 00));
    appointments.add(LocalDateTime.of(2023, 03, 04, 11, 30));
    appointments.add(LocalDateTime.of(2023, 03, 04, 12, 00));

    LocalDateTime nextAppt = appointments.ceiling(LocalDateTime.of(2023, 03, 04, 10, 45));

    System.out.println("nextAppt = " + nextAppt);

  }
}
