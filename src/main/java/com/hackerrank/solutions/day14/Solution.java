package com.hackerrank.solutions.day14;

import java.util.Arrays;
import java.util.Scanner;

class Difference {
    private final int[] elements;
    public int maximumDifference;

    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        if (elements.length > 0) {
            Arrays.sort(elements);
            maximumDifference = elements[elements.length - 1] - elements[0];
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
