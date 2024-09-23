package com.leetcode.hashmap._383_ransom_note;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>383. Ransom Note</h1>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.<br>
 * Each letter in magazine can only be used once in ransomNote.<br>
 * <br>
 * Example 1:<br>
 * Input: ransomNote = "a", magazine = "b"<br>
 * Output: false<br>
 * <br>
 * Example 2:<br>
 * Input: ransomNote = "aa", magazine = "ab"<br>
 * Output: false<br>
 * <br>
 * Example 3:<br>
 * Input: ransomNote = "aa", magazine = "aab"<br>
 * Output: true<br>
 * <br>
 * Constraints:<br>
 * 1 <= ransomNote.length, magazine.length <= 10^5<br>
 * ransomNote and magazine consist of lowercase English letters.<br>
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineChars = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, magazineChars.getOrDefault(c, 0));
            if (index == -1) return false;
            magazineChars.put(c, index + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}
