package com.hackerrank.solutions.day17;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}

class Calculator {
    public int power(int n, int p) {
        if (n < 0 || p < 0) {
            throw new IllegalArgumentException("n and p should be non-negative");
        } else if (p == 0) {
            return 1;
        }

        for (int i = n; p > 1 ; p--) {
            n *= i;
        }

        return n;
    }
}