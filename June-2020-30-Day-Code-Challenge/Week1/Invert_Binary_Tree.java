// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
// No. 226 https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        
        return root;
    }
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        
        TreeNode node;
        node = root.left;
        root.left = root.right;
        root.right = node;
        
        helper(root.left);
        helper(root.right);
        
    }
}