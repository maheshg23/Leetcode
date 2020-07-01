// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
// 367. Valid Perfect Square

class Solution {
    public boolean isPerfectSquare(int num) {

        int l = 1, r = num;
        long square = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                r = (int) mid - 1;
            } else {
                l = (int) mid + 1;
            }
        }
        return false;
    }
}