package com.examples;

import static java.util.Arrays.stream;

public class FindPalindromes {
    public static void main(String[] args) {
        System.out.println(stream(args).filter(FindPalindromes::isPalindrome).count());
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0, j = s.length() - 1, mid = s.length() / 2; i <= mid; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
