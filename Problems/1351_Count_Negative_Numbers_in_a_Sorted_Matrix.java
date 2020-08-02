// 1351. Count Negative Numbers in a Sorted Matrix

class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }
}

// Binary Search Solution
class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int start = 0;
            int end = grid[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (grid[i][mid] < 0)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            count += grid[i].length - start;
        }
        return count;
    }
}