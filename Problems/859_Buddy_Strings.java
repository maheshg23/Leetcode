// 859. Buddy Strings

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (char ch : A.toCharArray()) {
                count[ch - 'a']++;
            }
            for (int c : count) {
                if (c > 1)
                    return true;
            }
            return false;
        } else {
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    diff.add(i);
                    if (diff.size() > 2)
                        return false;
                }
            }
            return diff.size() == 2 && (A.charAt(diff.get(0)) == B.charAt(diff.get(1)))
                    && (A.charAt(diff.get(1)) == B.charAt(diff.get(0)));
        }
    }
}