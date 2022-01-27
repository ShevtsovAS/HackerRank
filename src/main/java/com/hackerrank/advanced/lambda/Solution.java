package com.hackerrank.advanced.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class MyMath {

    public boolean checker(PerformOperation op, int num) {
        return op.test(num);
    }

    public PerformOperation isOdd() {
        return num -> num % 2 != 0;
    }

    public PerformOperation isPrime() {
        return num -> (num > 0 && num <= 3) || (num > 3 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(n -> num % n == 0));
    }

    public PerformOperation isPalindrome() {
        return num -> {
            String s = String.valueOf(num);
            for (int i = 0, j = s.length() - 1, mid = s.length() / 2; i < mid; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        };
    }
}

@FunctionalInterface
interface PerformOperation {
    boolean test(int num);
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
