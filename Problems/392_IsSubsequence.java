// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
// 392. Is Subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = t.indexOf(s.charAt(i), prev + 1);
            if (prev >= idx) {
                return false;
            }
            prev = idx;
        }
        return true;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = t.indexOf(s.charAt(i));
            if (prev > idx) {
                return false;
            }
            prev = 0;
            t = t.substring(idx + 1);
        }
        return true;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;
        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == s.length())
            return true;
        else
            return false;
    }
}
