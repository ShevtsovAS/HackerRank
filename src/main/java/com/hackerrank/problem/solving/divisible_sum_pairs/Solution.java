package com.hackerrank.problem.solving.divisible_sum_pairs;

import java.util.List;

class Result {

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < n && i < ar.size(); i++) {
            for (int j = i + 1; j < n && j < ar.size(); j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}

//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.divisibleSumPairs(6, 5, List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(Result.divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)));
    }
}
