// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
// 275. H-Index II

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length - 1;
        int l = 0, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (n - mid + 1 == citations[mid])
                return n - mid + 1;
            if (n - mid + 1 > citations[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - l + 1;
    }
}
