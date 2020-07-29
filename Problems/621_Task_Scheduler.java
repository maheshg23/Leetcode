// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
// 621. Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        Map<Character, Integer> hm = new HashMap<>();
        int count = 0;
        for (Character ch : tasks) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(hm.values());

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.remove());
                }
            }
            for (int a : list)
                if (--a > 0)
                    pq.add(a);
            count += pq.isEmpty() ? list.size() : n + 1;
        }
        return count;
    }
}