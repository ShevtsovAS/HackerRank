package com.examples;

import static java.util.Arrays.stream;

public class FindPalindromes {
    public static void main(String[] args) {
        System.out.println(stream(args).filter(FindPalindromes::isPalindrome).count());
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (i >= j) {
                return true;
            } else if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
