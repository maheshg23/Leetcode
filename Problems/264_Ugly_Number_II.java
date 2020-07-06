// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
// 264. Ugly Number II

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0)
            return 0;

        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(ugly[index2] * 2, Math.min(ugly[index3] * 3, ugly[index5] * 5));
            ugly[i] = min;
            if (min == ugly[index2] * 2)
                index2++;
            if (min == ugly[index3] * 3)
                index3++;
            if (min == ugly[index5] * 5)
                index5++;
        }
        return ugly[n - 1];
    }
}