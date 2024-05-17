package com.leetcode.array_string._58_length_of_last_word;

/**
 * <h1>58. Length of Last Word</h1>
 * <p>Given a string s consisting of words and spaces, return the length of the last word in the string.</p>
 *<br>
 * <p>
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *</p>
 *<br>
 *<p>
 * Example 1:
 *<br>
 * Input: s = "Hello World"
 * Output: 5
 * <br>
 * Explanation: The last word is "World" with length 5.
 * </p>
 * <br>
 * <p>
 * Example 2:
 *<br>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * <br>
 * Explanation: The last word is "moon" with length 4.
 * </p>
 * <br>
 * <p>
 * Example 3:
 *<br>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * <br>
 * Explanation: The last word is "joyboy" with length 6.
 * </p>
 *<br>
 *<p>
 * Constraints:
 *<br>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * <br>
 * There will be at least one word in s.
 * </p>
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("luffy is still joyboy"));
    }
}
