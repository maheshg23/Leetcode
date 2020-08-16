// 987. Vertical Order Traversal of a Binary Tree

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, Map<Integer, List<Integer>>> hm = new HashMap<>();

        find(root, 0, 0, hm);

        List<Integer> hmKeys = new ArrayList<>(hm.keySet());
        Collections.sort(hmKeys);
        for (int hmk : hmKeys) {
            res.add(new ArrayList<>());
            List<Integer> keys = new ArrayList<>(hm.get(hmk).keySet());
            Collections.sort(keys);
            for (int n : keys) {
                // System.out.println(n);
                List a = hm.get(hmk).get(n);
                Collections.sort(a);
                res.get(res.size() - 1).addAll(a);
            }
        }
        return res;
    }

    public void find(TreeNode node, int x, int y, Map<Integer, Map<Integer, List<Integer>>> hm) {
        if (node == null)
            return;
        if (!hm.containsKey(x)) {
            hm.put(x, new HashMap<>());
        }
        if (!hm.get(x).containsKey(y)) {
            hm.get(x).put(y, new ArrayList<>());
        }

        hm.get(x).get(y).add(node.val);

        find(node.left, x - 1, y + 1, hm);
        find(node.right, x + 1, y + 1, hm);
    }
}

//
class Solution {
    int l = 0, r = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<int[]>> hm = new HashMap<>();
        traverse(hm, root, 0, 0);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<int[]> lis = hm.get(i);
            Collections.sort(lis, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0])
                        return a[1] - b[1];
                    return a[0] - b[0];
                }
            });
            List<Integer> cur = new ArrayList<>();
            for (int[] arr : lis)
                cur.add(arr[1]);
            ret.add(cur);
        }
        return ret;
    }

    private void traverse(HashMap<Integer, List<int[]>> hm, TreeNode root, int x, int y) {
        if (root == null)
            return;

        if (hm.containsKey(x)) {
            List<int[]> tmp = hm.get(x);
            tmp.add(new int[] { y, root.val });
            hm.put(x, tmp);
        } else {
            List<int[]> tmp = new ArrayList<>();
            tmp.add(new int[] { y, root.val });
            hm.put(x, tmp);
        }

        if (root.left != null) {
            traverse(hm, root.left, x - 1, y + 1);
            l = Math.min(x - 1, l);
        }
        if (root.right != null) {
            traverse(hm, root.right, x + 1, y + 1);
            r = Math.max(r, x + 1);
        }
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */