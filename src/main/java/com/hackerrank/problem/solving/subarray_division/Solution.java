package com.hackerrank.problem.solving.subarray_division;

import java.util.List;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            for (int j = i; j < i + m && j < s.size(); j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

}

//https://www.hackerrank.com/challenges/the-birthday-bar/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.birthday(List.of(2, 2, 1, 3, 2), 4, 2));
        System.out.println(Result.birthday(List.of(1, 2, 1, 3, 2), 3, 2));
        System.out.println(Result.birthday(List.of(1, 1, 1, 1, 1, 1), 3, 2));
        System.out.println(Result.birthday(List.of(4), 4, 1));
    }
}
