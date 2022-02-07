package com.hackerrank.problem.solving.cut_the_sticks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        List<Integer> result = new ArrayList<>();
        while (!arr.isEmpty()) {
            result.add(arr.size());
            int min = arr.get(0);
            arr.removeIf(next -> next == min);
            IntStream.range(0, arr.size()).forEach(i -> arr.set(i, arr.get(i) - min));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.cutTheSticks(Stream.of(5, 4, 4, 2, 2, 8).collect(toList())));
    }
}
