package com.hackerrank.problem.solving.beautiful_day;

import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        return IntStream.rangeClosed(i, j).filter(n -> isBeautiful(n, k)).map(n -> 1).sum();
    }

    private static boolean isBeautiful(int n, int k) {
        int rev = reverse(n);
        return Math.abs(n - rev) % k == 0;
    }

    private static int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.beautifulDays(20, 23, 6));
    }
}
