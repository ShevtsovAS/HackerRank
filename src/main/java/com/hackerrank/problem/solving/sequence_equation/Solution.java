package com.hackerrank.problem.solving.sequence_equation;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here
        int[] y = new int[p.size() + 1];
        for (int x = 1; x < y.length; x++) {
            y[p.get(x - 1)] = x;
        }
        return IntStream.range(1, y.length).mapToObj(x -> y[y[x]]).collect(toList());
    }

}

//https://www.hackerrank.com/challenges/permutation-equation/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.permutationEquation(List.of(2, 3, 1)));
        System.out.println(Result.permutationEquation(List.of(4, 3, 5, 1, 2)));
    }
}
