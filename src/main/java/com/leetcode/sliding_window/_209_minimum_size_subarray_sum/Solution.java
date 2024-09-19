package com.leetcode.sliding_window._209_minimum_size_subarray_sum;

/**
 * <h1>209. Minimum Size Subarray Sum</h1>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray<br>
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.<br>
 * <br>
 * Example 1:<br>
 * Input: target = 7, nums = [2,3,1,2,4,3]<br>
 * Output: 2<br>
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.<br>
 * <br>
 * Example 2:<br>
 * Input: target = 4, nums = [1,4,4]<br>
 * Output: 1<br>
 * <br>
 * Example 3:<br>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]<br>
 * Output: 0<br>
 * <br>
 * Constraints:<br>
 * 1 <= target <= 10^9<br>
 * 1 <= nums.length <= 10^5<br>
 * 1 <= nums[i] <= 10^4<br>
 * <br>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).<br>
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
