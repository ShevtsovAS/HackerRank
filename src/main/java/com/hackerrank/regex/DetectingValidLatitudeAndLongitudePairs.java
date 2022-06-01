package com.hackerrank.regex;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude/problem
public class DetectingValidLatitudeAndLongitudePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = getLines(in);
        Pattern pattern = Pattern.compile("^\\([+-]?(90(\\.0+)?|([1-8]\\d|\\d)(\\.\\d+)?), [+-]?(180(\\.0+)?|(1[0-7]\\d|[1-9]\\d|\\d)(\\.\\d+)?)\\)$");
        lines.forEach(line -> {
            Matcher matcher = pattern.matcher(line);
            String result = matcher.matches() ? "Valid" : "Invalid";
            System.out.println(result);
        });
    }

    private static List<String> getLines(Scanner in) {
        return IntStream.range(0, Integer.parseInt(in.nextLine()))
                .boxed()
                .map(i -> in.nextLine())
                .collect(toList());
    }
}
