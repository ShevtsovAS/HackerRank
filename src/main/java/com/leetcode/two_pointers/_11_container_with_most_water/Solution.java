package com.leetcode.two_pointers._11_container_with_most_water;

/**
 * <h1>11. Container With Most Water</h1>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).<br>
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.<br>
 * <p>
 * Return the maximum amount of water a container can store.<br>
 * <p>
 * Notice that you may not slant the container.<br>
 * <br>
 * Example 1:<br>
 * Input: height = [1,8,6,2,5,4,8,3,7]<br>
 * Output: 49<br>
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.<br>
 * <br>
 * Example 2:<br>
 * Input: height = [1,1]<br>
 * Output: 1<br>
 * <br>
 * Constraints:<br>
 * n == height.length<br>
 * 2 <= n <= 10^5<br>
 * 0 <= height[i] <= 10^4<br>
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            maxArea = Math.max(maxArea, area);
            while (i < j && height[i] <= minHeight) i++;
            while (i < j && height[j] <= minHeight) j--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution().maxArea(new int[]{1, 1}));
    }
}
