package com.hackerrank.problem.solving.between_two_sets;

import java.util.List;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        for (int i = f, j = 2; i <= l; i = f * j, j++) {
            if (l % i == 0) {
                count++;
            }
        }
        return count;
    }

    private static int lcm(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = lcm(result, input.get(i));
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = gcd(result, input.get(i));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.getTotalX(List.of(2, 4), List.of(16, 32, 96)));
    }
}
