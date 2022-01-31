package com.hackerrank.problem.solving.bill_division;

import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        int overcharged = b - (IntStream.range(0, bill.size()).filter(i -> i != k).map(bill::get).sum() / 2);
        System.out.println(overcharged > 0 ? overcharged : "Bon Appetit");
    }

}

//https://www.hackerrank.com/challenges/bon-appetit/problem
public class Solution {
    public static void main(String[] args) {
        Result.bonAppetit(List.of(3, 10, 2, 9), 1, 12);
        Result.bonAppetit(List.of(3, 10, 2, 9), 1, 7);
    }
}
