// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
// No. 169 https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        
        int res = 0;
        int n = nums.length;
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for (int i : nums) { 
            
            hm.put(i, hm.get(i) == null ? 1: hm.get(i)+1);
            
            if (hm.get(i) > ( n / 2)) {
                res = i;
                break;
            }
        }
        return res;
    }
}