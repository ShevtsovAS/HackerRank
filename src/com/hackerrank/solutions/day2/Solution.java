package com.hackerrank.solutions.day2;

import java.util.Scanner;

public class Solution {
    // Complete the solve function below.
    static void solve(double mealCost, int tipPercent, int taxPercent) {
        double tip = mealCost / 100 * tipPercent;
        double tax = mealCost / 100 * taxPercent;
        double finalMealCost = mealCost + tip + tax;
        System.out.println(Math.round(finalMealCost));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        solve(meal_cost, tip_percent, tax_percent);
        scanner.close();
    }
}
