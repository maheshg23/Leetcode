// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
// 438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //Sliding Windows technique
        List<Integer> res = new ArrayList();
        if(s == null || s.length() == 0 || s.length() < p.length() )
            return res;
        
        int[] parray = new int[26];
        int[] sarray = new int[26];
        for(int i = 0; i < p.length(); i++){
            parray[p.charAt(i) - 'a']++; 
        }
        for(int i = 0; i < p.length(); i++){
            sarray[s.charAt(i) - 'a']++; 
        }
        
        for(int i = 0; i < s.length() - p.length(); i++){
            if(isMatch(sarray, parray)){
                res.add(i);
            }
            sarray[s.charAt(i + p.length()) - 'a']++;
            sarray[s.charAt(i) - 'a']--;
        }
        if(isMatch(sarray, parray))
            res.add(s.length() - p.length());
        return res;
    }
    
    public boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
            return false;
            }
        }
        return true;
    }
    
}