
// 9ms faster
class Solution {
    String[] numberString = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        check(result, "", digits, 0);

        return result;
    }

    public void check(List<String> result, String combination, String digits, int d) {

        if (digits.length() == 0) {
            result.add(combination);
            return;
        }
        int digit = digits.charAt(0) - '0';
        digits = digits.substring(1);
        String str = numberString[digit];
        for (int i = 0; i < str.length(); i++) {
            check(result, combination + str.charAt(i), digits, d++);
        }
    }
}

// 13ms
class Solution {

    String[] nubmerString = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        check(result, "", digits, 0);
        return result;
    }

    public void check(List<String> result, String combination, String digits, int d) {
        if (d >= digits.length()) {
            result.add(combination);
            return;
        }
        String sel = nubmerString[Character.getNumericValue(digits.charAt(d))];
        for (char c : sel.toCharArray()) {
            combination = combination + c;
            check(result, combination, digits, d + 1);
            combination = combination.substring(0, combination.length() - 1);
        }
    }
}