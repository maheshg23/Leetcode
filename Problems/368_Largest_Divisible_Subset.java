// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
// 368. Largest Divisible Subset

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int[] count = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.sort(nums);
        int max = 0, index = -1;

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }
}