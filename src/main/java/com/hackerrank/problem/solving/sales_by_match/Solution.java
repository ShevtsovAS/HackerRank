package com.hackerrank.problem.solving.sales_by_match;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        return IntStream.range(0, n).map(ar::get).boxed()
                .collect(groupingBy(sock -> sock, Collectors.counting()))
                .values().stream()
                .map(sock -> sock / 2)
                .mapToInt(Long::intValue)
                .sum();
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.sockMerchant(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }
}
