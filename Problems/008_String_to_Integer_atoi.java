class Solution {
    public int myAtoi(String str) {
        boolean noWhiteSpaceChar = false, isPositiveNumber = true;
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                noWhiteSpaceChar = true;
                final int digit = c - '0';
                if ((Integer.MAX_VALUE - digit) / 10 < number) {
                    return isPositiveNumber ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number *= 10;
                number += digit;
            } else if (!noWhiteSpaceChar && c == '+') {
                noWhiteSpaceChar = true;
                isPositiveNumber = true;
            } else if (!noWhiteSpaceChar && c == '-') {
                noWhiteSpaceChar = true;
                isPositiveNumber = false;
            } else if (noWhiteSpaceChar || c != ' ') {
                break;
            }
        }
        return isPositiveNumber ? number : -number;
    }
}