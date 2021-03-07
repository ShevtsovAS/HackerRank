package com.hackerrank.solutions.day11;

public class Solution {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int max = Integer.MIN_VALUE;
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                int sum = getHourglassWeight(x, y, arr);
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println(max);
    }

    private static int getHourglassWeight(int x, int y, int[][] arr) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isOutOfNeck(i, j)) {
                    continue;
                }
                sum += arr[x + i][y + j];
            }
        }
        return sum;
    }

    private static boolean isOutOfNeck(int i, int j) {
        return i % 2 != 0 && j % 2 == 0;
    }
}
