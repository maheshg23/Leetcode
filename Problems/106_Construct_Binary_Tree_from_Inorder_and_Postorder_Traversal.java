// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
// 106. Construct Binary Tree from Inorder and Postorder Traversal

class Solution {

    Map<Integer, Integer> hm = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return insert(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode insert(int[] inorder, int[] postorder, int start, int end, int postIdx) {

        if (start > end)
            return null;
        TreeNode root = new TreeNode(postorder[postIdx--]);
        if (start == end)
            return root;

        int idx = hm.get(root.val);
        root.right = insert(inorder, postorder, idx + 1, end, postIdx);
        root.left = insert(inorder, postorder, start, idx - 1, postIdx);
        return root;
    }
}

class Solution {
    Map<Integer, Integer> hm = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return insert(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode insert(int[] inorder, int[] postorder, int start, int end, int postIdx) {

        if (start > end)
            return null;
        TreeNode root = new TreeNode(postorder[postIdx]);
        System.out.println(root.val);
        if (start == end)
            return root;
        int idx = hm.get(root.val);
        root.right = insert(inorder, postorder, idx + 1, end, postIdx - 1);
        root.left = insert(inorder, postorder, start, idx - 1, postIdx - 1 - (end - idx));
        return root;
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */