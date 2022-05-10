package com.hackerrank.interview_prep.arrays.array_manipulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        Map<Long, Long> map = new HashMap<>();
        for (List<Integer> query : queries) {
            long start = query.get(0);
            long end = query.get(1) + 1;
            long value = query.get(2);
            map.merge(start, value, Long::sum);
            map.compute(end, (k, v) -> (v == null ? 0 : v) - value);
        }

        long max = 0;
        long value = 0;
        for (long i = 1; i <= n; i++) {
            value += map.getOrDefault(i, 0L);
            max = Math.max(max, value);
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.arrayManipulation(5, List.of(
                List.of(1, 2, 100),
                List.of(2, 5, 100),
                List.of(3, 4, 100)
        )));
    }
}
