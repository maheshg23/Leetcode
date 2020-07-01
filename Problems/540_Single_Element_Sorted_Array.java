// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
// 540. Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == 0) {
                res = nums[i];
            } else {
                if (nums[i] == res) {
                    res = 0;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}