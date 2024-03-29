package com.hackerrank.problem.solving.circular_array_rotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        List<Integer> list = new ArrayList<>(a);
        Collections.rotate(list, k);
        return queries.stream().map(list::get).collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.circularArrayRotation(List.of(3, 4, 5), 2, List.of(1, 2)));
        System.out.println(Result.circularArrayRotation(List.of(1, 2, 3), 2, List.of(0, 1, 2)));
    }
}
