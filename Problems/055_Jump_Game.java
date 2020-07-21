// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
// 55. Jump Game

// DP Top-Down 
class Solution {
    public boolean canJump(int[] nums) {
        Character[] memo = new Character[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 'U';
        }
        memo[nums.length - 1] = 'G';
        return canJumpFrom(0, nums, memo);
    }

    public boolean canJumpFrom(int pos, int[] nums, Character[] memo) {
        if (memo[pos] == 'G')
            return true;
        else if (memo[pos] == 'B')
            return false;
        if (pos == nums.length - 1)
            return true;
        int farJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = farJump; i > pos; i--) {
            if (canJumpFrom(i, nums, memo)) {
                memo[pos] = 'G';
                return true;
            }
        }
        memo[pos] = 'B';
        return false;
    }
}

// DP Bottom Up
class Solution {
    public boolean canJump(int[] nums) {
        Character[] memo = new Character[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 'U';
        }
        memo[nums.length - 1] = 'G';
        for (int i = nums.length - 2; i >= 0; i--) {
            int farJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= farJump; j++) {
                if (memo[j] == 'G') {
                    memo[i] = 'G';
                    break;
                }
            }
        }
        return memo[0] == 'G';
    }
}

// Greedy // Faster
class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0 ? true : false;
    }
}