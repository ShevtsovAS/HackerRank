package com.hackerrank.problem.solving.acm_icpc_team;

import java.util.List;

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        int max = 0;
        int teams = 0;
        for (int i = 0; i < topic.size() - 1; i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                int count = countTopics(topic.get(i), topic.get(j));
                if (count > max) {
                    max = count;
                    teams = 1;
                } else if (count == max) {
                    teams++;
                }
            }
        }
        return List.of(max, teams);
    }

    private static int countTopics(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) == '1' || s2.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.acmTeam(List.of("10101", "11100", "11010", "00101")));
    }
}
