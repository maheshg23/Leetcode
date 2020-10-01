// 743. Network Delay Time

// Bellmon Ford ALgorithm 
class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] ed : times) {
            if (!adj.containsKey(ed[0]))
                adj.put(ed[0],new ArrayList<int[]>());
            adj.get(ed[0]).add(new int[]{ed[1], ed[2]});
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(K);
        dist[K - 1] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            int dis = dist[curr - 1];
            if (adj.containsKey(curr)) {
                for (int[] edge : adj.get(curr)) {
                    if(dist[edge[0] - 1] <= dis + edge[1]) continue;
                    dist[edge[0] - 1] = dis + edge[1];
                    q.offer(edge[0]);
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < dist.length; i++) {
            // System.out.println(dist[i]);
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}

// Dijkstra's Algorithm