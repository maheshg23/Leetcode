// 98. Validate Binary Search Tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        if (root == null)
            return true;
        if (l != null && root.val <= l.val)
            return false;
        if (r != null && root.val >= r.val)
            return false;
        return isBST(root.left, l, root) && isBST(root.right, root, r);
    }
}