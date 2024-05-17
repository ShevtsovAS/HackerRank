package com.leetcode.array_string._88_merge_sorted_array;

import java.util.Arrays;

/**
 * <h1>88. Merge Sorted Array</h1>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = nums1.length - 1; j >= 0; k--) {
            nums1[k] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        var testcase1 = new TestCase(new int[]{1, 2, 3, 0, 0, 0}, new int[]{2, 5, 6});
        var testcase2 = new TestCase(new int[]{1}, new int[]{});
        var testcase3 = new TestCase(new int[]{0}, new int[]{1});
        var testcase4 = new TestCase(new int[]{4, 0, 0, 0, 0, 0}, new int[]{1, 2, 3, 5, 7});

        var solution = new Solution();
        solution.merge(testcase1.nums1, testcase1.m, testcase1.nums2, testcase1.n);
        solution.merge(testcase2.nums1, testcase2.m, testcase2.nums2, testcase2.n);
        solution.merge(testcase3.nums1, testcase3.m, testcase3.nums2, testcase3.n);
        solution.merge(testcase4.nums1, testcase4.m, testcase4.nums2, testcase4.n);

        System.out.println(Arrays.toString(testcase1.nums1));
        System.out.println(Arrays.toString(testcase2.nums1));
        System.out.println(Arrays.toString(testcase3.nums1));
        System.out.println(Arrays.toString(testcase4.nums1));
    }

    static class TestCase {
        final int[] nums1;
        final int[] nums2;
        final int m;
        final int n;

        TestCase(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            int count = 0;
            for (int i : nums1) {
                if (i != 0) count++;
            }
            m = count;
            n = nums2.length;
        }
    }
}
