// 105. Construct Binary Tree from Preorder and Inorder Traversal

class Solution {
    Map<Integer, Integer> hm = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return insert(inorder, preorder, 0, inorder.length - 1, 0);
    }

    public TreeNode insert(int[] inorder, int[] preorder, int start, int end, int preIdx) {
        if (preIdx > preorder.length - 1 || start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        // System.out.println(root.val);
        if (start == end)
            return root;
        int idx = hm.get(root.val);
        root.left = insert(inorder, preorder, start, idx - 1, preIdx + 1);
        root.right = insert(inorder, preorder, idx + 1, end, preIdx + idx - start + 1);
        return root;
    }
}
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */