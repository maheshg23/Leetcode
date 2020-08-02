// 28. Implement strStr()

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        // return haystack.indexOf(needle);
        int L = needle.length();
        for (int i = 0; i < haystack.length() - L + 1; i++) {
            // if(haystack.substring(i,i+L).equals(needle))
            // return i;
            int c = 0;
            while (c < needle.length() && haystack.charAt(i + c) == needle.charAt(c))
                c++;
            if (c == needle.length())
                return i;
        }
        return -1;
    }
}