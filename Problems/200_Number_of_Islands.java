// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
// 200. Number of Islands

class Solution {
    boolean visited[][];

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0)
            return 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && searchLand(i, j, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean searchLand(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || visited[i][j] == true) {
            return false;
        }
        visited[i][j] = true;
        searchLand(i + 1, j, grid);
        searchLand(i - 1, j, grid);
        searchLand(i, j + 1, grid);
        searchLand(i, j - 1, grid);
        return true;
    }
}

// Without Visited and modifying the input
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0)
            return 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    searchLand(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void searchLand(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        searchLand(i + 1, j, grid);
        searchLand(i - 1, j, grid);
        searchLand(i, j + 1, grid);
        searchLand(i, j - 1, grid);
    }
}