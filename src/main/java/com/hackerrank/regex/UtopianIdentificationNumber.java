package com.hackerrank.regex;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/utopian-identification-number/problem
public class UtopianIdentificationNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> names = getLines(in);
        Pattern pattern = Pattern.compile("^[a-z]{0,3}\\d{2,8}[A-Z]{3}.*$");
        names.forEach(name -> System.out.println(pattern.matcher(name).matches() ? "VALID" : "INVALID"));
    }

    private static List<String> getLines(Scanner in) {
        return IntStream.range(0, Integer.parseInt(in.nextLine()))
                .boxed()
                .map(i -> in.nextLine())
                .collect(toList());
    }
}
