package io.javabrains.javabasics;


public class Operators {
    public static void main(String[] args) {
        // Step 1: Declare variables
        int x = 1;
        int y = 2;

        // Step 2: Perform arithmetic operations
        int sum = x + y;
        int diff = y - x;
        int mult = x * y;
        int div = x / y;
        int mod =  y % x;

        // Step 3: Print the results of the arithmetic operations
        System.out.println("sum = " + sum);
        System.out.println("diff = " + diff);
        System.out.println("mult = " + mult);
        System.out.println("div = " + div);
        System.out.println("mod = " + mod);

        // Step 4: Perform increment and decrement operations
        x++;
        y--;

        // Step 5: Print the results of the increment and decrement operations
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // Step 6: Perform comparison operations
        boolean eq = x == y;
        boolean neq = x != y;
        boolean gt = x > y;
        boolean gte = x >= y;
        boolean lt = x < y;
        boolean lte = x <= y;

        // Step 7: Print the results of the comparison operations
        System.out.println("eq = " + eq);
        System.out.println("neq = " + neq);
        System.out.println("gt = " + gt);
        System.out.println("gte = " + gte);
        System.out.println("lt = " + lt);
        System.out.println("lte = " + lte);

        // Step 8: Perform logical operations
        boolean and = x > y && y < x;
        boolean or = x > y || y > x;
        boolean not = !(x > y);

        // Step 9: Print the results of the logical operations
        System.out.println("and = " + and);
        System.out.println("or = " + or);
        System.out.println("not = " + not);

    }
}
