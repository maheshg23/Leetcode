// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
// 468. Validate IP Address

class Solution {
    public String validIPAddress(String IP) {

        String hexdigits = "0123456789abcdefABCDEF";
        int count1 = 0;
        int count2 = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.')
                count1++;
            if (ch == ':')
                count2++;
        }
        if (IP.contains(".") && count1 == 3) {
            String[] str = IP.split("\\.", -1);
            for (String s : str) {
                if (s.length() == 0 || s.length() > 3 || (s.length() != 1 && s.charAt(0) == '0')) {
                    return "Neither";
                }
                for (char ch : s.toCharArray()) {
                    if (!Character.isDigit(ch)) {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(s) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":") && count2 == 7) {

            String[] str = IP.split(":", -1);
            for (String s : str) {
                if (s.length() == 0 || s.length() > 4) {
                    return "Neither";
                }
                for (char ch : s.toCharArray()) {
                    if (hexdigits.indexOf(ch) == -1)
                        return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}

// "172.16.254.1"
// "1.0.1."
// "let.0.1.4"
// ":::::::"