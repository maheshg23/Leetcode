// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
// 678. Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                low++;
            else
                low--;
            if (c != ')')
                high++;
            else
                high--;
            if (high < 0)
                break;
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}