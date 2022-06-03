package com.hackerrank.regex;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/hackerrank-tweets/problem
public class HackerRankTweets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = getLines(in);
        Pattern pattern = Pattern.compile("(?i)hackerrank");
        int count = 0;
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static List<String> getLines(Scanner in) {
        return IntStream.range(0, Integer.parseInt(in.nextLine()))
                .boxed()
                .map(i -> in.nextLine())
                .collect(toList());
    }
}
