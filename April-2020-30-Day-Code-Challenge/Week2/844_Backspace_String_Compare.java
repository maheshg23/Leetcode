// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
// 844 https://leetcode.com/problems/backspace-string-compare/

// Recursive Logic
class Solution {
    public boolean backspaceCompare(String S, String T) {

        S = removeBackSpace(S);
        T = removeBackSpace(T);
        return S.equals(T);
    }

    public String removeBackSpace(String s) {

        if (s.indexOf("#") >= 0) {
            int i = s.indexOf("#");
            if (i == 0)
                s = s.substring(i + 1);
            else
                s = s.substring(0, i - 1) + s.substring(i + 1);
            return removeBackSpace(s);
        } else {
            return s;
        }
    }
}

// Iterative Logic
class Solution {
    public boolean backspaceCompare(String S, String T) {

        S = removeBackSpace(S);
        T = removeBackSpace(T);
        return S.equals(T);
    }

    public String removeBackSpace(String s) {

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}