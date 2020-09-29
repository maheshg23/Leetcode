// 191. Number of 1 Bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        for (char ch : Integer.toBinaryString(n).toCharArray()) {
            if (ch == '1')
                c++;
        }
        return c;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                c++;
            mask <<= 1;
        }
        return c;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            c += n & 1;
            n >>= 1;
        }
        return c;
    }
}
