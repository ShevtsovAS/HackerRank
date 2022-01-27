package com.hackerrank.problem.solving.time_convertion;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class Result {
    private final static DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("h:mm:ssa", Locale.ENGLISH);
    private final static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Write your code here
        return LocalTime.parse(s, INPUT_FORMAT).format(OUTPUT_FORMAT);
    }

}

//https://www.hackerrank.com/challenges/time-conversion/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.timeConversion("07:05:45PM"));
        System.out.println(Result.timeConversion("12:00:00PM"));
        System.out.println(Result.timeConversion("12:00:00AM"));
    }
}
