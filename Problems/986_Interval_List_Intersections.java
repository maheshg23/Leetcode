// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
// 986. Interval List Intersections

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        // s1e1
        // s2e2
        // e2>s1 and e1>s2

        List<int[]> list = new ArrayList<int[]>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            if (A[i][1] >= B[j][0] && B[j][1] >= A[i][0]) {
                int start = Math.max(A[i][0], B[j][0]);
                int end = Math.min(A[i][1], B[j][1]);
                list.add(new int[] { start, end });
            }
            if (A[i][1] > B[j][1])
                j++;
            else
                i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}