package com.hackerrank.problem.solving.append_delete;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        if (s.length() + t.length() <=k) {
            return "Yes";
        }

        int count = 0;
        while (count < s.length() && count < t.length() && s.charAt(count) == t.charAt(count)) {
            count++;
        }

        s = s.substring(count);
        t = t.substring(count);

        k -= (s.length() + t.length());
        return k >= 0 && k % 2 == 0 ? "Yes" : "No";
    }

}

//https://www.hackerrank.com/challenges/append-and-delete/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.appendAndDelete(
                "hackerhappy",
                "hackerrank", 9));
        System.out.println(Result.appendAndDelete(
                "hackerrankhappy",
                "hackerrankpa", 7));
        System.out.println(Result.appendAndDelete(
                "hackerrankhappy",
                "hackerrank", 5));
        System.out.println(Result.appendAndDelete(
                "hackerrank",
                "hackerrankhappy", 5));
        System.out.println(Result.appendAndDelete(
                "abc",
                "def", 6));
    }
}
