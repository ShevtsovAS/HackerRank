package com.hackerrank.problem.solving.migratory_birds;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toMap;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        return arr.stream()
                .collect(toMap(k -> k, e -> 1, Math::addExact, TreeMap::new))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).stream()
                .findFirst().map(Map.Entry::getKey).orElse(0);
    }

}

//https://www.hackerrank.com/challenges/migratory-birds/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.migratoryBirds(List.of(1, 4, 4, 4, 5, 3)));
        System.out.println(Result.migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }
}
