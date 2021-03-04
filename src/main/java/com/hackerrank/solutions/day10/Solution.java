package com.hackerrank.solutions.day10;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        printMaxConsecutiveOfOne(n);
        scanner.close();
    }

    private static void printMaxConsecutiveOfOne(int n) {
        int consecutiveOfOne = 0;
        int maxConsecutiveOfOne = 0;
        for (String s : Integer.toBinaryString(n).split("")) {
            if ("1".equals(s)) {
                consecutiveOfOne++;
                if (consecutiveOfOne > maxConsecutiveOfOne) {
                    maxConsecutiveOfOne = consecutiveOfOne;
                }
            } else {
                consecutiveOfOne = 0;
            }
        }
        System.out.println(Integer.toBinaryString(n));
        System.out.println(maxConsecutiveOfOne);
    }
}
