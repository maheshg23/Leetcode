// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
// 72. Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {

        int a = word1.length();
        int b = word2.length();
        int[][] dp = new int[b + 1][a + 1];

        for (int i = 0; i <= b; i++) {
            for (int j = 0; j <= a; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[b][a];
    }
}