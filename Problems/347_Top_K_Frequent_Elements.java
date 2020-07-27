// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
// 347. Top K Frequent Elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(a) - hm.get(b));
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int a : hm.keySet()) {
            pq.add(a);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}