package com.daniellucas;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class Main {
    public static void main(String[] args) {
        Bag<String> bag = new HashBag<>();

        HelloWorld hw = new HelloWorld();
        String msg = hw.getMessage();

        bag.add(msg, 10);

        System.out.println(bag);
    }
}