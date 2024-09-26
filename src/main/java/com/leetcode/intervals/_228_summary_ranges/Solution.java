package com.leetcode.intervals._228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>228. Summary Ranges</h1>
 * You are given a sorted unique integer array nums.<br>
 * A range [a,b] is the set of all integers from a to b (inclusive).<br>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.<br>
 * Each range [a,b] in the list should be output as:<br>
 * "a->b" if a != b<br>
 * "a" if a == b<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [0,1,2,4,5,7]<br>
 * Output: ["0->2","4->5","7"]<br>
 * Explanation: The ranges are:<br>
 * [0,2] --> "0->2"<br>
 * [4,5] --> "4->5"<br>
 * [7,7] --> "7"<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [0,2,3,4,6,8,9]<br>
 * Output: ["0","2->4","6","8->9"]<br>
 * Explanation: The ranges are:<br>
 * [0,0] --> "0"<br>
 * [2,4] --> "2->4"<br>
 * [6,6] --> "6"<br>
 * [8,9] --> "8->9"<br>
 * <br>
 * Constraints:<br>
 * 0 <= nums.length <= 20<br>
 * -231 <= nums[i] <= 231 - 1<br>
 * All the values of nums are unique.<br>
 * nums is sorted in ascending order.<br>
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        for (int i = 0, j = i + 1; j <= nums.length; j++) {
            if (j < nums.length && nums[j] == nums[j - 1] + 1) continue;
            if (nums[j - 1] == nums[i]) result.add(String.valueOf(nums[i]));
            else result.add(String.format("%s->%s", nums[i], nums[j - 1]));
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
