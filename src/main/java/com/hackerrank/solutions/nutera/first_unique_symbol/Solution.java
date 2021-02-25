package com.hackerrank.solutions.nutera.first_unique_symbol;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Solution {
    public static void main(String[] args) {
        assertEquals(findFirstUniqueSymbol("effective"), "c");
        assertEquals(findFirstUniqueSymbol("abracadabra"), "c");
        assertEquals(findFirstUniqueSymbol("aabb"), "");
        assertEquals(findFirstUniqueSymbol(null), "");
    }

    @SuppressWarnings("SameParameterValue")
    private static void assertEquals(String actual, String expected) {
        Optional.ofNullable(actual)
                .filter(it -> it.equals(expected))
                .orElseThrow(() -> new AssertionError(String.format("\nexpected: %s\nactual: %s", expected, actual)));
    }

    public static String findFirstUniqueSymbol(String str) {
        return Optional.ofNullable(str)
                .map(Solution::toSymbolsMap)
                .map(LinkedHashMap::entrySet)
                .stream().flatMap(Collection::stream)
                .filter(Solution::isUnique)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    private static boolean isUnique(Map.Entry<String, Integer> entry) {
        return entry.getValue() == 1;
    }

    private static LinkedHashMap<String, Integer> toSymbolsMap(String str) {
        return Arrays.stream(str.split("")).collect(toMap(it -> it, it -> 1, Integer::sum, LinkedHashMap::new));
    }
}
