package LeetCode121.Review;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];

            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}

// My thoughts: For this approach we will use a couple of variables, min to have the minimum value of the array and
// profit to get the maximum profit across the entire graphic.