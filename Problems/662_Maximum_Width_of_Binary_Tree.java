// 
// 662. Maximum Width of Binary Tree

class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        int max = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.add(root);
        index.add(1);
        while (!q.isEmpty()) {
            System.out.println(" q.peek() " + q.peek().val);
            int first = index.peek();
            int last = 0;
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                last = index.poll();
                if (node != null) {
                    if (node.left != null) {
                        System.out.println("l " + node.left.val);
                        q.add(node.left);
                        index.add(2 * last);
                    }
                    if (node.right != null) {
                        System.out.println("r " + node.right.val);
                        q.add(node.right);
                        index.add(2 * last + 1);
                    }
                }
            }
            max = Math.max(max, last - first + 1);
            System.out.println("max" + (last - first + 1));
        }
        return max;
    }
}

class Solution {
    List<Integer> mins;
    List<Integer> maxs;
    int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        mins = new ArrayList<>();
        maxs = new ArrayList<>();
        maxWidth = 0;
        traverse(root, 0, 0);
        return maxWidth;
    }

    private void traverse(TreeNode node, int level, int val) {
        if (node == null) {
            return;
        }
        if (mins.size() <= level) {
            mins.add(val);
        }
        mins.set(level, Math.min(mins.get(level), val));
        if (maxs.size() <= level) {
            maxs.add(val);
        }
        maxs.set(level, Math.max(maxs.get(level), val));
        maxWidth = Math.max(maxWidth, maxs.get(level) - mins.get(level) + 1);
        traverse(node.left, level + 1, 2 * val);
        traverse(node.right, level + 1, 2 * val + 1);
    }
}
