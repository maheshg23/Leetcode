class Solution {
    private List<Integer> list = new ArrayList<Integer>();
    private int total = 0;

    public Solution(int[] w) {
        for (int a : w) {
            total += a;
            list.add(total);
        }
    }

    public int pickIndex() {
        int res = 0;
        int rand = (int) (Math.random() * total);
        res = binarySearch(rand + 1);
        return res;
    }

    public int binarySearch(int val) {
        int l = 0, r = list.size() - 1;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (list.get(mid) == val)
                return mid;
            else if (list.get(mid) < val)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */