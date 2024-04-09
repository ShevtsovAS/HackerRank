package com.examples.nutera.first_unique_symbol;

import java.util.LinkedHashSet;
import java.util.Optional;

public class SolutionWithoutUsingMap {
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
        if (str == null) {
            return "";
        }

        int[] symbols = new int[256];
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            symbols[ch]++;
            if (symbols[ch] == 1) {
                characters.add(ch);
            } else if (symbols[ch] == 2) {
                characters.remove(ch);
            }
        }
        return characters.stream().findFirst().map(String::valueOf).orElse("");
    }
}
