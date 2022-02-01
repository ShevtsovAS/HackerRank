package com.hackerrank.problem.solving.cats_and_mouse;

public class Solution {

    static String catAndMouse(int x, int y, int z) {
        int A = Math.abs(z - x);
        int B = Math.abs(z - y);
        return A == B ? "Mouse C" : A < B ? "Cat A" : "Cat B";
    }

    public static void main(String[] args) {
        System.out.println(catAndMouse(2, 5, 4));
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }
}
