package LeetCode121.Review;

public class ReviewV2 {
    // int min = prices[0], int profit = 0
    // Then, run a loop in prices
    // if (prices[i] < min) min = prices[i]
    // profit = maxOf(profit, prices[i] - min);
    // Time Complexity = o(n), Space Complexity = o(1)
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) minValue = prices[i];

            profit = Math.max(profit, prices[i] - minValue);
        }

        return profit;
    }
}
