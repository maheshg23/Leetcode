// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
// 66. Plus One

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            res.add(0, (digits[i] + c) % 10);
            c = (digits[i] + c) / 10;
        }
        if (c > 0)
            res.add(0, c % 10);
        int[] res1 = new int[res.size()];
        for (int i = 0; i < res1.length; i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }
}