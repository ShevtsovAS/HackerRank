package com.leetcode.two_pointers._15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>15. 3Sum</h1>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.<br>
 * <br>
 * Notice that the solution set must not contain duplicate triplets.<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [-1,0,1,2,-1,-4]<br>
 * Output: [[-1,-1,2],[-1,0,1]]<br>
 * Explanation:<br>
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.<br>
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.<br>
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.<br>
 * The distinct triplets are [-1,0,1] and [-1,-1,2].<br>
 * Notice that the order of the output and the order of the triplets does not matter.<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [0,1,1]<br>
 * Output: []<br>
 * Explanation: The only possible triplet does not sum up to 0.<br>
 * <br>
 * Example 3:<br>
 * Input: nums = [0,0,0]<br>
 * Output: [[0,0,0]]<br>
 * Explanation: The only possible triplet sums up to 0.<br>
 * <br>
 * Constraints:<br>
 * 3 <= nums.length <= 3000<br>
 * -10^5 <= nums[i] <= 10^5<br>
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{0, 1, 1}));
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0}));
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0}));
    }
}
