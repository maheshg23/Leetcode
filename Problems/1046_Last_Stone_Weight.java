// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
// 1046. Last Stone Weight

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int a : stones) {
            pq.add(a);
        }

        while (!pq.isEmpty() && pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.add(y - x);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}