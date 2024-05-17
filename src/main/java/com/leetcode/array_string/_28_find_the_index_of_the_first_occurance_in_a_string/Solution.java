package com.leetcode.array_string._28_find_the_index_of_the_first_occurance_in_a_string;

/**
 * <h1>28. Find the Index of the First Occurrence in a String</h1>
 * <p>Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.</p>
 *
 *
 *<br>
 * Example 1:
 *<br>
 * Input: haystack = "sadbutsad", needle = "sad"<br>
 * Output: 0<br>
 * Explanation: "sad" occurs at index 0 and 6.<br>
 * The first occurrence is at index 0, so we return 0.<br>
 * <br>
 * Example 2:<br>
 *
 * Input: haystack = "leetcode", needle = "leeto"<br>
 * Output: -1<br>
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.<br>
 *
 *<br>
 * Constraints:<br>
 * 1 <= haystack.length, needle.length <= 10^4<br>
 * haystack and needle consist of only lowercase English characters.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
    }
}
