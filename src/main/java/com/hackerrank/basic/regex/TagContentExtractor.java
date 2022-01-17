package com.hackerrank.basic.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<(.+)>(?<content>[^<]+)</\\1>");
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            //Write your code here
            boolean matchFound = false;
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group("content"));
                matchFound = true;
            }
            if (!matchFound) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
