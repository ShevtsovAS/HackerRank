package com.hackerrank.sertificate.testcase1;

import java.util.Scanner;
import java.util.Stack;

class Parser{
    public boolean isBalanced(String s)
    {
        if (s.length() % 2 != 0 || !s.matches("[(){}]+")) {
            return false;
        }

        Stack<Character> openBraces = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isCloseBrace(ch) && (openBraces.isEmpty() || isCloseBraceNotMatches(ch, openBraces.pop()))) {
                return false;
            } else {
                openBraces.push(ch);
            }
        }

        return openBraces.isEmpty();
    }

    private boolean isCloseBraceNotMatches(char closeBrace, char openBrace) {
        return closeBrace == ')' ? openBrace == '(' : openBrace == '{';
    }

    private boolean isCloseBrace(char ch) {
        return ch == ')' || ch == '}';
    }

}

public class Solution {
    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}
