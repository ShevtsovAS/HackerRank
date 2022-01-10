package com.hackerrank.solutions.day26;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        int[] returnedDate;
        int[] dueDate;
        try (Scanner scanner = new Scanner(System.in)) {
            returnedDate = getDate(scanner);
            dueDate = getDate(scanner);
        }
        System.out.println(getFine(returnedDate, dueDate));
    }

    private static int getFine(int[] returnedDate, int[] dueDate) {
        int yearFine = getFine(returnedDate[2], dueDate[2], overLimit -> 10000);
        if (yearFine > 0) {
            return yearFine;
        } else if (yearFine == -1) {
            return 0;
        }

        int monthFine = getFine(returnedDate[1], dueDate[1], overLimit -> 500 * overLimit);
        if (monthFine > 0) {
            return monthFine;
        } else if (monthFine == -1) {
            return 0;
        }

        return getFine(returnedDate[0], dueDate[0], overLimit -> 15 * overLimit);
    }

    private static int getFine(int actual, int expected, Function<Integer, Integer> computeFineFunc) {
        int overLimit = actual - expected;
        if (overLimit > 0) {
            return computeFineFunc.apply(overLimit);
        }
        if (overLimit < 0) {
            return -1;
        }
        return 0;
    }

    private static int[] getDate(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
