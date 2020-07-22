// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
// 100. Same Tree

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Queue<TreeNode> queuep = new LinkedList<>();
        Queue<TreeNode> queueq = new LinkedList<>();
        queuep.add(p);
        queueq.add(q);
        while (!queuep.isEmpty() && !queueq.isEmpty()) {
            TreeNode nodep = queuep.poll();
            TreeNode nodeq = queueq.poll();
            System.out.println("p " + nodep.val + " q " + nodeq.val);
            if (nodep.val != nodeq.val)
                return false;
            if (nodep.left != null && nodeq.left != null) {
                queuep.add(nodep.left);
                queueq.add(nodeq.left);
            } else if (nodep.left != null || nodeq.left != null) {
                return false;
            }
            if (nodep.right != null && nodeq.right != null) {
                queuep.add(nodep.right);
                queueq.add(nodeq.right);
            } else if (nodep.right != null || nodeq.right != null) {
                return false;
            }
        }
        return true;
    }
}

// Recursion Faster
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// [1,2,3]
// [1,2,3]
// [1,2]
// [1,null,2]
// [1,2,1]
// [1,1,2]

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */