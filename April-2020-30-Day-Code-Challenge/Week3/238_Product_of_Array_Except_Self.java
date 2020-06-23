// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
// 238. Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] out = new int[nums.length];
        out[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            out[i] = nums[i - 1] * out[i - 1];
        }
        int mul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= mul;
            mul *= nums[i];
        }
        return out;
    }
}

// Space optimized
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] out = new int[nums.length];
        int mul = 1;
        // for(int i = 0, j=nums.length-1; i < nums.length && j>=0; i++,j--){
        for (int i = 0; i < nums.length; i++) {
            out[i] = mul;
            mul *= nums[i];
        }
        mul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= mul;
            mul *= nums[i];
        }
        return out;
    }
}