// 129. Sum Root to Leaf Numbers

class Solution {
    int total;

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        findLeaf(root, sum);
        return total;
    }

    public void findLeaf(TreeNode node, int sum) {
        if (node == null)
            return;

        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            total += sum;
            return;
        }
        findLeaf(node.left, sum);
        findLeaf(node.right, sum);
    }
}