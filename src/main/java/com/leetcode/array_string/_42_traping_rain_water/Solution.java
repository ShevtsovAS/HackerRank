package com.leetcode.array_string._42_traping_rain_water;

import static java.lang.Math.max;

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
    public int trap(int[] h) {
        int w = 0, l = 0, r = 0;
        for (int i = 1, j = h.length - 2; i <= j; ) {
            l = max(l, h[i - 1]); r = max(r, h[j + 1]);
            w += l <= r ? max(l - h[i++], 0) : max(r - h[j--], 0);
        } return w;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}
