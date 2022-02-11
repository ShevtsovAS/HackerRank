package com.hackerrank.problem.solving.bigger_is_greater;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] res = w.toCharArray();

        int i = res.length - 2;
        while (i >= 0 && res[i] >= res[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "no answer";
        }

        int j = res.length - 1;
        while (res[j] <= res[i]) {
            j--;
        }
        swap(res, i, j);
        for (i = i + 1, j = res.length - 1; i < j; i++, j--) {
            swap(res, i, j);
        }
        return new String(res);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.biggerIsGreater("dkhc"));
        System.out.println(Result.biggerIsGreater("lmno"));
        System.out.println(Result.biggerIsGreater("dcba"));
        System.out.println(Result.biggerIsGreater("dcbb"));
        System.out.println(Result.biggerIsGreater("abdc"));
        System.out.println(Result.biggerIsGreater("abcd"));
        System.out.println(Result.biggerIsGreater("fedcbabcd"));
    }
}
