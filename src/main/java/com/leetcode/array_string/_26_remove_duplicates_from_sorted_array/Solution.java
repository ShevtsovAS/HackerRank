package com.leetcode.array_string._26_remove_duplicates_from_sorted_array;

import java.util.Arrays;

/**
 * <h1>26. Remove Duplicates from Sorted Array</h1>
 * <p>Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.</p>
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *<br>
 * <p>Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * <>br</>Return k.</p>
 * Custom Judge:
 *<br>
 * The judge will test your solution with the following code:
 *<br>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *<br>
 * int k = removeDuplicates(nums); // Calls your implementation
 *<br>
 * <p>assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *</p>
 *<br>
 *
 * <p>Example 1:
 *<br>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).</p>
 * <br>
 * <p>Example 2:
 *<br>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *</p>
 *<br>
 * <p>Constraints:
 *<br>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.</p>
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 1 || n != nums[i - 1]) nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = new Solution().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
