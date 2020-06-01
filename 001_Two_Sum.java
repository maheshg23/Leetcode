class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(hm.containsKey(num)){
                return new int[] {hm.get(num), i};
            }
            hm.put(nums[i],i);            
        }
        return new int[] {-1,-1};
    }
}