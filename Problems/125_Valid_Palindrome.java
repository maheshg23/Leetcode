// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
// 125. Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r) {
            // System.out.println(" l "+l+" r "+r);
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                // System.out.println("left l " + l + " r " + r);
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                // System.out.println("right l " + l + " r " + r);
                r--;
            } else if (s.charAt(l) != s.charAt(r)) {
                // System.out.println("false l " + l + " r " + r);
                return false;
            } else {
                // System.out.println("equal l " + l + " r " + r);
                l++;
                r--;
            }
        }
        return true;
    }
}
