// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
// 797. All Paths From Source to Target

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<>();
        ls.add(0);
        dfs(graph, res, ls, 0);
        return res;
    }

    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> ls, int src) {

        if (src == graph.length - 1) {
            res.add(new ArrayList<Integer>(ls));
            return;
        }
        for (Integer i : graph[src]) {
            ls.add(i);
            dfs(graph, res, ls, i);
            ls.remove(ls.size() - 1);
        }
    }
}