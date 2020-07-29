// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
// 260. Single Number III

class Solution {
    public int[] singleNumber(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            Integer a = hm.get(n);
            if (null == a)
                hm.put(n, 1);
            else if (a == 1)
                hm.remove(n);
        }
        int i = 0;
        int[] res = new int[2];
        for (int n : hm.keySet()) {
            res[i++] = n;
        }
        System.out.println(hm.keySet());
        return res;
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            if (!hm.containsKey(n))
                hm.put(n, 1);
            else
                hm.remove(n);
        }
        int i = 0;
        int[] res = new int[2];
        for (int n : hm.keySet()) {
            res[i++] = n;
        }
        return res;
    }
}