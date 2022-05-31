package com.hackerrank.regex;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AlienUsername {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> names = getLines(in);
        Pattern pattern = Pattern.compile("^[_.][0-9]+[a-zA-Z]*_?$");
        names.forEach(name -> {
            Matcher matcher = pattern.matcher(name);
            String result = matcher.matches() ? "VALID" : "INVALID";
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
