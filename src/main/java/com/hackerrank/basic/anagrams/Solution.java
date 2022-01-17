package com.hackerrank.basic.anagrams;

import java.util.Scanner;

public class Solution {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] aChars = new int[256];
        int[] bChars = new int[256];
        for (int i = 0; i < a.length(); i++) {
            char aCh = Character.toUpperCase(a.charAt(i));
            char bCh = Character.toUpperCase(b.charAt(i));
            aChars[aCh] += 1;
            bChars[bCh] += 1;
        }
        for (int i = 0; i < a.length(); i++) {
            char ch = Character.toUpperCase(a.charAt(i));
            if (aChars[ch] != bChars[ch]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
