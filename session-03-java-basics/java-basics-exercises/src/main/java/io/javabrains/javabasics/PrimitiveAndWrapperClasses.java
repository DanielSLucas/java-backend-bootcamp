package io.javabrains.javabasics;

public class PrimitiveAndWrapperClasses {
    public static void main(String[] args) {
        // Step 1: Declare primitive variables
        int x = 2;
        boolean isTrue = true;

        // Step 2: Convert primitive variables to wrapper objects
        Integer wrappedInt = x;
        Boolean wrappedBolean = isTrue;

        // Step 3: Print the values of the wrapper objects\
        System.out.println("wrappedInt = " + wrappedInt);
        System.out.println("wrappedBolean = " + wrappedBolean);

        // Step 4: Convert wrapper objects back to primitive variables
        x = wrappedInt;
        isTrue = wrappedBolean;

        // Step 5: Print the values of the primitive variables
        System.out.println("x = " + x);
        System.out.println("isTrue = " + isTrue);
    }
}
