package com.examples.effective.magic_square.odd;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        print(generateOddMagicSquare(3));
        print(generateOddMagicSquare(5));
        print(generateOddMagicSquare(7));
        print(generateOddMagicSquare(9));
    }

    private static int[][] generateOddMagicSquare(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("For odd magic square arg n must be odd");
        }

        int[][] result = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0, row = i + n / 2, col = i - n / 2; j < n; j++, row--, col++) {
                result[(n + row) % n][(n + col) % n] = num++;
            }
        }

        return result;
    }

    private static void print(int[][] oddMagicSquare) {
        Arrays.stream(oddMagicSquare).forEach(row -> {
            Arrays.stream(row).forEach(v -> System.out.printf("%4s", v));
            System.out.println();
        });
        System.out.println();
    }
}
