package com.hackerrank.projecteuler.even_fibonacci;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum = 2;
            for (long i1 = 2, i2 = 3, i3 = i1 + i2; i3 < n; i1 = i2, i2 = i3, i3 = i1 + i2) {
                if (i3 % 2 == 0) {
                    sum += i3;
                }
            }
            System.out.println(sum);
        }
    }
}
