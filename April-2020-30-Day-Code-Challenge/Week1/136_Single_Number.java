// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
// 136 https://leetcode.com/problems/single-number/

class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i : nums) {
      hm.put(i, hm.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (hm.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
}