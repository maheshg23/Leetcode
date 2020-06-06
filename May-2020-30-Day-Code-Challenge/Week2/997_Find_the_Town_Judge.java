// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
// No. 997 https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (N == 1 && trust.length == 0) return 1;
        
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int res = -1;
        
        for(int i = 0; i < trust.length; i++){
            if(!ls.contains(trust[i][0]))
                ls.add(trust[i][0]);
            if(hm.containsKey(trust[i][1])){
                hm.put(trust[i][1], hm.get(trust[i][1])+1);
            }else
                hm.put(trust[i][1], 1);
       
        }
        for(Map.Entry entry : hm.entrySet()){
            int k = (int) entry.getKey();
            int v = (int) entry.getValue();
            if( v == N-1 && !ls.contains(k)){
                res = k;
            }
        }
        return res;
    }
}