package com.hackerrank.problem.solving.library_fine;

import java.util.function.Function;

class Result {

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        int yearFine = getFine(y1, y2, overLimit -> 10000);
        if (yearFine > 0) {
            return yearFine;
        } else if (yearFine == -1) {
            return 0;
        }

        int monthFine = getFine(m1, m2, overLimit -> 500 * overLimit);
        if (monthFine > 0) {
            return monthFine;
        } else if (monthFine == -1) {
            return 0;
        }

        return Math.max(getFine(d1, d2, overLimit -> 15 * overLimit), 0);
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

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.libraryFine(14, 7, 2018, 5, 7, 2018));
        System.out.println(Result.libraryFine(9, 6, 2015, 6, 6, 2015));
        System.out.println(Result.libraryFine(2, 5, 2015, 30, 5, 2015));
    }
}
