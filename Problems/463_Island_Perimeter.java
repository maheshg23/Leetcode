// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
// 463. Island Perimeter

// Count the adjacent 1's
class Solution {
    int res = 0;
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    check(grid, i, j);
                    return res;
                }
            }
        return 0;
    }

    public void check(int[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        int n = 0;
        if (i + 1 <= grid.length - 1 && visited[i + 1][j])
            n += 2;
        if (i - 1 >= 0 && visited[i - 1][j])
            n += 2;
        if (j + 1 <= grid[0].length - 1 && visited[i][j + 1])
            n += 2;
        if (j - 1 >= 0 && visited[i][j - 1])
            n += 2;
        res = res + 4 - n;
        visited[i][j] = true;
        check(grid, i + 1, j);
        check(grid, i - 1, j);
        check(grid, i, j + 1);
        check(grid, i, j - 1);
    }
}

// DFS Count 0's and out of bounds around the 1's
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return check(grid, i, j);
                }
            }
        return 0;
    }

    public int check(int[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
            return 1;
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        int count = 0;
        grid[i][j] = -1;
        count += check(grid, i + 1, j);
        count += check(grid, i - 1, j);
        count += check(grid, i, j + 1);
        count += check(grid, i, j - 1);
        return count;
    }
}

// Iterative Count 0's and out of bounds around the 1's
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return check(grid, i, j);
                }
            }
        return 0;
    }

    public int check(int[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
            return 1;
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        int count = 0;
        grid[i][j] = -1;

        count += check(grid, i + 1, j);
        count += check(grid, i - 1, j);
        count += check(grid, i, j + 1);
        count += check(grid, i, j - 1);
        return count;
    }
}

class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int ret = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ret += 4;
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
                            continue;
                        --ret;
                    }
                }
            }
        }
        return ret;
    }
}

// Fastest
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0)
                    perimeter++;
                if (i == n - 1 || grid[i + 1][j] == 0)
                    perimeter++;
                if (j == 0 || grid[i][j - 1] == 0)
                    perimeter++;
                if (j == m - 1 || grid[i][j + 1] == 0)
                    perimeter++;
            }
        return perimeter;
    }
}