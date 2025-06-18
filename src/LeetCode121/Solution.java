package LeetCode121;

/**
 * Solution for LeetCode 121
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">LeetCode 121</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */


class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}