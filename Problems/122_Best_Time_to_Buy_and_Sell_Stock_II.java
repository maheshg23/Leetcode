// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
// 122. Best Time to Buy and Sell Stock II

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int first = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < first) {
                first = prices[i];
            } else if (prices[i] > first) {
                max += prices[i] - first;
                first = prices[i];
            }
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}