// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
// No. 402 https://leetcode.com/problems/remove-k-digits/

// Using Stacks 
class Solution {
    public String removeKdigits(String num, int k) {
         if(k==0 ) return num;
        if(num.length() <= k) return "0";
    
        String res = "";
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < num.length(); i++) {
            int val = Integer.parseInt(String.valueOf(num.charAt(i)));
            while (!st.empty() && val < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            if(!st.isEmpty() || val != 0) {
                st.push(val);
            }     
        } 
        while( k > 0){
            st.pop();
            k--;            
        } 
        
        while (!st.isEmpty()) 
           res = st.pop() + res;
        
        if(res.isEmpty()) return "0";
        
        return res;
    }
}

//Using Arrays
class Solution {
    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        int stackLength = 0; // "stack" will be located in digits array, starting from 0 index
        for (char currentDigit: digits) {
            while (k > 0 && stackLength > 0 && digits[stackLength - 1] > currentDigit) {
                stackLength--;
                k--;
            }
            
            if (stackLength > 0 || currentDigit != '0') {
                digits[stackLength++] = currentDigit;
            }
        }
        
        stackLength -= k;
        return stackLength <= 0 ? "0" : String.valueOf(digits, 0, stackLength);
    }
}