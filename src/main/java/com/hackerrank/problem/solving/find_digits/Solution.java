package com.hackerrank.problem.solving.find_digits;

class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int digits = n;
        int count = 0;
        while (digits > 0) {
            int d = digits % 10;
            if (d != 0 && n % d == 0) {
                count++;
            }
            digits /= 10;
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.findDigits(124));
        System.out.println(Result.findDigits(111));
        System.out.println(Result.findDigits(10));
        System.out.println(Result.findDigits(12));
        System.out.println(Result.findDigits(1012));
    }
}
