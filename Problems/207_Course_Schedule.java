// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
// 207. Course Schedule

// 4ms MySolution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                    return false;
        }
        return true;
    }

    public boolean findCycle(List<List<Integer>> adj, int[] visited, int node) {
        // BackEdge
        if (visited[node] == 1)
            return true;
        visited[node] = 1;
        for (int a : adj.get(node)) {
            if (visited[a] != 2)
                if (findCycle(adj, visited, a))
                    return true;
        }
        visited[node] = 2;
        return false;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // 0 - Unvisited , 1 - Processed , 2 - Processing
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = 0;
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)
                if (topoCycle(adj, visited, i))
                    return false;
        }
        return true;
    }

    public boolean topoCycle(List<List<Integer>> list, int[] visited, int curr) {
        if (visited[curr] == 2)
            return true;
        visited[curr] = 2;
        for (int next : list.get(curr)) {
            if (visited[next] != 1)
                if (topoCycle(list, visited, next))
                    return true;
        }
        visited[curr] = 1;
        return false;
    }
}

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> m = new HashMap();
        Set<Integer> visited = new HashSet();
        for (int[] pre : prerequisites) {
            m.putIfAbsent(pre[1], new ArrayList());
            m.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0 && !visited.contains(i))
                dfs(i, m, indegree, visited);
        return visited.size() == numCourses;
    }

    public void dfs(int start, Map<Integer, List<Integer>> m, int[] indegree, Set<Integer> visited) {
        visited.add(start);
        if (m.get(start) == null)
            return;
        for (int i : m.get(start)) {
            if (indegree[i] > 0)
                indegree[i]--;
            if (indegree[i] == 0 && !visited.contains(i))
                dfs(i, m, indegree, visited);
        }
    }
}
