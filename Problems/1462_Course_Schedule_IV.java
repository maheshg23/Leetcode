// 1462. Course Schedule IV

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        boolean[][] reachable = new boolean[n][n];
        for (int[] a : prerequisites) {
            reachable[a[0]][a[1]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!reachable[i][j]) {
                        reachable[i][j] = reachable[i][k] && reachable[k][j];
                    }
                }
            }
        }

        for (int q[] : queries) {
            res.add(reachable[q[0]][q[1]]);
        }
        return res;
    }
}

// DFS faster

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        List<Integer>[] adj = new ArrayList[n];
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();

        for (int[] a : prerequisites)
            adj[a[0]].add(a[1]);

        Boolean[][] reachable = new Boolean[n][n];
        for (int q[] : queries) {
            res.add(findPath(adj, reachable, q[0], q[1]));
        }
        return res;
    }

    public boolean findPath(List<Integer>[] adj, Boolean[][] reachable, int curr, int end) {
        if (curr == end) {
            reachable[curr][end] = true;
            return true;
        }

        if (reachable[curr][end] != null)
            return reachable[curr][end];

        for (int a : adj[curr]) {
            if (findPath(adj, reachable, a, end)) {
                reachable[curr][end] = true;
                return true;
            }
        }
        reachable[curr][end] = false;
        return false;
    }
}