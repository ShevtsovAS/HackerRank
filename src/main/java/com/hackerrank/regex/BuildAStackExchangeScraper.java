package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/stack-exchange-scraper/problem
public class BuildAStackExchangeScraper {
    public static void main(String[] args) {
        String html = getTextFromConsole();
        Pattern pattern = Pattern.compile("question-summary-(?<id>\\d+).*?class=\"question-hyperlink\">(?<question>.+?)</a>.*?class=\"relativetime\">(?<time>.+?)</span>");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.printf("%s;%s;%s\n",
                    matcher.group("id"),
                    matcher.group("question"),
                    matcher.group("time")
            );
        }
    }

    private static String getTextFromConsole() {
        try (Scanner in = new Scanner(System.in)) {
            StringBuilder builder = new StringBuilder();
            while (in.hasNext()) {
                builder.append(in.nextLine());
            }
            return builder.toString();
        }
    }
}
