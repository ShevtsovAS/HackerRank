package com.hackerrank.interview_prep.arrays.new_year_chaos;

import java.util.List;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int ans = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}

//https://www.hackerrank.com/challenges/new-year-chaos/problem
public class Solution {
    public static void main(String[] args) {
        Result.minimumBribes(List.of(5, 1, 2, 3, 7, 8, 6, 4));
        Result.minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4));
        Result.minimumBribes(List.of(2, 1, 5, 3, 4));
        Result.minimumBribes(List.of(2, 5, 1, 3, 4));
        Result.minimumBribes(List.of(1, 2, 3, 5, 4, 6, 7, 8));
        Result.minimumBribes(List.of(4, 1, 2, 3));
    }
}
