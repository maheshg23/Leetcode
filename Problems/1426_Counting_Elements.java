// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3289/
// 1426. Counting Elements

class Solution {
    public int countElements(int[] arr) {

        Set<Integer> hs = new HashSet<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i] + 1))
                res++;
        }
        return res;
    }
}

// One Pass
/*
 * Keep 2 arrays. One for presentee and another for count. Every element when
 * visited is present. So present[x] = 1 (you can also use a boolean array
 * here). Every element adds all previous elements that were just 1 behind it.
 * So, cnt += map[x-1]. To make sure we don't add any element twice, we do
 * map[x-1] = 0. Now, for the current element, if we have a number greater by 1
 * already in present[x+1], we add current element to cnt, else we set it in
 * map[x]++ for future addition.
 */
class Solution {
    public int countElements(int[] arr) {
        int[] count = new int[1005];
        int[] present = new int[1005];
        int cnt = 0;
        for (int x : arr) {
            present[x] = 1;
            if (x - 1 >= 0) {
                cnt += count[x - 1];
                count[x - 1] = 0;
            }
            if (present[x + 1] > 0)
                cnt++;
            else
                count[x]++;
        }
        return cnt;
    }
}