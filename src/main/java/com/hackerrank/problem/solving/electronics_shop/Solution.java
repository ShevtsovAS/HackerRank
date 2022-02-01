package com.hackerrank.problem.solving.electronics_shop;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> keyboards = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().collect(toList());
        List<Integer> drives = IntStream.range(0, m).map(i -> scanner.nextInt()).boxed().collect(toList());

        long max = keyboards.stream()
                .flatMapToLong(k -> drives.stream().mapToLong(Integer::longValue).map(d -> k + d))
                .filter(sum -> sum <= b)
                .max()
                .orElse(-1);

        System.out.println(max);
    }
}
