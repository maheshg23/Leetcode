// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
// 70. Climbing Stairs

// DP 
class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1)
            dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

// Recursion with Memoization
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return stairs(0, n, memo);
    }

    public int stairs(int i, int n, int[] memo) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        if (memo[i] > 0)
            return memo[i];
        memo[i] = stairs(i + 1, n, memo) + stairs(i + 2, n, memo);
        return memo[i];
    }
}