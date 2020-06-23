// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
// 174. Dungeon Game

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] cost = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    cost[i][j] = dungeon[i][j];
                    if (cost[i][j] > 0)
                        cost[i][j] = 0;
                } else if (i == m - 1) {
                    cost[i][j] = dungeon[i][j] + cost[i][j + 1];
                    if (cost[i][j] > 0)
                        cost[i][j] = 0;
                } else if (j == n - 1) {
                    cost[i][j] = dungeon[i][j] + cost[i + 1][j];
                    if (cost[i][j] > 0)
                        cost[i][j] = 0;
                } else {
                    cost[i][j] = Math.max(cost[i + 1][j], cost[i][j + 1]) + dungeon[i][j];
                    if (cost[i][j] > 0)
                        cost[i][j] = 0;
                }
            }
        }
        return Math.abs(cost[0][0]) + 1;
    }
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] cost = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    cost[i][j] = Math.min(0, dungeon[i][j]);
                } else if (i == m - 1) {
                    cost[i][j] = Math.min(0, dungeon[i][j] + cost[i][j + 1]);
                } else if (j == n - 1) {
                    cost[i][j] = Math.min(0, dungeon[i][j] + cost[i + 1][j]);
                } else {
                    cost[i][j] = Math.min(0, dungeon[i][j] + Math.max(cost[i + 1][j], cost[i][j + 1]));
                }
            }
        }
        return Math.abs(cost[0][0]) + 1;
    }
}