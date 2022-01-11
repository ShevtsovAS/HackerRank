package com.hackerrank.solutions.day26;

import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFine(getDate(scanner), getDate(scanner)));
    }

    private static int getFine(LocalDate returnedDate, LocalDate dueDate) {
        return returnedDate.isBefore(dueDate) ? 0 : Stream.of(
                        new SimpleEntry<Function<LocalDate, Integer>, Function<Integer, Integer>>(LocalDate::getYear, overLimit -> 10000),
                        new SimpleEntry<Function<LocalDate, Integer>, Function<Integer, Integer>>(LocalDate::getMonthValue, overLimit -> 500 * overLimit),
                        new SimpleEntry<Function<LocalDate, Integer>, Function<Integer, Integer>>(LocalDate::getDayOfMonth, overLimit -> 15 * overLimit)
                ).map(entry -> getFine(returnedDate, dueDate, entry.getKey(), entry.getValue()))
                .filter(fine -> fine > 0)
                .findFirst().orElse(0);
    }

    private static int getFine(LocalDate actual, LocalDate expected, Function<LocalDate, Integer> getPeriodFunc, Function<Integer, Integer> computeFineFunc) {
        int overLimit = getPeriodFunc.apply(actual) - getPeriodFunc.apply(expected);
        return overLimit > 0 ? computeFineFunc.apply(overLimit) : 0;
    }

    private static LocalDate getDate(Scanner scanner) {
        int[] date = Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return LocalDate.of(date[2], date[1], date[0]);
    }
}
