package io.javabrains.javacollections;

import java.util.ArrayList;
import java.util.List;

/*
Initialize an ArrayList, set the value to a few integers
Then write code to find the sum of all integers
 */

public class ListExercise {

    public static void main(String[] args) {
        List<Integer> nums =  new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        System.out.println("nums = " + nums);

        int sum = nums.stream().mapToInt(e -> e).sum();

        System.out.println("sum of nums = " + sum);
    }

}
