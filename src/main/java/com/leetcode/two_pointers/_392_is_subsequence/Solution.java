package com.leetcode.two_pointers._392_is_subsequence;

/**
 * <h1>392. Is Subsequence</h1>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.<br>
 *<br>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).<br>
 *<br>
 * Example 1:<br>
 * Input: s = "abc", t = "ahbgdc"<br>
 * Output: true<br>
 *<br>
 * Example 2:<br>
 * Input: s = "axc", t = "ahbgdc"<br>
 * Output: false<br>
 *<br>
 * Constraints:<br>
 * 0 <= s.length <= 100<br>
 * 0 <= t.length <= 10^4<br>
 * s and t consist only of lowercase English letters.<br>
 *<br>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?<br>
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
