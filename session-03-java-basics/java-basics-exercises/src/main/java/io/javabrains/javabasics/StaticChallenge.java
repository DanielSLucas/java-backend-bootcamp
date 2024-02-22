package io.javabrains.javabasics;

/*
Create a class `Rectangle` with the following attributes: `width`, `height`, and a static variable `numOfRectangles` which will keep track of the number of rectangles created.

1.  Create a constructor that takes the width and height as arguments and sets the values of the `width` and `height` instance variables.
2.  Create a method `getArea` that calculates and returns the area of the rectangle.
3.  Create a method `getPerimeter` that calculates and returns the perimeter of the rectangle.
4.  Create a method `getNumOfRectangles` that returns the value of the `numOfRectangles` static variable.
5.  In this main method, create several `Rectangle` objects, calculate and print their area and perimeter, and finally print the number of rectangles created without keeping count in this class.
 */

public class StaticChallenge {

    public static void main(String[] args) {
        Rectangle[] rectangles = {
            new Rectangle(3, 2),
            new Rectangle(4, 2),
            new Rectangle(6, 4),
            new Rectangle(5, 1),
            new Rectangle(7, 3)
        };

        for (Rectangle rectangle : rectangles) {
            System.out.println("Area: " + rectangle.getArea());
            System.out.println("Perimeter: " + rectangle.getPerimeter());
        }

        System.out.println("Number of rectangles: " + Rectangle.getNumOfRectangles());
    }
}

class Rectangle {
    double width;
    double height;

    static int numOfRectangles = 0;

    Rectangle (double width, double height) {
        this.width = width;
        this.height = height;

        numOfRectangles++;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return (width * 2) + (height * 2);
    }

    static int getNumOfRectangles() {
        return numOfRectangles;
    }
}
