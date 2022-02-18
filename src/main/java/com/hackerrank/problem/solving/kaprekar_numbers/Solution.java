package com.hackerrank.problem.solving.kaprekar_numbers;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        String res = IntStream.rangeClosed(p, q)
                .filter(Result::isKaprekarNumber)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
        System.out.println(res.isEmpty() ? "INVALID RANGE" : res);

    }

    private static boolean isKaprekarNumber(long n) {
        String powN = String.valueOf(n * n);
        if (powN.length() == 1) {
            return n == 1;
        }
        int d = String.valueOf(n).length();
        int idx = powN.length() - d;
        long l = Long.parseLong(powN.substring(0, idx));
        long r = Long.parseLong(powN.substring(idx));
        return l + r == n;
    }

}

//https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class Solution {
    public static void main(String[] args) {
        Result.kaprekarNumbers(1, 100000);
    }
}
