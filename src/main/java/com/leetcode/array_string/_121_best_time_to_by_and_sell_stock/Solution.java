package com.leetcode.array_string._121_best_time_to_by_and_sell_stock;

/**
 * <h1>121. Best Time to Buy and Sell Stock</h1>
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.</p>
 *
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.</p>
 *
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.</p>
 * <br>
 *
 *
 * <p>Example 1:
 * <br>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.</p>
 * <br>
 * <p>Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * </p>
 * <br>
 * <p>Constraints:
 * <p>
 * 1 <= prices.length <= 10^5
 * <br>
 * 0 <= prices[i] <= 10^4
 * </p>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i - 1];
            profit = Math.max(0, profit); //reset profit to 0 if it is negative, like we start the deal from current position
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
