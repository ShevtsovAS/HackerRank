package com.leetcode._169_majority_element;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>169. Majority Element</h1>
 * Given an array nums of size n, return the majority element.
 * <br>
 * <p>The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.</p>
 * <br>
 *
 * <p>
 * Example 1:
 * <br>
 * Input: nums = [3,2,3]
 * Output: 3
 * </p>
 * <p>
 * Example 2:
 * <br>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * </p>
 * <br>
 * <p>
 * Constraints:
 * <br>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <br>
 * </p>
 * <p>Follow-up: Could you solve the problem in linear time and in O(1) space?</p>
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int max = 0;
        int majorityNum = 0;
        Map<Integer, Integer> numsCounts = new HashMap<>();
        for (int num : nums) {
            int count = numsCounts.compute(num, (key, value) -> value == null ? 1 : value + 1);
            if (count > max) {
                max = count;
                majorityNum = num;
            }
        }
        return majorityNum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
        System.out.println(solution.majorityElementByMooreVotingAlgorithm(nums));
    }

    public int majorityElementByMooreVotingAlgorithm(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
