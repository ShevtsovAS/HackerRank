package com.leetcode._13_roman_to_integer;

import java.util.Map;

/**
 * <h1>13. Roman to Integer</h1>
 * <p>Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.</p>
 * <br>
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * </p>
 * <br>
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:</p>
 * <br>
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * </p>
 * <br>
 * <br>
 * <p>
 * Example 1:
 * <br>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * </p>
 * <br>
 * <p>
 * Example 2:
 * <br>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * </p>
 * <br>
 * <p>
 * Example 3:
 * <br>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </p>
 * <br>
 * <p>
 * Constraints:
 * <br>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * </p>
 */
public class Solution {

    private final static Map<Character, Integer> ROMAN_INTEGERS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        char prev = ' ';
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            result += romanToInt(c, prev);
            prev = c;
        }
        return result;
    }

    private int romanToInt(char c, Character prev) {
        var num = ROMAN_INTEGERS.get(c);
        return switch (c) {
            case 'I' -> prev == 'V' || prev == 'X' ? -num : num;
            case 'X' -> prev == 'L' || prev == 'C' ? -num : num;
            case 'C' -> prev == 'D' || prev == 'M' ? -num : num;
            default -> num;
        };
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
