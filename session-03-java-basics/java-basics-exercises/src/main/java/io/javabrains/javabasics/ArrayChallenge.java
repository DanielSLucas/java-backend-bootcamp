package io.javabrains.javabasics;

public class ArrayChallenge {
    public static void main(String[] args) {
        // Step 1: Create an array of integers
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        // Step 2: Use arrays and array operations to find the sum, average, and largest number in the array
        int sum = 0;
        int largestNum = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            if (largestNum < arr[i]) {
                largestNum = arr[i];
            }
            sum += arr[i];
        }
        
        double avg = sum/arr.length;

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
        System.out.println("largestNum = " + largestNum);
    }
}
