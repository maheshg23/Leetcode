// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
// 78. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSub = new ArrayList<>();
            // ls.add(nums[i]);

            for (List<Integer> a : res) {
                List<Integer> newLs = new ArrayList<>(a);
                newLs.add(nums[i]);
                newSub.add(newLs);
            }
            for (List<Integer> list : newSub) {
                res.add(list);
            }
        }
        return res;
    }
}