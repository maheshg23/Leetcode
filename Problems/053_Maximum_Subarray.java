// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
// 53. Maximum Subarray

//Brute Force
class Solution {
    public int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 1; j <= nums.length; j++) {
                if (i + j > nums.length)
                    break;
                sum += nums[i + j - 1];
                if (sum > res)
                    res = sum;
            }
        }
        return res;
    }
}

// Divide and Conquer
class Solution {
    public int maxSubArray(int[] nums) {

        return subArray(nums, 0, nums.length - 1);

    }

    public int subArray(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];
        int mid = l + (r - l) / 2;

        int leftSub = subArray(nums, l, mid);
        int rightSub = subArray(nums, mid + 1, r);
        int singleSum = Math.max(leftSub, rightSub);

        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        sum = 0;
        for (int i = mid; i >= l; i--) {
            sum += nums[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        return Math.max(leftSum + rightSum, singleSum);
    }
}

// DP
class Solution {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            globalMax = Math.max(globalMax, max);

        }
        return globalMax;
    }
}