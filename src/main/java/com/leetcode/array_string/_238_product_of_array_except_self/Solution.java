package com.leetcode.array_string._238_product_of_array_except_self;

import java.util.Arrays;

/**
 * <h1>238. Product of Array Except Self</h1>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].<br>
 * <br>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.<br>
 * <br>
 * You must write an algorithm that runs in O(n) time and without using the division operation.<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [1,2,3,4]<br>
 * Output: [24,12,8,6]<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [-1,1,0,-3,3]<br>
 * Output: [0,0,9,0,0]<br>
 * <br>
 * Constraints:<br>
 * 2 <= nums.length <= 10^5<br>
 * -30 <= nums[i] <= 30<br>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.<br>
 * <br>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)<br>
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        result[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= nums[i + 1];
            nums[i] *= nums[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }
}
