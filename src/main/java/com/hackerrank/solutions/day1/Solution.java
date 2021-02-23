package com.hackerrank.solutions.day1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
        int myInt = Integer.parseInt(scan.nextLine());
        double myDouble = Double.parseDouble(scan.nextLine().replace(",", "."));
        String myString = scan.nextLine();
        scan.close();

        /* Declare second integer, double, and String variables. */

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */

        /* Print the sum of the double variables on a new line. */

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(i + myInt);
        System.out.printf("%.1f%n", d + myDouble);
        System.out.println(s + myString);
    }
}
