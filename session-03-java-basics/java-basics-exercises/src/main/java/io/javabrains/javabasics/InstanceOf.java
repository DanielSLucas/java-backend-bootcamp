package io.javabrains.javabasics;

public class InstanceOf {

    public static void main(String[] args) {

        Object[] objects = {
                10,
                "Hello",
                true,
                20.5
        };

        // Challenge: Use instanceof to determine the type of each object in the array
        for (Object object : objects) {
            if (object instanceof Integer) {
                System.out.println(object + " is an Integer");
            } else if (object instanceof String) {
                System.out.println(object + " is an String");
            } else if (object instanceof Boolean) {
                System.out.println(object + " is an Boolean");
            } else if (object instanceof Double) {
                System.out.println(object + " is an Double");
            }
        }
    }
}
