// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/
// 525. Contiguous Array

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : +1;
            int subLength = 0;
            if (sum == 0) {
                subLength = i + 1;
                if (maxLength < subLength) {
                    maxLength = subLength;
                }
                continue;
            }
            if (hm.containsKey(sum)) {
                subLength = i - hm.get(sum);
                if (maxLength < subLength) {
                    maxLength = subLength;
                }
            } else {
                hm.put(sum, i);
            }
        }
        return maxLength;
    }
}

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