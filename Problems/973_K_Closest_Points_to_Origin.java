// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
// 973. K Closest Points to Origin

class Solution {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            arr[i] = dist(points[i]);
        }
        Arrays.sort(arr);
        int max = arr[K - 1];
        int j = 0;
        for (int i = 0; i < points.length; i++) {
            if (dist(points[i]) <= max)
                res[j++] = points[i];
        }
        return res;
    }

    public int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}

// Priority Queue Implementation
class Solution {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p1, p2) -> {
            return dist(points[p2]) - dist(points[p1]);
        });
        for (int i = 0; i < points.length; i++) {
            pq.add(i);
            if (pq.size() > K)
                pq.remove();
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int idx = pq.remove();
            res[i] = points[idx];
        }
        return res;
    }

    public int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}