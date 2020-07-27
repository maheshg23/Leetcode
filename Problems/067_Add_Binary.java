// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
// 67. Add Binary

class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
            int n2 = j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;
            int temp = (n1 % 10 + n2 % 10 + carry) % 2;
            sb.append(temp);
            // sb.insert(0, temp);
            carry = (n1 % 10 + n2 % 10 + carry) / 2;
            i--;
            j--;
        }
        if (carry != 0)
            sb.append(carry);
        // sb.insert(0, carry);
        return sb.reverse().toString();
        // return sb.toString();
    }
}