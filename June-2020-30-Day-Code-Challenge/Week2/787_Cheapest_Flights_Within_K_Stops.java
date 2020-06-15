// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
// 787. Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        List<List<int[]>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }

        // [city, distance, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[] { src, 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0], dist = cur[1], cost = cur[2];
            if (city == dst)
                return cost;
            else if (dist <= K) {
                for (int[] adjNode : adj.get(city)) {
                    pq.add(new int[] { adjNode[0], dist + 1, cost + adjNode[1] });
                }
            }
        }
        return -1;

    }
}