// 268. Missing Number

class Solution {
    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int currPos = nums[i] - 1;
            while (0 <= currPos && currPos < nums.length && nums[currPos] != nums[i]) {
                int temp = nums[currPos];
                nums[currPos] = nums[i];
                nums[i] = temp;
                currPos = nums[i] - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // System.out.println(nums[i]);
            if (nums[i] != i + 1)
                return i + 1;
        }
        return 0;
    }
}

class Solution {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }
}