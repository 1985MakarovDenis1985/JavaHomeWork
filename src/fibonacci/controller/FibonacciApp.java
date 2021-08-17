package fibonacci.controller;

import fibonacci.model.Fibonacci;

/*
 * 1, 1, 2, 3, 5, 8,13, 21
 */

public class FibonacciApp {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        int sum = 0;
        for (Integer num : fibonacci) {
            System.out.println(num);
            sum += num;
        }
        System.out.println("Sum= " + sum);
    }
}
