// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
// 140. Word Break II

class Solution {

    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s))
            return memo.get(s);
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length())
                    res.add(word);
                else {
                    List<String> sub = wordBreak(s.substring(word.length()), wordDict);
                    for (String w : sub)
                        res.add(word + " " + w);
                }
            }
        }
        memo.put(s, res);
        return memo.get(s);
    }
}

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() > 100)
            return new ArrayList();
        List<String> res = new ArrayList<>();
        wordBreakHelper(s, wordDict, res, new StringBuilder());
        return res;
    }

    public void wordBreakHelper(String s, List<String> wordDict, List<String> res, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append(" ");
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.append(word);
                if (s.equals(word))
                    res.add(new String(newSb));
                else
                    wordBreakHelper(s.substring(word.length()), wordDict, res, newSb);
            }
        }
    }
}