// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
// 441. Arranging Coins

class Solution {
    public int arrangeCoins(int n) {
        long res = 0;
        long l = 1, r = n;
        while (l <= r) {
            long k = l + (r - l) / 2;
            if (k * (k + 1) / 2 == n)
                return (int) k;
            else if (k * (k + 1) / 2 < n) {
                l = k + 1;
            } else {
                r = k - 1;
            }
        }
        return (int) r;
    }
}