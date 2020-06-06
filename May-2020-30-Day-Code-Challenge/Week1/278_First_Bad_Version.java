// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
// No. 278 https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1, right = n;
        while(left < right){
            
            int mid = left + (right-left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}