// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
// No. 1232 https://leetcode.com/problems/check-if-it-is-a-straight-line/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if(coordinates.length == 2)
            return true;
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
            
        for (int i = 2; i<coordinates.length;i++) {    
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if(!((y-y1)*(x2-x1) == (y2-y1)*(x-x1))){
               return false; 
            }
        }
        return true;
    }
}