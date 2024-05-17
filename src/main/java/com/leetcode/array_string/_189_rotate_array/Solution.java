package com.leetcode.array_string._189_rotate_array;

import java.util.Arrays;

/**
 * <h1>189. Rotate Array</h1>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [1,2,3,4,5,6,7], k = 3<br>
 * Output: [5,6,7,1,2,3,4]<br>
 * Explanation:<br>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]<br>
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]<br>
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [-1,-100,3,99], k = 2<br>
 * Output: [3,99,-1,-100]<br>
 * Explanation:<br>
 * rotate 1 steps to the right: [99,-1,-100,3]<br>
 * rotate 2 steps to the right: [3,99,-1,-100]<br>
 * <br>
 * Constraints:<br>
 * 1 <= nums.length <= 105<br>
 * -231 <= nums[i] <= 231 - 1<br>
 * 0 <= k <= 105<br>
 * <br>
 * Follow up:<br>
 * <br>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.<br>
 * Could you do it in-place with O(1) extra space?<br>
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        revers(nums, 0, nums.length - 1);
        revers(nums, 0, k - 1);
        revers(nums, k, nums.length - 1);
    }

    public void leftRotate(int[] nums, int k) {
        k %= nums.length;
        revers(nums, 0, nums.length - 1);
        revers(nums, 0, nums.length - 1 - k);
        revers(nums, nums.length - k, nums.length - 1);
    }

    private void revers(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        solution.leftRotate(nums, 1);
        System.out.println(Arrays.toString(nums));
    }
}
