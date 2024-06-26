package com.leetcode.array_string._135_candy;

import java.util.Arrays;

/**
 * <h1>135. Candy</h1>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.<br>
 * You are giving candies to these children subjected to the following requirements:<br>
 * Each child must have at least one candy.<br>
 * Children with a higher rating get more candies than their neighbors.<br>
 * Return the minimum number of candies you need to have to distribute the candies to the children.<br>
 * <br>
 * Example 1:<br>
 * Input: ratings = [1,0,2]<br>
 * Output: 5<br>
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.<br>
 * <br>
 * Example 2:<br>
 * Input: ratings = [1,2,2]<br>
 * Output: 4<br>
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.<br>
 * The third child gets 1 candy because it satisfies the above two conditions.<br>
 * <br>
 * Constraints:<br>
 * n == ratings.length<br>
 * 1 <= n <= 2 * 10^4<br>
 * 0 <= ratings[i] <= 2 * 10^4<br>
 */
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        int result = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
            result += candies[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 6, 10, 8, 7, 3, 2};
        // 1 2 5 4 3 2 1
        System.out.println(new Solution().candy(ratings));
    }
}
