package com.hackerrank.solutions.efective.palindrome;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        checkPalindrome(12345);
        checkPalindrome(12321);
        checkPalindrome(1221);
        checkPalindrome("12345");
        checkPalindrome("12321");
        checkPalindrome("1221");
    }

    private static void checkPalindrome(String s) {
        System.out.printf("%s - %s%n", s, isPalindrome(s) ? "palindrome" : "not palindrome");
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static void checkPalindrome(int number) {
        int[] numbers = getNumbers(number);
        System.out.printf("%s - %s%n", Arrays.toString(numbers), isPalindrome(numbers) ? "palindrome" : "not palindrome");
    }

    private static boolean isPalindrome(int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < numbers.length / 2; i++, j--) {
            if (numbers[i] != numbers[j]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getNumbers(int number) {
//        String temp = String.valueOf(number);
//        int[] result = new int[temp.length()];
//        for (int i = 0; i < temp.length(); i++) {
//            result[i] = temp.charAt(i) - '0';
//        }
        int[] result = new int[String.valueOf(number).length()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = number % 10;
            number /= 10;
        }
        return result;
    }
}
