// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
// 222. Count Complete Tree Nodes

class Solution {
    public int countNodes(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        int count = 0;
        while (!st.isEmpty() || node != null) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                count++;
                node = st.pop();
                node = node.right;
            }
        }
        return count;
    }
}

// Recursion Faster
class Solution {
    int count = 0;

    public int countNodes(TreeNode root) {
        traverse(root);
        return count;
    }

    public void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.left);
        count++;
        traverse(node.right);
    }
}