
class Solution {
    public String countAndSay(int n) {

        if (n <= 0)
            return "";
        String res = "1";
        for (int i = 1; i <= n - 1; i++) {
            StringBuilder str = new StringBuilder();
            int count = 1;
            for (int j = 0; j < res.length(); j++) {
                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }
                str.append(count).append(res.charAt(j));
                count = 1;
            }
            res = str.toString();
        }
        return res;
    }
}