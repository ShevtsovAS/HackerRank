package com.leetcode.array_string._jump_game;

/**
 * <h1>55. Jump Game</h1>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.<br>
 * <br>
 * Return true if you can reach the last index, or false otherwise.<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [2,3,1,1,4]<br>
 * Output: true<br>
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [3,2,1,0,4]<br>
 * Output: false<br>
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.<br>
 * <br>
 * Constraints:<br>
 * 1 <= nums.length <= 10^4<br>
 * 0 <= nums[i] <= 10^5<br>
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }
}
