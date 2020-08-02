class Solution {
    public int bitwiseComplement(int N) {

        String NStr = Integer.toBinaryString(N);
        String compStr = new String("");
        for (int i = 0; i < NStr.length(); i++) {
            compStr += (NStr.charAt(i) == '0') ? '1' : '0';
        }
        int compN = Integer.parseInt(compStr, 2);
        return compN;
    }
}