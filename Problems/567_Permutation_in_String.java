// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
// 567. Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2 == null || s2.length() == 0 || s2.length() < s1.length())
            return false;

        int[] s1array = new int[26];
        int[] s2array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1array[s1.charAt(i) - 'a']++;
            s2array[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isMatch(s2array, s1array)) {
                return true;
            }
            s2array[s2.charAt(i + s1.length()) - 'a']++;
            s2array[s2.charAt(i) - 'a']--;
        }
        if (isMatch(s2array, s1array)) {
            return true;
        }
        return false;
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
