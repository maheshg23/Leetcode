class Solution {
    public String longestCommonPrefix(String[] strs) {

        String res = "";
        char current;
        int min = 0;
        if (strs.length == 0)
            return "";
        min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min)
                min = strs[i].length();
        }

        for (int i = 0; i < min; i++) {
            current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return res;
                }
            }
            res = res + current;
        }
        return res;
    }
}