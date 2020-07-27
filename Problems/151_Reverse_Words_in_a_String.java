// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
// 151. Reverse Words in a String

class Solution {
    public String reverseWords(String s) {

        String[] words = s.trim().split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            // if(!words[i].isEmpty()){
            if (!words[i].equals("")) {
                str.append(words[i].trim());
                str.append(" ");
            }
        }
        return str.toString().trim();
    }
}