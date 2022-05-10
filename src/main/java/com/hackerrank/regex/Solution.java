package com.hackerrank.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        matchingSameText();
        backReferencesToFailedGroup();
        backResetGroups();
        forwardReferences();
        positiveLookahead();
        negativeLookahead();
        positiveLookbehind();
    }

    private static void forwardReferences() {
        System.out.println("forwardReferences:");
        Pattern p = Pattern.compile("^tac(tac(tic)?)*$");
        Matcher m = p.matcher("tactactic");
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println();
    }

    private static void backResetGroups() {
        System.out.println("backResetGroups:");
        Pattern p = Pattern.compile("\\d{2}((---)|(-)|(\\.)|(:))\\d{2}\\1\\d{2}\\1\\d{2}");
        Matcher m = p.matcher("12-34-56-78|12:34:56:78|12---34---56---78|12.34.56.78|12-34:56---78");
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println();
    }

    private static void backReferencesToFailedGroup() {
        System.out.println("backReferencesToFailedGroup:");
        Pattern p = Pattern.compile("^\\d{2}(-?)(\\d{2}\\1){2}\\d{2}$");
        Matcher m = p.matcher("12-34-56-78");
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println();
    }

    private static void matchingSameText() {
        System.out.println("matchingSameText:");
        Pattern p = Pattern.compile("^([a-z])(\\w)(\\s)(\\W)(\\d)(\\D)([A-Z])([a-zA-Z])([aeiouAEIOU])(\\S)\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10$");
        Matcher m = p.matcher("ab #1?AZa$ab #1?AZa$");
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println();
    }

    private static void positiveLookahead() {
        Pattern p = Pattern.compile("o(?=oo)");
        Matcher m = p.matcher("shooot");
        int Count = 0;
        while(m.find()){
            Count += 1;
        }
        System.out.format("Number of matches : %d",Count);
    }

    private static void negativeLookahead() {
        Pattern p = Pattern.compile("(.)(?!\\1)");
        Matcher m = p.matcher("shooot");
        int Count = 0;
        while(m.find()){
            Count += 1;
        }
        System.out.format("Number of matches : %d",Count);
    }

    private static void positiveLookbehind() {
        Pattern p = Pattern.compile("(?<=[13579])\\d");
        Matcher m = p.matcher("12345");
        int Count = 0;
        while(m.find()){
            Count += 1;
        }
        System.out.format("Number of matches : %d",Count);
    }

}
