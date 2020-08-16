class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] pos = new int[128];
        int j = 0, max = 0, curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pos[s.charAt(i)] == 0) {
                pos[s.charAt(i)] = i + 1;
                curr++;
                if (curr > max)
                    max = curr;
                // System.out.println("char " + s.charAt(i) + " i " + i);
            } else {
                // System.out.println("Else char " + s.charAt(i) + " i " + i);
                int index = pos[s.charAt(i)] - 1;
                while (j <= index) {
                    pos[s.charAt(j)] = 0;
                    j++;
                }
                curr = i - j + 1;
                pos[s.charAt(i)] = i + 1;
                // System.out.println("End char " + s.charAt(i) + " i " + i + " j " + j+ " curr
                // " + curr);
            }
        }
        return max;
    }
}

// My Solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            str += s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (!str.contains(String.valueOf(s.charAt(j)))) {
                    str += s.charAt(j);
                } else {
                    break;
                }

            }
            res = Math.max(res, str.length());
        }
        return res;
    }
}

// Sliding Window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
