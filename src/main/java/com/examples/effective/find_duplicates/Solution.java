package com.examples.effective.find_duplicates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 4, 5, 6};
        countWithStreams(array);
        countCustomJava8(array);
        countCustom(array);
    }

    private static void countCustom(int[] array) {
        Map<Integer, Long> result = new HashMap<>();
        for (int element : array) {
            Long elementCount = result.get(element);
            result.put(element, elementCount == null ? 1 : elementCount + 1);
        }
        System.out.println(result);
    }

    private static void countCustomJava8(int[] array) {
        Map<Integer, Long> result = new HashMap<>();
        for (int element : array) {
            result.compute(element, (key, value) -> value == null ? 1 : value + 1);
        }
        System.out.println(result);
    }

    private static void countWithStreams(int[] array) {
        Map<Integer, Long> result = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(it -> it, Collectors.counting()));
//        Если нужно подсчёт в Integer значениях
//                .collect(Collectors.groupingBy(it -> it, Collectors.reducing(0, (left, right) -> left + 1)));
        System.out.println(result);
    }
}
