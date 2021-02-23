package com.hackerrank.solutions.effective.fibonacci;

import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        int fibonacci = getFibonacci(7);
        int fibonacciRecursive = getFibonacciRecursive(8);
        assertEquals(fibonacci, 13);
        assertEquals(fibonacciRecursive, 21);
    }

    private static void assertEquals(int actual, int expected) {
        Integer result = Optional.of(actual)
                .filter(it -> it == expected)
                .orElseThrow(() -> new AssertionError(String.format("Expected - %s, actual - %s", expected, actual)));
        System.out.println(result);
    }

    private static int getFibonacciRecursive(int number) {
        if (number <= 2) {
            return 1;
        }
        return getFibonacciRecursive(number - 2) + getFibonacciRecursive(number - 1);
    }

    @SuppressWarnings("SameParameterValue")
    private static int getFibonacci(int number) {
        int n1 = 1;
        int n2 = 1;
        int result = 0;
        for (int i = 3; i <= number; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
