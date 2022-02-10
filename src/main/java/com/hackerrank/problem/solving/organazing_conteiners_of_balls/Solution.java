package com.hackerrank.problem.solving.organazing_conteiners_of_balls;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        Set<Integer> balls = container.stream()
                .map(b -> b.stream().mapToInt(Integer::intValue).sum())
                .collect(toSet());
        Set<Integer> types = IntStream.range(0, container.size())
                .mapToObj(t -> container.stream().mapToInt(b -> b.get(t)).sum())
                .collect(toSet());
        return balls.containsAll(types) ? "Possible" : "Impossible";
    }

}

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.organizingContainers(List.of(
                List.of(1, 3, 1),
                List.of(2, 1, 2),
                List.of(3, 3, 3)
        )));
        System.out.println(Result.organizingContainers(List.of(
                List.of(0, 2, 1),
                List.of(1, 1, 1),
                List.of(2, 0, 0)
        )));
    }
}
