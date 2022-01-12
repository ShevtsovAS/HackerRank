package com.hackerrank.solutions.day25;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            System.out.println(isPrime(sc.nextInt()) ? "Prime" : "Not prime");
        }
        sc.close();
    }

    private static boolean isPrime(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        } else if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }

        for (int i = 2, limit = sqrt(n); i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int sqrt(int n) {
        int left = 0;
        int right = n;
        int mid;
        int temp = n;
        while (true) {
            mid = (left + right) / 2;
            int result = mid * mid;
            if (mid == temp || result == n) {
                return mid;
            } else if (result > 0 && result < n) {
                left = mid;
            } else {
                right = mid;
            }
            temp = mid;
        }
    }
}
