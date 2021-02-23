package com.hackerrank.solutions.effective.reverse_string;

public class Solution {
    public static void main(String[] args) {
        String test = "Test string";
//        test = new StringBuilder(test).reverse().toString();
        char[] chars = test.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        test = new String(chars);
        System.out.println(test);
    }
}
