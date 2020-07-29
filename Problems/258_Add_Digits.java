// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3402/
// 258. Add Digits

class Solution {
    public int addDigits(int num) {
        while (num > 10) {
            int res = 0;
            while (num != 0) {
                res += num % 10;
                num = num / 10;
            }
            num = res;
        }
        return num;
    }
}