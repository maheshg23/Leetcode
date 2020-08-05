// 121. Best Time to Buy and Sell Stock 

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int max = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > max) {
                max = prices[i] - buy;
            }
        }
        return max;
    }
}