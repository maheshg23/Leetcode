// 139. Word Break

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0)
            return true;
        if (memo.containsKey(s))
            return memo.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict))
                    return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}