// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
// 64. Minimum Path Sum

// Top Dowm up DP //2ms
class Solution {
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
