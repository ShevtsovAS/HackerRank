package com.leetcode.array_string._68_text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>68. Text Justification</h1>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.<br>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.<br>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.<br>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.<br>
 * <br>
 * Note:<br>
 * A word is defined as a character sequence consisting of non-space characters only.<br>
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.<br>
 * The input array words contains at least one word.<br>
 * <br>
 * Example 1:<br>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16<br>
 * Output:<br>
 * [<br>
 * "This    is    an",<br>
 * "example  of text",<br>
 * "justification.  "<br>
 * ]<br>
 * <br>
 * Example 2:<br>
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16<br>
 * Output:<br>
 * [<br>
 * "What   must   be",<br>
 * "acknowledgment  ",<br>
 * "shall be        "<br>
 * ]<br>
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.<br>
 * Note that the second line is also left-justified because it contains only one word.<br>
 * <br>
 * Example 3:<br>
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20<br>
 * Output:<br>
 * [<br>
 * "Science  is  what we",<br>
 * "understand      well",<br>
 * "enough to explain to",<br>
 * "a  computer.  Art is",<br>
 * "everything  else  we",<br>
 * "do                  "<br>
 * ]<br>
 * <br>
 * Constraints:<br>
 * 1 <= words.length <= 300<br>
 * 1 <= words[i].length <= 20<br>
 * words[i] consists of only English letters and symbols.<br>
 * 1 <= maxWidth <= 100<br>
 * words[i].length <= maxWidth<br>
 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        var result = new ArrayList<String>();
        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1;
            int lineWidth = words[i].length();
            while (isWordCanBeAdded(words, maxWidth, lineWidth, i, j)) {
                lineWidth += words[j++].length();
            }

            int diff = maxWidth - lineWidth;
            int numberOfWords = j - i;

            if (numberOfWords > 1 && j < n) result.add(middleJustify(words, diff, i, j));
            else result.add(leftJustify(words, diff, i, j));

            i = j;
        }
        return result;
    }

    private static boolean isWordCanBeAdded(String[] words, int maxWidth, int lineWidth, int i, int j) {
        if (j >= words.length) return false;
        int spacesNeeded = j - i - 1;
        int newLineWidth = lineWidth + words[j].length() + spacesNeeded;
        return newLineWidth < maxWidth;
    }

    private String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;

        var result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            int spacesToApply = spaces + extraSpaces;
            extraSpaces = 0;
            result.append(" ".repeat(spacesToApply)).append(words[k]);
        }

        return result.toString();
    }

    private String leftJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spacesOnRight = diff - spacesNeeded;

        var result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            result.append(" ").append(words[k]);
        }

        result.append(" ".repeat(spacesOnRight));

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        new Solution().fullJustify(words, 15).forEach(System.out::println);
    }

}
