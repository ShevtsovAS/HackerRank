package com.hackerrank.problem.solving.encryption;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        int n = (int) Math.ceil(Math.sqrt(s.length()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += n) {
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

}

//https://www.hackerrank.com/challenges/encryption/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.encryption("iffactsdontfittotheorychangethefacts"));
        System.out.println(Result.encryption("chillout"));
        System.out.println(Result.encryption("haveaniceday"));
        System.out.println(Result.encryption("feedthedog"));
    }
}
