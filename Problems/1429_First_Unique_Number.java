// // https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
// 1429. First Unique Number

class FirstUnique {

    Queue<Integer> q;
    Map<Integer, Integer> hm;

    public FirstUnique(int[] nums) {
        q = new LinkedList<Integer>();
        hm = new HashMap<Integer, Integer>();
        for (int n : nums) {
            q.offer(n);
            if (!hm.containsKey(n)) {
                hm.put(n, 1);
            } else
                hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty()) {
            int top = q.peek();
            if (hm.get(top) == 1) {
                return top;
            } else {
                q.poll();
            }
        }
        return -1;
    }

    public void add(int value) {
        q.offer(value);
        if (!hm.containsKey(value)) {
            hm.put(value, 1);
        } else
            hm.put(value, hm.getOrDefault(value, 0) + 1);
    }
}
/**
 * Your FirstUnique object will be instantiated and called as such: FirstUnique
 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
