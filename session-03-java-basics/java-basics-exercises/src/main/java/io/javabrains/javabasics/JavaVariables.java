package io.javabrains.javabasics;

public class JavaVariables {

    public static void main(String[] args) {
        // Step 1: Declare and initialize variables of different data types
        
        // int variable to store an integer value
        int x = 1;
        
        // long variable to store a long value
        long y = 1234567890L;
        
        // float variable to store a floating-point value
        float pi = 3.14f;

        // double variable to store a double value
        double morePricePi = 3.1415;

        // char variable to store a single character
        char a = 'a';

        // boolean variable to store a boolean value
        boolean isTrue = true;

        // String variable to store a string of characters
        String word = "word";

        // Step 2: Print the values of the variables to the console
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("pi = " + pi);
        System.out.println("morePricePi = " + morePricePi);
        System.out.println("a = " + a);
        System.out.println("isTrue = " + isTrue);
        System.out.println("word = " + word);

        // Step 3: Modify the values of the variables and print the updated values
        x = 2;
        y = 9876543210L;
        pi = 3.1415f;
        morePricePi = 3.141516;
        a = 'b';
        isTrue = false;
        word = "WOOORD";

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("pi = " + pi);
        System.out.println("morePricePi = " + morePricePi);
        System.out.println("a = " + a);
        System.out.println("isTrue = " + isTrue);
        System.out.println("word = " + word);
    }
}
