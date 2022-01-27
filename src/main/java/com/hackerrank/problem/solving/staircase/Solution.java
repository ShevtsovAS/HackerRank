package com.hackerrank.problem.solving.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void staircase(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            String stair = IntStream.range(0, i).mapToObj(j -> "#").collect(Collectors.joining());
            String spaces = IntStream.range(i, n).mapToObj(j -> " ").collect(Collectors.joining());
            System.out.println(spaces + stair);
        }
    }

}

//https://www.hackerrank.com/challenges/staircase/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Result.staircase(n);
        bufferedReader.close();
    }
}
