// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
// 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null)
            return false;
        return isValidSequenceCheck(root, arr, 0);
    }

    public boolean isValidSequenceCheck(TreeNode root, int[] arr, int index) {
        if (root == null)
            return false;
        // System.out.println(root.val);
        // System.out.println("idx " + index);
        if (index >= arr.length || root.val != arr[index])
            return false;
        if (root.left == null && root.right == null && arr.length - 1 == index)
            return true;
        return isValidSequenceCheck(root.left, arr, index + 1) || isValidSequenceCheck(root.right, arr, index + 1);
    }
}