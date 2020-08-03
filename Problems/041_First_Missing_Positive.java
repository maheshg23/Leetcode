// 41. First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int currPos = nums[i] - 1;
            while ((0 <= currPos && currPos < nums.length) && nums[currPos] != nums[i]) {
                int temp = nums[currPos];
                nums[currPos] = nums[i];
                nums[i] = temp;
                currPos = nums[i] - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}