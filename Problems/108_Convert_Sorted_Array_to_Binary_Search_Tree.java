// 108. Convert Sorted Array to Binary Search Tree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0)
            return null;

        TreeNode root = new TreeNode();
        return buildBST(root, nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(TreeNode node, int[] nums, int i, int j) {
        if (i > j)
            return null;

        int mid = (i + j) / 2;
        node.val = nums[mid];
        node.left = buildBST(new TreeNode(), nums, i, mid - 1);
        node.right = buildBST(new TreeNode(), nums, mid + 1, j);
        return node;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int i, int j) {
        if (i > j)
            return null;
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, i, mid - 1);
        node.right = buildBST(nums, mid + 1, j);
        return node;
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
