// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
// No. 387 https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        
        // create a set of chars
        Set<Character> hs = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // from the current i  position we find our 
            //first unique character that is not in the HashSet
            if (s.indexOf(c,i+1) < 0 && !hs.contains(c)) {
                return i;
            }else{
                //If we found a repeating char then we add it to the set
                hs.add(c);
            }
        }
        // didn't find anything
        return -1;
    }
}