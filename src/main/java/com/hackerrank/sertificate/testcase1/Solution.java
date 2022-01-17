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
            if (isOpenBrace(ch)) {
                openBraces.push(ch);
            } else if (openBraces.isEmpty() || isCloseBraceNotMatches(ch, openBraces.pop())) {
                return false;
            }
        }

        return openBraces.isEmpty();
    }

    private boolean isOpenBrace(char ch) {
        return ch == '(' || ch == '{';
    }

    private boolean isCloseBraceNotMatches(char closeBrace, char openBrace) {
        return closeBrace == ')' ? openBrace != '(' : openBrace != '{';
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
