// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
// 75 Sort Color 

class Solution {
    public void sortColors(int[] nums) {

        int start = 0, end = nums.length - 1, idx = 0;
        while (idx <= end) {
            if (nums[idx] == 0) {
                nums[idx] = nums[start];
                nums[start] = 0;
                start++;
                idx++;
            } else if (nums[idx] == 2) {
                nums[idx] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                idx++;
            }
        }
    }
}