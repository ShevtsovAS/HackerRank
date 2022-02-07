package com.hackerrank.problem.solving.repeated_string;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        //noinspection SuspiciousIntegerDivAssignment
        count *= n / s.length();
        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.repeatedString("abcac", 10));
        System.out.println(Result.repeatedString("aba", 10));
        System.out.println(Result.repeatedString("a", 1000000000000L));
    }
}
