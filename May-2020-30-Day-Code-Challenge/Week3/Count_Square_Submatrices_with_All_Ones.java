// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
// No. 1277 https://leetcode.com/problems/count-square-submatrices-with-all-ones/

//DP Solution
class Solution {
    public int countSquares(int[][] matrix) {
        
        int res = 0;
        
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0)  
                    continue;
                if(i >= 1 && j >= 1){
                    matrix[i][j] = Math.min(
                        Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1),
                        matrix[i-1][j-1]+1);
                }
                res += matrix[i][j];
            }
        }
        
        return res;
    }
}