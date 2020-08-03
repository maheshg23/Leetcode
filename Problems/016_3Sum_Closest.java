// 16. 3Sum Closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Two Pointer
        Arrays.sort(nums);
        int min = 999, finRes = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    finRes = sum;
                }
            }
        }
        return finRes;
    }
}