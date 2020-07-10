// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
// 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        return check(nums, 0, nums.length - 1, target);
    }

    public int check(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        int a = check(nums, mid + 1, r, target);
        int b = check(nums, l, mid - 1, target);
        return Math.max(a, b);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int first, int last, int target) {
        if (first > last)
            return -1;
        int mid = (first + last) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[first] <= nums[mid]) // Left half is sorted
            if (nums[first] <= target && target <= nums[mid]) // target is in this sorted (left) half
                return search(nums, first, mid - 1, target);
            else // target must be in the right half
                return search(nums, mid + 1, last, target);
        if (nums[mid] <= nums[last])// Right half is sorted
            if (nums[mid] <= target && target <= nums[last]) // target is in this sorted (right) half
                return search(nums, mid + 1, last, target);
            else // target must be in left half
                return search(nums, first, mid - 1, target);
        return -1;
    }
}