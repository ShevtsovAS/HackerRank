package com.hackerrank.basic.data_structures.arraylist;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<int[]> nums = IntStream.range(0, n).boxed()
                    .map(i -> scanner.nextInt())
                    .map(d -> IntStream.range(0, d).map(i -> scanner.nextInt()).toArray())
                    .collect(toList());
            n = scanner.nextInt();
            while (n-- > 0) {
                int line = scanner.nextInt() - 1;
                int pos = scanner.nextInt() - 1;
                if (line >= nums.size() || pos >= nums.get(line).length) {
                    System.out.println("ERROR!");
                } else {
                    System.out.println(nums.get(line)[pos]);
                }
            }
        }
    }
}
