package com.hackerrank.problem.solving.factorial;

import java.math.BigInteger;

public class Solution {

    public static void factorial(int n) {
        BigInteger num = BigInteger.valueOf(n);
        while (--n > 1) {
            num = num.multiply(BigInteger.valueOf(n));
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        factorial(25);
        factorial(30);
        factorial(100);
    }
}
