// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
// 283 https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
            j++;
        }
    }
}