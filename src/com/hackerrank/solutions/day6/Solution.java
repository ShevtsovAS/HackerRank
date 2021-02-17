package com.hackerrank.solutions.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        list.forEach(s -> {
            for (int i = 0; i < s.length(); i+=2) {
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
            for (int i = 1; i < s.length(); i+=2) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        });
    }
}
