// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
// 50. Pow(x, n)

// Faster Recursion
class Solution {
    public double myPow(double x, int n) {

        if (n == Integer.MIN_VALUE && x > 1)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

// Slower Iterative
class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 1;
        if (x == 1)
            return 1;
        if (x == -1)
            return (n % 2 == 0) ? 1 : -1;
        if (n == 1)
            return x;
        double res = 1;
        if (n > 0) {
            while (n > 0) {
                res *= x;
                if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY || res == 0d) {
                    return res;
                }
                n--;
            }
        } else {
            while (n < 0) {
                res /= x;
                if (res == 0d || res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY) {
                    return 0;
                }
                n++;
            }
        }
        return res;
    }
}
