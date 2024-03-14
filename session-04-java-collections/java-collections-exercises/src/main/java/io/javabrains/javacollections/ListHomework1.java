package io.javabrains.javacollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Create a Java program that allows a user to perform various operations on an ArrayList of integers.
The program should display a menu of options, and the user should be able to select one of the following operations:

1. Add an element to the list
2. Remove an element from the list
3. Find the minimum element in the list
4. Find the maximum element in the list
5. Print the contents of the list
6. Quit the program

The program should continue to display the menu and allow the user to perform operations until they choose to quit.
*/

public class ListHomework1 {
  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);

    int opt = 0;

    while (opt != 6) {
      System.err.println("1. Add an element to the list");
      System.err.println("2. Remove an element from the list");
      System.err.println("3. Find the minimum element in the list");
      System.err.println("4. Find the maximum element in the list");
      System.err.println("5. Print the contents of the list");
      System.err.println("6. Quit the program");
      
      opt = keyboard.nextInt();
      keyboard.nextLine();

      if (opt == 1) {
        System.out.print("Type a number to add: ");

        int num = keyboard.nextInt();
        keyboard.nextLine();
        
        nums.add(num);
        
        System.out.println("Num '" + num + "' added");
        continue;
      }

      if (opt == 2) {
        System.out.print("Type a number to remove: ");
        Integer num = keyboard.nextInt();
        keyboard.nextLine();
        
        nums.remove(num);

        System.out.println("Num '" + num + "' removed");
        continue;
      }

      if (opt == 3) {
        int min = nums.stream().mapToInt(n -> n).min().getAsInt();

        System.out.println("The minimum element in the list is " + min);
        
        continue;
      }

      if (opt == 4) {
        int max = nums.stream().mapToInt(n -> n).max().getAsInt();

        System.out.println("The maximum element in the list is " + max);
        
        continue;
      }

      if (opt == 5) {
        System.out.println("The list " + nums);
        
        continue;
      }
    }
    
    keyboard.close();
  }
}
