// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
// 231. Power of Two

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        while (n != 1) {
            if (n % 2 == 0)
                n = n / 2;
            else
                return false;
        }
        return true;
    }
}