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

    private static int getRank(List<Integer> ranks, int score) {
        if (ranks.isEmpty() || score >= ranks.get(0)) {
            return 1;
        } else if (score < ranks.get(ranks.size() - 1)) {
            return ranks.size() + 1;
        } else if (score == ranks.get(ranks.size() - 1)) {
            return ranks.size();
        }
        return binarySearch(ranks, score, 0, ranks.size());
    }

    private static int binarySearch(List<Integer> ranks, int score, int low, int high) {
        int mid = (high - low) / 2 + low;
        int rank = ranks.get(mid);
        if (score == rank || low == high) {
            return score >= rank ? mid + 1 : mid + 2;
        }
        return rank > score ? binarySearch(ranks, score, mid + 1, high) : binarySearch(ranks, score, low, mid);
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
