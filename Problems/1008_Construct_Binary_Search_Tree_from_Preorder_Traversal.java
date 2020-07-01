// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
// 1008. Construct Binary Search Tree from Preorder Traversal

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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = null;
        for(int num : preorder){
            root = buildBST(root, num);
        }
    return root;
    }
    
    public TreeNode buildBST(TreeNode node, int x){
        if(node == null)
            return node = new TreeNode(x);
        if(x < node.val)
            node.left = buildBST(node.left, x);
        else if(x > node.val)
            node.right = buildBST(node.right, x);
        return node;
    }
}