package com.leetcode.stack._20_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>20. Valid Parentheses</h1>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.<br>
 * An input string is valid if:<br>
 * Open brackets must be closed by the same type of brackets.<br>
 * Open brackets must be closed in the correct order.<br>
 * Every close bracket has a corresponding open bracket of the same type.<br>
 * <br>
 * Example 1:<br>
 * Input: s = "()"<br>
 * Output: true<br>
 * <br>
 * Example 2:<br>
 * Input: s = "()[]{}"<br>
 * Output: true<br>
 * <br>
 * Example 3:<br>
 * Input: s = "(]"<br>
 * Output: false<br>
 * <br>
 * Example 4:<br>
 * Input: s = "([])"<br>
 * Output: true<br>
 * <br>
 * Constraints:<br>
 * 1 <= s.length <= 10^4<br>
 * s consists of parentheses only '()[]{}'.<br>
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isOpenBrace(c)) stack.push(c);
            else if (stack.isEmpty() || !isCloseBrace(stack.poll(), c)) return false;
        }
        return stack.isEmpty();
    }

    private boolean isCloseBrace(char c1, char c2) {
        return switch (c1) {
            case '(' -> c2 == ')';
            case '[' -> c2 == ']';
            case '{' -> c2 == '}';
            default -> throw new IllegalStateException("Unexpected value: " + c2);
        };
    }

    private boolean isOpenBrace(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([])"));
        System.out.println(solution.isValid("]"));
    }
}
