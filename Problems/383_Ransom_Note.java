// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
// 383. Ransom Note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];
        for (char c : magazine.toCharArray()) {
            letters[c - 'a'] = letters[c - 'a'] + 1;
        }
        for (char c : ransomNote.toCharArray()) {
            if (letters[c - 'a'] == 0)
                return false;
            letters[c - 'a']--;
        }
        return true;
    }
}