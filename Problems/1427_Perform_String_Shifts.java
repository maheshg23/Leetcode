// // https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
// 1427. Perform String Shifts

class Solution {
    public String stringShift(String s, int[][] shift) {

        for (int[] a : shift) {
            if (a[0] == 0) {
                int n = a[1];
                while (n > 0) {
                    s = s.substring(1, s.length()) + s.substring(0, 1);
                    n--;
                }
            } else {
                int n = a[1];
                while (n > 0) {
                    s = s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
                    n--;
                }
            }
        }
        return s;
    }
}

class Solution {
    public String stringShift(String s, int[][] shift) {
        int shiftCount = 0;
        for (int[] a : shift) {
            if (a[0] == 0) {
                shiftCount += a[1];
            } else {
                shiftCount -= a[1];
            }
        }
        // System.out.println(shiftCount);
        shiftCount = shiftCount % s.length();
        if (Math.abs(shiftCount) == s.length())
            return s;
        else if (shiftCount > 0) {
            // left Shift
            s = s.substring(shiftCount) + s.substring(0, shiftCount);
        } else {
            // right Shift
            shiftCount = shiftCount * -1;
            s = s.substring(s.length() - shiftCount) + s.substring(0, s.length() - shiftCount);
        }
        return s;
    }
}