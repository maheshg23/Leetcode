// 153. Find Minimum in Rotated Sorted Array 

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        if (nums[r] > nums[l])
            return nums[l];
        while (l < r) {
            int mid = (l + r) / 2;
            // System.out.println(nums[mid]);
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];
            if (nums[0] < nums[mid]) {
                // System.out.println("m "+nums[mid]);
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}

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
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}