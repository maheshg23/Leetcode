// // https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int sum = 0;
        while (m > 0 && n > 0) {
            int i = findMSB(m);
            int j = findMSB(n);
            if (i != j) {
                break;
            }
            sum += (1 << i);
            m = m - (1 << i);
            n = n - (1 << i);
        }
        return sum;
    }

    public int findMSB(int a) {
        int i = -1;
        while (a > 0) {
            a = a >> 1;
            i++;
        }
        return i;
    }
}