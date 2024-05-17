package com.leetcode.array_string._14_longest_common_prefix;

/**
 * <h1>14. Longest Common Prefix</h1>
 * <p>Write a function to find the longest common prefix string amongst an array of strings.
 *<br>
 * If there is no common prefix, return an empty string "".</p>
 *<br>
 *
 *<p>
 * Example 1:
 *<br>
 * Input: strs = ["flower","flow","flight"]<br>
 * Output: "fl"
 * </p>
 * <br>
 * <p>
 * Example 2:
 *<br>
 * Input: strs = ["dog","racecar","car"]<br>
 * Output: ""<br>
 * Explanation: There is no common prefix among the input strings.
 *</p>
 *<br>
 * <p>
 * Constraints:
 *<br>
 * 1 <= strs.length <= 200<br>
 * 0 <= strs[i].length <= 200<br>
 * strs[i] consists of only lowercase English letters.
 * </p>
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.isEmpty()) return "";
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
