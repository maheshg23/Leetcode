// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
// No. 918 https://leetcode.com/problems/maximum-sum-circular-subarray/

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0;
        for (int n : A) {
            totalSum += n;
        }      
        int kMin = KardaneMin(A);
        int kMax = KardaneMax(A);

        //all elements in arr are negative:
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