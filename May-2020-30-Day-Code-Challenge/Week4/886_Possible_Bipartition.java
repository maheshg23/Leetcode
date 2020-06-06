// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
// No. 886 https://leetcode.com/problems/possible-bipartition/

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        
        List<Integer>[] graph = new ArrayList[N];
        
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList();
        }
        
        for( int[] a : dislikes){
            graph[a[0]-1].add(a[1]-1);
            graph[a[1]-1].add(a[0]-1);
        }
        int[] colors = new int[N];
        
        for(int i = 0; i < N; i++){
            if(colors[i] != 0)
                continue;
            colors[i] = 1;
            
            Queue<Integer> queue = new LinkedList();
            queue.add(i);
            
            while(!queue.isEmpty()){
                int curr = queue.poll();
                
                for(int adj: graph[curr]){
                    if(colors[adj] == colors[curr])
                        return false;
                    if(colors[adj] == 0){
                        colors[adj] = -colors[curr];
                        queue.add(adj);
                    }
                }
            }
            
        }
        return true;
    }
}