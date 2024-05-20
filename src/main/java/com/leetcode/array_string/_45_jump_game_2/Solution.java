package com.leetcode.array_string._45_jump_game_2;

/**
 * <h1>45. Jump Game II</h1><br>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].<br>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:<br>
 *<br>
 * 0 <= j <= nums[i] and<br>
 * i + j < n<br>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].<br>
 *<br>
 * Example 1:<br>
 * Input: nums = [2,3,1,1,4]<br>
 * Output: 2<br>
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [2,3,0,1,4]<br>
 * Output: 2<br>
 *<br>
 * Constraints:<br>
 * 1 <= nums.length <= 104<br>
 * 0 <= nums[i] <= 1000<br>
 * It's guaranteed that you can reach nums[n - 1].<br>
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return 1;
        }
        int jump1 = jump(nums, nums[0], 1);
        int jump2 = jump(nums, 1, 1);
        return Math.min(jump1, jump2);
    }

    private int jump(int[] nums, int from, int count) {
        if (from >= nums.length - 1) {
            return count;
        }
        if (nums[from] <= 0) {
            return Integer.MAX_VALUE;
        }

        count++;
        int jump1 = jump(nums, from + nums[from], count);
        int jump2 = jump(nums, from + 1, count);
        return Math.min(jump1, jump2);
    }

    public static void main(String[] args) {
        int[] nums = {4,1,1,1,3,1,1, 1};
        System.out.println(new Solution().jump(nums));
    }
}
