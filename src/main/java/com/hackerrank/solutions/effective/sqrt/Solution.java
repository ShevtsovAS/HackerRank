package com.hackerrank.solutions.effective.sqrt;

public class Solution {

    public static void main(String[] args) {
        System.out.println(calculateSqrt(9)); // 3
        System.out.println(calculateSqrt(16)); // 4
        System.out.println(calculateSqrt(25)); // 5
        System.out.println(calculateSqrt(26)); // 5
        System.out.println(calculateSqrt(27)); // 5
    }


    public static int calculateSqrt(int input) {
        int low = 0;
        int high = input;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = mid * mid;
            if (sqrt == input) {
                return mid;
            }
            if (sqrt > input) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}
