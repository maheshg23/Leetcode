// 213. House Robber II

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(subRob(nums, 0, nums.length - 2), subRob(nums, 1, nums.length - 1));
    }

    public int subRob(int[] nums, int l, int n) {
        // System.out.println("l " + nums[l] + " n " + nums[n]);
        int[] dp = new int[n - l + 1];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        for (int i = 2; i < n - l + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[l + i], dp[i - 1]);
            // System.out.println(" d " + dp[i]);
        }
        // System.out.println(dp[n - l]);
        return dp[n - l];
    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        int[] dp = new int[len];
        // the first element used, so the last element can not be used
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        int use = dp[len - 2];
        // the first element is not used, so the last element can be used
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        int inuse = dp[len - 1];
        return Math.max(use, inuse);
    }
}