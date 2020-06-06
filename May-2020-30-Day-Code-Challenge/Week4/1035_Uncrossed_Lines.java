// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
// No. 1035 https://leetcode.com/problems/uncrossed-lines/

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        
        int[][] dp = new int[A.length+1][B.length+1];
                
        for(int i=0; i <= A.length;i++) {
            for(int j=0;j <= B.length;j++) {       
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (A[i-1] == B[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;                    
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[A.length][B.length];
    }
}