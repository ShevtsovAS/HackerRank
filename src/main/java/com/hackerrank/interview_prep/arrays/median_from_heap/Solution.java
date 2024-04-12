package com.hackerrank.interview_prep.arrays.median_from_heap;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        var testList = List.of(3D, 2D, 1D, 4D, 5D, 6D, 7D, 8D);
        var median = new DoubleHeap(testList).getMedian();
        System.out.println(median);
    }
}
