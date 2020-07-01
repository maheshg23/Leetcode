// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
// 230. Kth Smallest Element in a BST

/*
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

public class TreeNode {
    int val;
    int lcount;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.lcount = 0; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.lcount = this.lcount + 1;
    }
}


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //Inorder traversal 
        TreeNode res = inOrder(root, k);
        if(res == null)
            return 0;
        else
            return res.val;
    }
    
    public TreeNode inOrder(TreeNode node, int k){
        if(node == null)
            return null;
        int count = node.lcount + 1;
        if(count == k){
            return node;
        }
        if(count > k)
            return inOrder(node.left, k);

        return inOrder(node.right, k - count);
    }
}