class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[1];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = 0;
        for (int i = 2; i <= nums.length - 1; i++) {
            dp[i] = dp[i - 2] + nums[i];
            // System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i > 1)
                nums[i] = Math.max(max, nums[i - 2] + nums[i]);
            nums[i] = Math.max(nums[i - 1], nums[i]);
        }
        return nums[nums.length - 1];
    }
}