// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
// 96. Unique Binary Search Trees

class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }
}

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (!map.containsKey(i - 1)) {
                map.put(i - 1, numTrees(i - 1));
            }
            if (!map.containsKey(n - i)) {
                map.put(n - i, numTrees(n - i));
            }
            sum += map.get(i - 1) * map.get(n - i);
        }
        return sum;
    }
}

class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1; // init
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) { // sum
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
