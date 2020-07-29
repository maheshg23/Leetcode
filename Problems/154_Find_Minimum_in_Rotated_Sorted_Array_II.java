// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
// 154. Find Minimum in Rotated Sorted Array II

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            // System.out.println(nums[mid]);
            if (nums[mid] < nums[r]) {
                // System.out.println("m "+nums[mid]);
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}