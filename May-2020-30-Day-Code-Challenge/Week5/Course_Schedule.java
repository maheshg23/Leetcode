// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
// No. 207 https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i =0; i< prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]); 
        }
        
        //0 - Unvisited , 1 - Processed , 2 - Processing
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            visited[i] = 0;
        }
        
        for(int i = 0; i < numCourses; i++){ 
            if(visited[i] == 0)
                if(topoCycle(adj, visited, i))
                    return false;;
        }
        return true;
    }
    
    public boolean topoCycle(List<List<Integer>> list, int[] visited, int curr){
        if(visited[curr] == 2) return true;
        
        visited[curr] = 2;
        
        for(int next: list.get(curr)) {
            if(visited[next]!=1)
                if(topoCycle(list, visited, next)) return true;
        }  
        visited[curr] = 1;
        return false;
    }
}