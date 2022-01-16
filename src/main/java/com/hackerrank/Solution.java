package com.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Solution {
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex, CASE_INSENSITIVE);
        String input = "Goodbye bye bye world world world";
        Matcher matcher = pattern.matcher(input);
        System.out.println(input);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            input = input.replaceAll(matcher.group(0), matcher.group(1));
        }
        System.out.println(input);
    }
}
