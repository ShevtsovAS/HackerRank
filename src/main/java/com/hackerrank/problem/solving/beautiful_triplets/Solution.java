package com.hackerrank.problem.solving.beautiful_triplets;

import java.util.List;

class Result {

    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                if ((arr.get(j) - arr.get(i) == d)) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        if (arr.get(k) - arr.get(j) == d) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}

//https://www.hackerrank.com/challenges/beautiful-triplets/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.beautifulTriplets(3, List.of(1, 2, 4, 5, 7, 8, 10)));
    }
}
