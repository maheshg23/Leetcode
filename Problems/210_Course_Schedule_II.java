// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
// 210. Course Schedule II 

class Solution {
    int k = 0;
    int[] res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<Integer>());

        for (int[] i : prerequisites)
            adj.get(i[0]).add(i[1]);

        // 1- visting, 2 - completed
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)
                if (findCycle(adj, visited, i))
                    return new int[0];
        }
        return res;
    }

    public boolean findCycle(List<List<Integer>> adj, int[] visited, int node) {
        if (visited[node] == 1)
            return true;
        visited[node] = 1;
        for (int a : adj.get(node)) {
            if (visited[a] != 2)
                if (findCycle(adj, visited, a))
                    return true;
        }
        visited[node] = 2;
        res[k++] = node;
        return false;
    }
}