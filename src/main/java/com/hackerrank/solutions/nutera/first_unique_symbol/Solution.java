package com.hackerrank.solutions.nutera.first_unique_symbol;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static String findFirstUniqueSymbol(String s) {
        if (s == null) {
            return "";
        }

        Map<Character, Long> charsMap = s.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(it -> it, Collectors.counting()));

        for (char ch : s.toCharArray()) {
            if (charsMap.get(ch) == 1) {
                return Character.toString(ch);
            }
        }

        return "";
    }
}
