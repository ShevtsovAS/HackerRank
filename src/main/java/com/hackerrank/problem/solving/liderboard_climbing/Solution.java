package com.hackerrank.problem.solving.liderboard_climbing;

import java.util.List;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranks = ranked.stream().distinct().collect(toList());
        return player.stream().map(score -> getRank(ranks, score)).collect(toList());
    }

    private static int getRank(List<Integer> ranks, Integer score) {
        int max = ranks.get(0);
        int min = ranks.get(ranks.size() - 1);
        int rank = ranks.size() + 1;

        if (score >= max) {
            return 1;
        } else if (score < min) {
            return rank;
        } else if (score == min) {
            return ranks.size();
        }

        for (int l = 0, r = ranks.size(), m = r / 2; l < r; m = (l + r) / 2) {
            int res = ranks.get(m);
            if (m == l) {
                return m + 2;
            } else if (score == res) {
                return m + 1;
            } else if (score < res) {
                l = m;
            } else {
                r = m;
            }
        }
        return rank;
    }

}


public class Solution {
    public static void main(String[] args) {
        Result.climbingLeaderboard(List.of(100, 90, 90, 80), List.of(70, 80, 105)).forEach(System.out::println);
        System.out.println();
        Result.climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10), List.of(5, 25, 50, 120)).forEach(System.out::println);
        System.out.println();
        Result.climbingLeaderboard(List.of(100, 90, 90, 80, 75, 60), List.of(50, 65, 77, 90, 102)).forEach(System.out::println);
    }
}
