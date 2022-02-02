package com.hackerrank.problem.solving.picking_numbers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> numCounts = a.stream().collect(Collectors.groupingBy(n -> n, summingInt(n -> 1)));
        return numCounts.keySet().stream()
                .mapToInt(k -> getMaxLength(k, numCounts))
                .max().orElse(0);
    }

    private static int getMaxLength(int k, Map<Integer, Integer> counts) {
        int v = counts.get(k);
        int vLeft = counts.getOrDefault(k - 1, 0);
        int vRight = counts.getOrDefault(k + 1, 0);
        return Math.max(v + vLeft, v + vRight);
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.pickingNumbers(List.of(1, 1, 2, 2, 3, 4, 4, 5, 5, 5)));
        System.out.println(Result.pickingNumbers(List.of(4, 6, 5, 3, 3, 1)));
        System.out.println(Result.pickingNumbers(List.of(1, 2, 2, 3, 1, 2)));
    }
}
