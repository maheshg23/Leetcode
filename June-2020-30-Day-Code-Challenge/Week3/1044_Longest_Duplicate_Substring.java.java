// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3365/
// 1044. Longest Duplicate Substring 

class Solution {
    public String longestDupSubstring(String S) {

        int l = 0, h = S.length() - 1;
        String res = "";
        while (l <= h) {
            int mid = l + (h - l) / 2;
            String ans = checkDuplicates(S, mid);
            if (ans != null) {
                res = ans;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return res;
    }

    public String checkDuplicates(String s, int n) {
        long prime = 31;
        long a = 1;
        long hash = 0;
        for (int i = n; i >= 1; i--) {
            hash += (s.charAt(i - 1) - 'a' + 1) * a;
            a = (a * prime);
        }

        HashSet<Long> hs = new HashSet<>();
        hs.add(hash);

        long pow = 1;
        for (int i = 1; i < n; i++)
            pow = (pow * prime);

        for (int i = n; i < s.length(); i++) {
            hash = (hash - (s.charAt(i - n) - 'a' + 1) * pow) * prime + (s.charAt(i) - 'a' + 1);
            if (hs.contains(hash)) {
                return s.substring(i - n + 1, i + 1);
            }
            hs.add(hash);
        }
        return null;
    }
}

class Solution {
    public String longestDupSubstring(String S) {
        String ans = "";
        int left = 0;
        int right = S.length() - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            System.out.println("mid " + m);
            String dup = getDup(S, m);
            if (dup != null) {
                ans = dup;
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return ans;
    }

    private String getDup(String s, int size) {
        long hash = 0;
        long a = 1;
        // int n = s.length();
        for (int k = size; k >= 1; k--) {
            char ch = s.charAt(k - 1);
            hash += (ch - 'a' + 1) * a;
            a = (a * 31);
        }
        HashSet<Long> set = new HashSet();
        set.add(hash);
        System.out.println("check " + hash);
        long pow = 1;
        for (int i = 1; i < size; i++)
            pow = (pow * 31);

        for (int i = size; i < s.length(); i++) {
            hash = (hash - (s.charAt(i - size) - 'a' + 1) * pow) * 31 + (s.charAt(i) - 'a' + 1);
            if (!set.add(hash)) {
                return s.substring(i - size + 1, i + 1);
            }
        }
        return null;
    }
}