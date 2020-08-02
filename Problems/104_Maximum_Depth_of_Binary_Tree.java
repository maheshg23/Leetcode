// 104. Maximum Depth of Binary Tree

class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        return 1 + Math.max(left, right);
    }
}

class Solution {
    public int maxDepth(TreeNode root) {

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return level;

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
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
        }
        return level;
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */