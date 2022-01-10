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

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit ; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
