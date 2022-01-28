package com.hackerrank.problem.solving.breaking_the_records;

import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int min = scores.get(0);
        int max = scores.get(0);
        int breakingMin = 0;
        int breakingMax = 0;

        for (int score : scores) {
            if (score > max) {
                max = score;
                breakingMax++;
            }
            if (score < min) {
                min = score;
                breakingMin++;
            }
        }

        return Arrays.asList(breakingMax, breakingMin);
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1)));
    }
}
