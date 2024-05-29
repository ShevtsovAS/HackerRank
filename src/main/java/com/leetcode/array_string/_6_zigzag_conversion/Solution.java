package com.leetcode.array_string._6_zigzag_conversion;

/**
 * <h1>6. Zigzag Conversion</h1>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)<br>
 * <br>
 * P   A   H   N<br>
 * A P L S I I G<br>
 * Y   I   R<br>
 * And then read line by line: "PAHNAPLSIIGYIR"<br>
 * <br>
 * Write the code that will take a string and make this conversion given a number of rows:<br>
 * <br>
 * string convert(string s, int numRows);<br>
 * <br>
 * Example 1:<br>
 * Input: s = "PAYPALISHIRING", numRows = 3<br>
 * Output: "PAHNAPLSIIGYIR"<br>
 * <br>
 * Example 2:<br>
 * Input: s = "PAYPALISHIRING", numRows = 4<br>
 * Output: "PINALSIGYAHRPI"<br>
 * Explanation:<br>
 * P     I    N<br>
 * A   L S  I G<br>
 * Y A   H R<br>
 * P     I<br>
 * <br>
 * Example 3:<br>
 * Input: s = "A", numRows = 1<br>
 * Output: "A"<br>
 * <br>
 * Constraints:<br>
 * 1 <= s.length <= 1000<br>
 * s consists of English letters (lower-case and upper-case), ',' and '.'.<br>
 * 1 <= numRows <= 1000<br>
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int direction = 1;
        for (int i = 0, j = 0; i < s.length(); i++, j += direction) {
            builders[j].append(s.charAt(i));
            if (j == 0) direction = 1;
            if (j == builders.length - 1) direction = -1;
        }

        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i].toString());
        }

        return builders[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}
