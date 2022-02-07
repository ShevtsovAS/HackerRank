package com.hackerrank.problem.solving.non_divisible_subsets;

import java.util.List;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] remainders = new int[k];
        for (int n : s) {
            remainders[n % k]++;
        }
        int max = 0;
        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i) {
                max += Math.max(remainders[i], remainders[k - i]);
            } else {
                max += Math.min(1, remainders[i]);
            }
        }
//        max += Math.min(max, Math.min(1, remainders[0]));
        max += Math.min(1, remainders[0]);
        return max;
    }

}

//https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.nonDivisibleSubset(4, List.of(19, 10, 12, 10, 24, 25, 22)));
        System.out.println(Result.nonDivisibleSubset(3, List.of(1, 7, 2, 4)));
        System.out.println(Result.nonDivisibleSubset(7, List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
        System.out.println(Result.nonDivisibleSubset(4, List.of(8, 4))); //Wrong answer!!!
    }
}
