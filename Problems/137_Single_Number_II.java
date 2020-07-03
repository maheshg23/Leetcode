// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
// 137. Single Number II

import java.math.BigInteger;

class Solution {
    public int singleNumber(int[] nums) {
        BigInteger sum = new BigInteger("0");
        BigInteger parSum = new BigInteger("0");
        Set<Integer> hs = new HashSet<>();
        for (int a : nums) {
            if (!hs.contains(a)) {
                hs.add(a);
                parSum = parSum.add(BigInteger.valueOf(a));
            }
            sum = sum.add(BigInteger.valueOf(a));
        }
        BigInteger res = parSum.multiply(BigInteger.valueOf(3)).add(sum.negate()).divide(BigInteger.valueOf(2));
        // return (3 * parSum - sum) / 2;
        return res.intValue();
    }
}

class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int a : nums) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        for (int a : nums) {
            if (hm.get(a) == 1)
                return a;
        }
        return 0;
    }
}

class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int a : nums) {
            Integer n = hm.get(a);
            if (null == n)
                hm.put(a, 1);
            else if (n == 1)
                hm.put(a, 2);
            else
                hm.remove(n);
        }
        System.out.println(hm.keySet());
        return hm.keySet().toArray(new Integer[0])[0];
    }
}