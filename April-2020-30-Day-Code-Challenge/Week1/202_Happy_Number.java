// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
// 202 https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {

        Set<Integer> hs = new HashSet<Integer>();
        while (n != 1) {
            int num = 0;
            if (hs.contains(n))
                return false;
            hs.add(n);
            while (n != 0) {
                num += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = num;
        }
        return true;
    }
}