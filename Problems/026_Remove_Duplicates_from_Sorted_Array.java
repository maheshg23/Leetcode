// 26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, temp = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i = i + 1;
                if (nums[i] != nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return i + 1;
    }
}