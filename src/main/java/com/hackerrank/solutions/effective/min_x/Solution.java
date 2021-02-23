package com.hackerrank.solutions.effective.min_x;

import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        checkEquals(8, findMinX(min, max, List.of(-5, 4, -2, 3, 1, -1, -6, -1, 0, 5)));
        checkEquals(4, findMinX(min, max, List.of(-2, 3, 1, -5)));
        checkEquals(6, findMinX(min, max, List.of(-5, 4, -2, 3, 1)));
        checkEquals(2, findMinX(min, max, List.of(-1, 5, 5, 5, 5, 5)));
        checkEquals(0, findMinX(min, max, List.of(Integer.MIN_VALUE, 5, 5, 5, 5, 5)));
        checkEquals(380, findMinX(min, max, List.of(-5, 4, -2, 3, 1, -1, -378, -1, 0, 5)));
    }

    private static int findMinX(int start, int end, List<Integer> arr) {
        if (check(start, arr)) {
            return start;
        } else if (start >= end) {
            return 0;
        }
        int mid = ++start + (end - start) / 2;
        if (check(mid, arr)) {
            return findMinX(start, mid, arr);
        } else {
            return findMinX(mid + 1, end, arr);
        }
    }

    private static boolean check(int x, List<Integer> arr) {
        int sum = x;
        for (Integer element : arr) {
            sum += element;
            if (sum < 1) {
                return false;
            }
        }
        return true;
    }

    private static void checkEquals(int expected, int actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(String.format("Expected %s, but actual result is %s", expected, actual));
        }
    }
}
