package com.hackerrank.solutions.currency_formats;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        Locale indiaLocal = new Locale("en", "IN");
        String india = NumberFormat.getCurrencyInstance(indiaLocal).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        String russia = NumberFormat.getCurrencyInstance(new Locale("ru", "RU")).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
        System.out.println("Russia: " + russia);
    }
}
