package com.leetcode.array_string._151_reverse_words_in_a_string;

/**
 * <h1>151. Reverse Words in a String</h1>
 * Given an input string s, reverse the order of the words.<br>
 *<br>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.<br>
 *<br>
 * Return a string of the words in reverse order concatenated by a single space.<br>
 *<br>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.<br>
 *<br>
 * Example 1:<br>
 * Input: s = "the sky is blue"<br>
 * Output: "blue is sky the"<br>
 *<br>
 * Example 2:<br>
 * Input: s = "  hello world  "<br>
 * Output: "world hello"<br>
 * Explanation: Your reversed string should not contain leading or trailing spaces.<br>
 *<br>
 * Example 3:<br>
 * Input: s = "a good   example"<br>
 * Output: "example good a"<br>
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.<br>
 *<br>
 * Constraints:<br>
 * 1 <= s.length <= 104<br>
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.<br>
 * There is at least one word in s.<br>
 *<br>
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?<br>
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ') continue;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            String sub = s.substring(j + 1, i + 1);
            if (!result.isEmpty()) result.append(" ");
            result.append(sub);
            i = j;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  the    sky is blue  "));
    }
}
