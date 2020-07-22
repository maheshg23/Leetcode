// 102. Binary Tree Level Order Traversal

// BFS iterative //2ms
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;

        queue.add(root);
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
            res.add(list);
        }
        return res;
    }
}

// DFS recursive //0ms
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        dfsHelper(res, root, 0);
        return res;
    }

    public void dfsHelper(List<List<Integer>> res, TreeNode node, int height) {
        if (node == null)
            return;
        if (height >= res.size())
            res.add(new ArrayList());
        res.get(height).add(node.val);

        dfsHelper(res, node.left, height + 1);
        dfsHelper(res, node.right, height + 1);
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
