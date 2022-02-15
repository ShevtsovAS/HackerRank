package com.hackerrank.interview_prep.arrays.minimum_swaps_2;

public class Solution {
    static int minimumSwaps(int[] arr) {
        int[] a = new int[arr.length + 1];
        System.arraycopy(arr, 0, a, 1, arr.length);
        int count = 0;
        for (int i = 0; i < a.length; ) {
            if (a[i] != i) {
                swap(a, i, a[i]);
                count++;
            } else {
                i++;
            }
        }
        return count;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5}));
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
    }
}
