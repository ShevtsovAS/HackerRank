package com.hackerrank.regex;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class IpAddressValidation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = getLines(in);
        Pattern ipV4Pattern = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$");
        Pattern ipV6Pattern = Pattern.compile("^(([0-9a-f]{1,4})(:(?!$)|$)){8}$");
        lines.forEach(line -> {
            Matcher ipV4Matcher = ipV4Pattern.matcher(line);
            Matcher ipV6Matcher = ipV6Pattern.matcher(line);
            if (ipV4Matcher.matches()) {
                System.out.println("IPv4");
            } else if (ipV6Matcher.matches()) {
                System.out.println("IPv6");
            } else {
                System.out.println("Neither");
            }
        });
    }

    private static List<String> getLines(Scanner in) {
        return IntStream.range(0, Integer.parseInt(in.nextLine()))
                .boxed()
                .map(i -> in.nextLine())
                .collect(toList());
    }
}
