package com.hackerrank.problem.solving.number_line_jumps;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if (v2 >= v1) {
            return "NO";
        }
        while (x1 < x2) {
            x1 += v1;
            x2 += v2;
        }
        return x1 == x2 ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.kangaroo(0, 2, 5, 3));
    }
}
