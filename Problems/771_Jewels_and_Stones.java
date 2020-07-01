// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
// 771. Jewels and Stones

class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }
        for (int j = 0; j < J.length(); j++) {
            if (hm.containsKey(J.charAt(j))) {
                res += hm.get(J.charAt(j));
            }
        }
        return res;
    }
}