// 204. Count Primes

class Solution {
    public int countPrimes(int n) {
        int c = 0;
        boolean[] prime = new boolean[n];

        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if (!prime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 2; i < n; i++)
            if (prime[i])
                c++;
        return c;
    }
}