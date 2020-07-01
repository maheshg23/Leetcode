// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
// 49. Group Anagrams

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, Integer> hm = new HashMap<>();
        int index = 0;

        for (int i = 0; i < strs.length; i++) {

            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String word = new String(str);

            if (!hm.containsKey(word)) {
                hm.put(word, index);
                res.add(new ArrayList());
                res.get(index++).add(strs[i]);
            } else {
                int key = hm.get(word);
                res.get(key).add(strs[i]);
            }
        }
        return res;
    }
}