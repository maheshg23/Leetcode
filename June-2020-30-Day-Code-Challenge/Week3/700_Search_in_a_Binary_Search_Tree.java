// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3361/
// 700 Search in a Binary Search Tree

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
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val)
            return root;
        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}