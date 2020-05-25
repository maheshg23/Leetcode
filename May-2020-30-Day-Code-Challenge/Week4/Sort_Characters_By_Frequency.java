// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
// No. 451 https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        
        String res = "";
        Map<Character,Integer> hm = new HashMap<>();
        for( char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a,b) -> hm.get(b) - hm.get(a));
        maxHeap.addAll(hm.keySet());
        
        while(maxHeap.peek() != null) {
            char ch = maxHeap.poll();
            for(int i = 0; i < hm.get(ch); i++) {
                res += ch;
            }
        }        
        return res;
    }
}