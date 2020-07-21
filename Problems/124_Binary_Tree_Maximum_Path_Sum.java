// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
// 124. Binary Tree Maximum Path Sum

class Solution {
    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        findPath(root);
        return res;
    }

    public int findPath(TreeNode node) {
        if (node == null)
            return 0;
        int l = findPath(node.left);
        int r = findPath(node.right);
        int maxSingle = Math.max(Math.max(l, r) + node.val, node.val);
        int maxTop = Math.max(maxSingle, l + r + node.val);
        res = Math.max(res, maxTop);
        return maxSingle;
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */