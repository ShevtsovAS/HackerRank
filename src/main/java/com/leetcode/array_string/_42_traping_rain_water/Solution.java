package com.leetcode.array_string._42_traping_rain_water;

/**
 * 42. Trapping Rain Water<br>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.<br>
 * <br>
 * Example 1:<br>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]<br>
 * Output: 6<br>
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.<br>
 * <br>
 * Example 2:<br>
 * Input: height = [4,2,0,3,2,5]<br>
 * Output: 9<br>
 * <br>
 * Constraints:<br>
 * <br>
 * n == height.length<br>
 * 1 <= n <= 2 * 10^4<br>
 * 0 <= height[i] <= 10^5<br>
 */
public class Solution {
    public int trap(int[] height) {
        int result = 0;

        int[] left = new int[height.length];

        int maxLeft = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = maxLeft = Math.max(height[i - 1], maxLeft);
        }

        int maxRight = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight = Math.max(height[i + 1], maxRight);
            int water = Math.min(left[i], maxRight) - height[i];
            if (water > 0) result += water;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(new Solution().trap(height));
    }
}
