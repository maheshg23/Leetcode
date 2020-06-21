//
// 60. Permutation Sequence

class Solution {
    public String getPermutation(int n, int k) {

        String res = "";
        int[] fact = new int[n + 1];
        List<Integer> digits = new ArrayList<>();
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            digits.add(i);
        }

        k = k - 1;
        for (int i = n; i >= 1; i--) {
            int index = (k / fact[i - 1]);
            res += digits.remove(index);
            k = k - fact[i - 1] * index;
        }
        return res;
    }
}