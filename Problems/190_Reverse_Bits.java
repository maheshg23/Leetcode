// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
// 190. Reverse Bits

// 18ms 
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = String.format("%32s", Integer.toBinaryString(n));
        s = s.replace(" ", "0");
        int l = 0, r = s.length() - 1;
        StringBuilder string = new StringBuilder(s);
        while (l < r) {
            char c = s.charAt(l);
            string.setCharAt(l++, s.charAt(r));
            string.setCharAt(r--, c);
        }
        return Integer.parseUnsignedInt(string.toString(), 2);
    }
}

// 1ms
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, pow = 32;
        while (pow > 0) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
            pow--;
        }
        return res;
    }
}