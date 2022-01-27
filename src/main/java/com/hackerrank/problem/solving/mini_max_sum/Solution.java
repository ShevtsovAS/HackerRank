package com.hackerrank.problem.solving.mini_max_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long maxSum = arr.stream().sorted().skip(arr.size() - 4).mapToLong(Long::valueOf).sum();
        long minSum = arr.stream().sorted().limit(4).mapToLong(Long::valueOf).sum();
        System.out.printf("%s %s", minSum, maxSum);
    }

}

//https://www.hackerrank.com/challenges/mini-max-sum/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
