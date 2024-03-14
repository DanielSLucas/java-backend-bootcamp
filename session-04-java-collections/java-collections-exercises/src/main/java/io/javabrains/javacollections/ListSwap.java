package io.javabrains.javacollections;

import java.util.ArrayList;
import java.util.List;

/*
Write a method that accepts a list and two position ints and swaps the elements in the two positions
The method should be generic and accept any List
*/

public class ListSwap {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Daniel");
        names.add("Lucas");
        names.add("Pessoa");
        names.add("Monteiro");
        names.add("Santos");

        swap(names, 2, 4);

        System.out.println(names);
    }

    private static <T> void swap(List<T> list, int position1, int position2) {
        var el1 = list.get(position1);
        var el2 = list.get(position2);

        list.set(position1, el2);
        list.set(position2, el1);
    }
}
