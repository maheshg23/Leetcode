// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
// 309. Best Time to Buy and Sell Stock with Cooldown

// Space efficient DP 
class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0 || prices.length <= 1)
            return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        // System.out.println(Arrays.toString(buy));
        // System.out.println(Arrays.toString(sell));
        return s0;
    }
}

// Extra Space
class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0 || prices.length <= 1)
            return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];

        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        // System.out.println(Arrays.toString(buy));
        // System.out.println(Arrays.toString(sell));
        return sell[prices.length - 1];
    }
}