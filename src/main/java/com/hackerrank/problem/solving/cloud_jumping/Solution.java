package com.hackerrank.problem.solving.cloud_jumping;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int e = 100;
        int i = 0;
        do {
            e--;
            i = (i + k) % n;
            if (c[i] == 1) {
                e -= 2;
            }
        } while (i != 0 && e > 0);
        return e;
    }

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 3));
    }
}
