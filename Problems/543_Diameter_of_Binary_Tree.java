// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
// 543. Diameter of Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findDepthNode(root);
        return res;
    }

    public int findDepthNode(TreeNode node) {
        if (node == null)
            return 0;
        int l = findDepthNode(node.left);
        int r = findDepthNode(node.right);
        res = Math.max(res, l + r + 1);
        return Math.max(l, r) + 1;
    }
}