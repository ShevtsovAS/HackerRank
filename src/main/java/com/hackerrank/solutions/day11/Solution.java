package com.hackerrank.solutions.day11;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();

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
                if (i % 2 != 0 && j % 2 == 0) {
                    continue;
                }
                sum += arr[x + i][y + j];
            }
        }
        return sum;
    }
}
