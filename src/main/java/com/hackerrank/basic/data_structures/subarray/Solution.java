package com.hackerrank.basic.data_structures.subarray;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
        scanner.close();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
