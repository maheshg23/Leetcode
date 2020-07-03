class Solution {
    public int reverse(int x) {

        boolean isNegative = x < 0 ? true : false;
        if (x < 0) {
            x = x * -1;
        }
        int rev = 0;
        int digit = 0;

        while (x >= 1) {
            if ((long) rev * 10 > Integer.MAX_VALUE || (long) rev * 10 < Integer.MIN_VALUE) {
                return 0;
            }
            digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return isNegative == true ? rev * -1 : rev;
    }
}