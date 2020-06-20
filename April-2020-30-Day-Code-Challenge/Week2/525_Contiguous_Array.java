// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
// 525. Contiguous Array

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        hm.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (hm.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return maxLength;
    }
}