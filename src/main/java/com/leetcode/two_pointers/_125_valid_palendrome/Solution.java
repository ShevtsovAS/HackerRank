package com.leetcode.two_pointers._125_valid_palendrome;

/**
 * <h1>125. Valid Palindrome</h1>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.<br>
 *<br>
 * Given a string s, return true if it is a palindrome, or false otherwise.<br>
 *<br>
 * Example 1:<br>
 * Input: s = "A man, a plan, a canal: Panama"<br>
 * Output: true<br>
 * Explanation: "amanaplanacanalpanama" is a palindrome.<br><br>
 * Example 2:<br>
 * Input: s = "race a car"<br>
 * Output: false<br>
 * Explanation: "raceacar" is not a palindrome.<br><br>
 * Example 3:<br>
 * Input: s = " "<br>
 * Output: true<br>
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.<br>
 * Since an empty string reads the same forward and backward, it is a palindrome.<br>
 *<br>
 * Constraints:<br>
 * 1 <= s.length <= 2 * 105<br>
 * s consists only of printable ASCII characters.<br>
 */
public class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            char c1 = toLowerCase(s.charAt(i));
            char c2 = toLowerCase(s.charAt(j));
            if (!isLowerAlphanumeric(c1)) {
                i++;
                continue;
            }
            if (!isLowerAlphanumeric(c2)) {
                j--;
                continue;
            }
            if (c1 != c2) return false;
            i++;
            j--;
        }
        return true;
    }

    private static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += ('a' - 'A');
        return ch;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean isLowerAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        var input = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(input));
    }
}
