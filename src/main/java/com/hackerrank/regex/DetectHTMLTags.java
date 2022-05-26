package com.hackerrank.regex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectHTMLTags {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<\\s*\\b(?<tag>\\w+)\\b.*?>");

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        Set<String> tags = new HashSet<>();
        while (testCases > 0) {
            String line = in.nextLine();

            //Write your code here
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                tags.add(matcher.group("tag"));
            }
            testCases--;
        }

        System.out.println(tags.stream().sorted().collect(Collectors.joining(";")));
    }
}
