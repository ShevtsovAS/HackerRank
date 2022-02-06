package com.hackerrank.problem.solving.squares;

import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {
        // Write your code here
        return IntStream.iterate(1, v -> v + 1)
                .filter(v -> v * v >= a)
                .takeWhile(v -> v * v <= b)
                .toArray().length;
    }

}

//https://www.hackerrank.com/challenges/sherlock-and-squares/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.squares(24, 49));
        System.out.println(Result.squares(3, 9));
        System.out.println(Result.squares(17, 24));
    }
}
