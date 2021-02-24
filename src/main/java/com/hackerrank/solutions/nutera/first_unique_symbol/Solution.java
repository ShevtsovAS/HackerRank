package com.hackerrank.solutions.nutera.first_unique_symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        assertEquals(firstUniqueSymbol("effective"), "c");
        assertEquals(firstUniqueSymbol("abracadabra"), "c");
        assertEquals(firstUniqueSymbol("aabb"), "");
    }

    @SuppressWarnings("SameParameterValue")
    private static void assertEquals(String actual, String expected) {
        Optional.ofNullable(actual)
                .filter(it -> it.equals(expected))
                .orElseThrow(() -> new AssertionError(String.format("expected: %s\nactual: %s", expected, actual)));
    }

    public static String firstUniqueSymbol(String s) {
        if (s == null) {
            return "";
        }

        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer count = charactersMap.get(s.charAt(i));
            charactersMap.put(ch, count == null ? 1 : count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = charactersMap.get(s.charAt(i));
            if (count == 1) {
                return Character.toString(ch);
            }
        }

        return "";
    }
}
