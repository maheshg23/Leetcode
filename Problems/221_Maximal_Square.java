// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
// 221. Maximal Square

// Brute Force 
class Solution {
    public int maximalSquare(char[][] matrix) {

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int sq = 1;
                    boolean flag = true;
                    while (i + sq < matrix.length && j + sq < matrix[i].length && flag) {
                        for (int k = j; k <= sq + j; k++) {
                            if (matrix[i + sq][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sq + i; k++) {
                            if (matrix[k][j + sq] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sq++;
                    }
                    max = Math.max(max, sq);
                }
            }
        }
        return max * max;
    }
}

// DP
class Solution {
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 0; i <= matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}