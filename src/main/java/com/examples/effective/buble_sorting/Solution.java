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
        int last = arr.length - 1;
        for (int i = 0; i < last; i++)
            for (int j = 0; j < last - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
