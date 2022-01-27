package com.hackerrank.problem.solving.apple_and_orange;

import java.util.List;

class Result {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        System.out.println(apples.stream().map(n -> a + n).filter(n -> n >= s && n <= t).count());
        System.out.println(oranges.stream().map(n -> b + n).filter(n -> n >= s && n <= t).count());
    }

}

//https://www.hackerrank.com/challenges/apple-and-orange/problem
public class Solution {
    public static void main(String[] args) {
        Result.countApplesAndOranges(7, 10, 4, 12, List.of(2, 3, -4), List.of(3, -2, -4));
        System.out.println();
        Result.countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
    }
}
