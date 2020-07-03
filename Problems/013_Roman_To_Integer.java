class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("M", 1000);
        hm.put("D", 500);
        hm.put("C", 100);
        hm.put("L", 50);
        hm.put("X", 10);
        hm.put("V", 5);
        hm.put("I", 1);

        int res = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int nextNum = hm.get(String.valueOf(s.charAt(i)));
            if (num > nextNum) {
                res -= nextNum;
            } else {
                res += nextNum;
            }
            num = nextNum;
        }
        return res;
    }
}