package io.javabrains.javacollections;

import java.util.Deque;
import java.util.LinkedList;

// Implement the BankQueue class and methods. Look at the main method
// for clues on what the methods need to do

class BankQueue {

    private Deque<String> queue = new LinkedList<>();

    public void addCustomer(String customerName) {
        this.queue.add(customerName);
    }

    //
    public String removeNextCustomer() {
        return this.queue.remove();
    }

    public int getNumCustomers() {
        return this.queue.size();
    }

    public String peekNextCustomer() {
        return this.queue.peekFirst();
    }

    public String peekLastCustomer() {
        return this.queue.peekLast();
    }

    public void displayCustomers() {
        System.out.println(this.queue);
    }
}

public class BankQueueExercise {
    public static void main(String[] args) {
        BankQueue queue = new BankQueue();

        // Add some customers to the queue
        queue.addCustomer("Christie");
        queue.addCustomer("Rowling");
        queue.addCustomer("Steel");

        // Display the number of customers in the queue
        System.out.println("Number of customers in the queue: " + queue.getNumCustomers());

        // Display the name of the next customer in the queue
        System.out.println("Next customer in the queue: " + queue.peekNextCustomer());

        // Display the name of the last customer in the queue
        System.out.println("Last customer in the queue: " + queue.peekLastCustomer());

        // Display the names of all the customers in the queue
        System.out.println("Customers in the queue:");
        queue.displayCustomers();

        // Remove the next customer from the front of the queue
        String nextCustomer = queue.removeNextCustomer();
        System.out.println("Removed customer: " + nextCustomer);

        // Display the updated number of customers in the queue
        System.out.println("Number of customers in the queue: " + queue.getNumCustomers());
    }
}
