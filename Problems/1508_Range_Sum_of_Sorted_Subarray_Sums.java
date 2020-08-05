// 1508. Range Sum of Sorted Subarray Sums

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        List<Integer> ls = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            ls.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                ls.add(sum);
            }
        }
        Collections.sort(ls);
        for (int i = left - 1; i < right; i++) {
            res = (res % MOD + ls.get(i) % MOD);
        }
        return res;
    }
}