// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
// 461. Hamming Distance

class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (char c : Integer.toBinaryString(x ^ y).toCharArray()) {
            if (c == '1')
                count++;
        }
        return count;
    }
}

// Faster
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        while (z > 0) {
            if (z % 2 == 1)
                count++;
            z = z >> 1;
        }
        return count;
    }
}