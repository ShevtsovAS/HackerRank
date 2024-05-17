package com.leetcode.array_string._80_remove_duplicates_from_sorted_array_2;

import java.util.Arrays;

/**
 * <h1>80. Remove Duplicates from Sorted Array II</h1>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.<br>
 * <br>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.<br>
 * <br>
 * Return k after placing the final result in the first k slots of nums.<br>
 * <br>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.<br>
 * <br>
 * Custom Judge:<br>
 * <br>
 * The judge will test your solution with the following code:<br>
 * <br>
 * int[] nums = [...]; // Input array<br>
 * int[] expectedNums = [...]; // The expected answer with correct length<br>
 * <br>
 * int k = removeDuplicates(nums); // Calls your implementation<br>
 * <br>
 * assert k == expectedNums.length;<br>
 * for (int i = 0; i < k; i++) {<br>
 * assert nums[i] == expectedNums[i];<br>
 * }<br>
 * If all assertions pass, then your solution will be accepted.<br>
 * <br>
 * <br>
 * Example 1:<br>
 * Input: nums = [1,1,1,2,2,3]<br>
 * Output: 5, nums = [1,1,2,2,3,_]<br>
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.<br>
 * It does not matter what you leave beyond the returned k (hence they are underscores).<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [0,0,1,1,1,1,2,3,3]<br>
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]<br>
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.<br>
 * It does not matter what you leave beyond the returned k (hence they are underscores).<br>
 * <br>
 * Constraints:<br>
 * 1 <= nums.length <= 3 * 10^4<br>
 * -104 <= nums[i] <= 104<br>
 * nums is sorted in non-decreasing order.<br>
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n != nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = new Solution().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
