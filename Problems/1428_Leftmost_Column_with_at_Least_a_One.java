// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3306/
// 1428. Leftmost Column with at Least a One

/**
 * // This is the BinaryMatrix's API interface. // You should not implement it,
 * or speculate about its implementation interface BinaryMatrix { public int
 * get(int row, int col) {} public List<Integer> dimensions {} };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0), col = dim.get(1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            // System.out.println(" i " + i);
            int l = 0, r = col;
            while (l < r) {
                // System.out.println(" l " + l + " r " + r);
                int mid = (l + r) / 2;
                // System.out.println("mid " + mid);
                int a = binaryMatrix.get(i, mid);
                if (a == 1) {
                    min = Math.min(min, mid);
                    // System.out.println("min " + min);
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
// [[0,0],[1,1]]
// [[0,0],[0,1]]
// [[0,0],[0,0]]
// [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
// [[0,0,0],[0,0,1],[0,1,1],[0,0,1]]
// [[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]]