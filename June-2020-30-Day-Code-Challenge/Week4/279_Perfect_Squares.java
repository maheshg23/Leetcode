// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
// 279. Perfect Squares

class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minValue = i;
            int j = 1, sq = 1;
            while (sq <= i) {
                minValue = Math.min(minValue, dp[i - sq] + 1);
                j++;
                sq = j * j;
            }
            dp[i] = minValue;
        }
        return dp[n];
    }
}