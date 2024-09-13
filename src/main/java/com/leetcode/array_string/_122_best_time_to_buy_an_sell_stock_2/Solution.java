package com.leetcode.array_string._122_best_time_to_buy_an_sell_stock_2;

/**
 * <h1>122. Best Time to Buy and Sell Stock II</h1>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.<br>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.<br>
 * Find and return the maximum profit you can achieve.<br>
 * <br>
 * Example 1:<br>
 * Input: prices = [7,1,5,3,6,4]<br>
 * Output: 7<br>
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.<br>
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.<br>
 * Total profit is 4 + 3 = 7.<br>
 * <br>
 * Example 2:<br>
 * Input: prices = [1,2,3,4,5]<br>
 * Output: 4<br>
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.<br>
 * Total profit is 4.<br>
 * <br>
 * Example 3:<br>
 * Input: prices = [7,6,4,3,1]<br>
 * Output: 0<br>
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.<br>
 * <br>
 * Constraints:<br>
 * 1 <= prices.length <= 3 * 10^4<br>
 * 0 <= prices[i] <= 10^4<br>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - prices[i - 1];
            maxProfit = currProfit > 0 ? maxProfit + currProfit : maxProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
