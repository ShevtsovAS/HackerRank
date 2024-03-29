package com.examples.effective.buble_sorting;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] unsorted = {32, 39, 21, 45, 23, 3};
        bubbleSort(unsorted);
        int[] test = {5, 3, 2, 1};
        bubbleSort(test);
        System.out.println(Arrays.toString(unsorted));
        System.out.println(Arrays.toString(test));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
