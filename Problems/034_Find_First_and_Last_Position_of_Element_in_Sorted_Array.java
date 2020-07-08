// 34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[] { -1, -1 };
        int i = 0;
        while (i < 2) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    res[i] = mid;
                    if (i == 0)
                        r = mid - 1;
                    else
                        l = mid + 1;
                } else if (nums[mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            i++;
        }
        return res;
    }
}