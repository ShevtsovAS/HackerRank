package com.leetcode.array_string._274_h_index;

import java.util.Arrays;

import static java.util.Comparator.reverseOrder;

/**
 * <h1>274. H-Index</h1><br>
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.<br>
 * <br>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.<br>
 * <br>
 * Example 1:<br>
 * Input: citations = [3,0,6,1,5]<br>
 * Output: 3<br>
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.<br>
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.<br>
 * <br>
 * Example 2:<br>
 * Input: citations = [1,3,1]<br>
 * Output: 1<br>
 * <br>
 * Constraints:<br>
 * n == citations.length<br>
 * 1 <= n <= 5000<br>
 * 0 <= citations[i] <= 1000<br>
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] temp = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) temp[n]++;
            else temp[citation]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += temp[i];
            if (sum >= i) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new Solution().hIndex(citations));
    }

    @SuppressWarnings("unused")
    public int hIndexMyNotEffectiveSolution(int[] citations) {
        citations = Arrays.stream(citations).boxed().sorted(reverseOrder()).mapToInt(Integer::intValue).toArray();
        for (int i = citations.length; i > 0; i--) {
            if (citations[i - 1] >= i) return i;
        }
        return 0;
    }
}


