// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
// 107. Binary Tree Level Order Traversal II

// BFS //1 ms
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // res.add(list);
            res.add(0, list);
        }
        // Collections.reverse(res);
        return res;
    }
}

// DFS without Reverse //0ms
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        dfsHelper(res, root, 0);
        // Collections.reverse(res);
        return res;
    }

    public void dfsHelper(List<List<Integer>> res, TreeNode node, int height) {
        if (node == null)
            return;
        if (height >= res.size())
            res.add(0, new ArrayList());

        dfsHelper(res, node.left, height + 1);
        dfsHelper(res, node.right, height + 1);
        res.get(res.size() - height - 1).add(node.val);
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
