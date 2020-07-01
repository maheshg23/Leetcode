// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
// 918. Maximum Sum Circular Subarray

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0;
        for (int n : A) {
            totalSum += n;
        }
        int kMin = KardaneMin(A);
        int kMax = KardaneMax(A);

        // all elements in arr are negative:
        if (kMin == totalSum) {
            return kMax;
        }
        return Math.max(kMax, totalSum - kMin);
    }

    public int KardaneMin(int[] A) {
        int minSum = A[0];
        int currSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currSum = Math.min(A[i], currSum + A[i]);
            minSum = Math.min(minSum, currSum);
        }
        return minSum;
    }

    public int KardaneMax(int[] A) {
        int maxSum = A[0];
        int currSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currSum = Math.max(A[i], currSum + A[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

// Using DP method of Max Subarray
class Solution {
    public int maxSubarraySumCircular(int[] A) {

        int case1 = findMax(A);

        // case2: **----**
        // sum - min sum of subarray of A => sum - (- max sum of subarray of -A)
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            A[i] = -A[i];
        }
        int case2 = sum + findMax(A);

        // if sum == min sum of subarray of A, return case1. eg. [-1, -2, -3]
        if (case2 == 0)
            return case1;
        return Math.max(case1, case2);
    }

    // No 53 Max Subarray
    // Kadane's algorithm
    public int findMax(int[] nums) {
        int max = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }
}
