package com.examples.effective.armstrong_numbers;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution {

    private static final long[][] DEGREES = new long[10][20];

    static {
        for (int i = 0; i < DEGREES.length; i++) {
            for (int j = 0; j < DEGREES[i].length; j++) {
                DEGREES[i][j] = pow(i, j);
            }
        }
    }

    private static long pow(int num, int power) {
        if (power == 0) {
            return 1;
        }
        if (num < 2) {
            return num;
        }
        long result = num;
        while (power > 1) {
            result *= num;
            power--;
        }
        return result;
    }

    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        var startMem = mem();
        var armstrongNums = getArmstrongNums(Long.MAX_VALUE);
        var end = System.currentTimeMillis();
        var endMem = mem();
        System.out.printf("%.2f сек.%n", (end - start) / 1000d);
        System.out.println((endMem - startMem) / 1024 / 1024 + "mb");
        System.out.println(armstrongNums);
    }

    public static Set<Long> getArmstrongNums(long maxValue) {
        Set<Long> result = Collections.synchronizedSortedSet(new TreeSet<>());
        getSizesRange(maxValue).forEach(size -> {
            var numbers = new int[size];
            while (numbers[0] < 10) {
                long sum = sum(numbers);
                if (isArmstrong(sum, size)) {
                    result.add(sum);
                }
                numbers[0]++;
                if (numbers[0] > 9) {
                    increment(numbers);
                }
            }
        });
        return result;
    }

    private static IntStream getSizesRange(long maxValue) {
        return IntStream.rangeClosed(1, getNumLength(maxValue)).parallel();
    }

    private static void increment(int[] numbers) {
        var position = 0;
        for (var i = 0; i < numbers.length; i++) {
            if (numbers[i] < 9) {
                numbers[i]++;
                position = i;
                break;
            }
        }
        for (var i = 0; i < position; i++) {
            numbers[i] = numbers[position];
        }
    }

    private static long sum(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += DEGREES[number][numbers.length];
            if (sum < 0) {
                return -1;
            }
        }
        return sum;
    }

    private static boolean isArmstrong(long value, int power) {
        long originalValue = value;
        long sum = 0;
        while (value > 0) {
            int digit = (int) (value % 10);
            sum += DEGREES[digit][power];
            if (sum > originalValue) {
                return false;
            }
            value /= 10;
        }
        return sum == originalValue;
    }

    private static int getNumLength(long num) {
        var result = 0;
        while (num > 0) {
            result++;
            num /= 10;
        }
        return result;
    }

    public static long mem() {
        var runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
