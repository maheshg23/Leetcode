// 58. Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if (str.length != 0)
            return str[str.length - 1].length();
        else
            return 0;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) == ' ') {
                break;
            }
            idx--;
        }
        return s.length() - 1 - idx;
    }
}