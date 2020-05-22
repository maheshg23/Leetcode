// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
// No. 993 https://leetcode.com/problems/cousins-in-binary-tree/

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) 
            return false;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depthX = -1;
        int depthY = -1;
        queue.add(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null){
                    if ((node.left.val == x && node.right.val == y )|| (node.left.val == y && node.right.val == x) )
                        return false;
                }
                if (node.val == x) {
                   depthX = level; 
                }
                if (node.val == y) {
                   depthY = level; 
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right); 
            }
            level++;
            
        }
        return (depthX == depthY);
    }
}