// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
// 476. Number Complement

class Solution {
    public int findComplement(int num) {
        String NStr = Integer.toBinaryString(num);
        String compStr = new String("");
        for (int i = 0; i < NStr.length(); i++) {
            compStr += (NStr.charAt(i) == '0') ? '1' : '0';
        }
        int compN = Integer.parseInt(compStr, 2);
        return compN;
    }
}