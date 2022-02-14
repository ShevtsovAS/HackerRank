package com.hackerrank.interview_prep.arrays.left_rotation;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int[] arr = a.stream().mapToInt(Integer::intValue).toArray();
        int[] tail = new int[d % arr.length];
        if (tail.length > 0) {
            System.arraycopy(arr, 0, tail, 0, tail.length);
            System.arraycopy(arr, tail.length, arr, 0, arr.length - tail.length);
            System.arraycopy(tail, 0, arr, arr.length - tail.length, tail.length);
        }
        return Arrays.stream(arr).boxed().collect(toList());
    }

}

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.rotLeft(List.of(1, 2, 3, 4, 5), 4));
        System.out.println(Result.rotLeft(List.of(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51), 10));
    }
}
