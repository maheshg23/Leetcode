// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
// 560. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {

        int res = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                System.out.println(" si " + sum[i] + " sj " + sum[j]);
                System.out.println(" i " + i + " j " + j);
                if (sum[j] - sum[i] == k) {
                    System.out.println("res  si " + sum[i] + " sj " + sum[j]);
                    res++;
                }
            }
        }
        return res;
    }
}

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length < 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                c++;
            }
            if (map.containsKey(sum - k))
                c += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return c;
    }
}
