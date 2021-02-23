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
        String scannerScipRegex = "(\r\n|[\n\r\u2028\u2029\u0085])?";
        double mealCost = scanner.nextDouble();
        scanner.skip(scannerScipRegex);
        int tipPercent = scanner.nextInt();
        scanner.skip(scannerScipRegex);
        int taxPercent = scanner.nextInt();
        scanner.skip(scannerScipRegex);
        solve(mealCost, tipPercent, taxPercent);
        scanner.close();
    }
}
