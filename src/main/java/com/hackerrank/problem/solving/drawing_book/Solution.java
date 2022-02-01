package com.hackerrank.problem.solving.drawing_book;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Write your code here
        int front = p / 2;
        int back = n % 2 == 0 ? (n - p + 1) / 2 : (n - p) / 2;
        return Math.min(front, back);
    }

}


public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.pageCount(5, 3));
        System.out.println(Result.pageCount(6, 2));
        System.out.println(Result.pageCount(5, 4));
        System.out.println(Result.pageCount(6, 4));
    }
}
