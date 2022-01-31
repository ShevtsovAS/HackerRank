package com.hackerrank.problem.solving.programmer_day;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // Write your code here
        if (year == 1918) {
            return "26.09.1918";
        } else if (isLeap(year)) {
            return String.format("12.09.%s", year);
        } else {
            return String.format("13.09.%s", year);
        }

    }

    private static boolean isLeap(int year) {
        return year < 1918 && year % 4 == 0 || year > 1918 && year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.dayOfProgrammer(2016));
        System.out.println(Result.dayOfProgrammer(2017));
        System.out.println(Result.dayOfProgrammer(1800));
        System.out.println(Result.dayOfProgrammer(1700));
    }
}
