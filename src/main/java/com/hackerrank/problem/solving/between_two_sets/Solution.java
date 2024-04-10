package com.hackerrank.problem.solving.between_two_sets;

import java.util.List;

//https://www.hackerrank.com/challenges/between-two-sets/problem
class Result {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int f = a.stream().reduce(Result::lcm).orElse(0);
        int l = b.stream().reduce(Result::gcd).orElse(0);
        int count = 0;
        for (int i = f, j = 2; i <= l; i = f * j++) {
            count += l % i == 0 ? 1 : 0;
        }
        return count;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.getTotalX(List.of(2, 4), List.of(16, 32, 96)));
    }
}
