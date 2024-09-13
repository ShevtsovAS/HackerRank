package com.leetcode.two_pointers._167_two_sum_2_input_array_is_sorted;

import java.util.Arrays;

/**
 * <h1>167. Two Sum II - Input Array Is Sorted</h1>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.<br>
 * <br>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.<br>
 * <br>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.<br>
 * <br>
 * Your solution must use only constant extra space.<br>
 * <br>
 * Example 1:<br>
 * Input: numbers = [2,7,11,15], target = 9<br>
 * Output: [1,2]<br>
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].<br>
 * <br>
 * Example 2:<br>
 * Input: numbers = [2,3,4], target = 6<br>
 * Output: [1,3]<br>
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].<br>
 * <br>
 * Example 3:<br>
 * Input: numbers = [-1,0], target = -1<br>
 * Output: [1,2]<br>
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].<br>
 * <br>
 * Constraints:<br>
 * 2 <= numbers.length <= 3 * 10^4<br>
 * -1000 <= numbers[i] <= 1000<br>
 * numbers is sorted in non-decreasing order.<br>
 * -1000 <= target <= 1000<br>
 * The tests are generated such that there is exactly one solution.<br>
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{-1, 0}, -1)));
    }

}
