// 211. Add and Search Word - Data structure design

class WordDictionary {

    private TrieNode root;

    static class TrieNode {
        char c;
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(node);
        int level = 0;
        while (!q.isEmpty() && level <= word.length()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TrieNode curr = q.poll();
                if (level == word.length()) {
                    if (curr.isWord)
                        return true;
                    else
                        continue;
                }
                char ch = word.charAt(level);
                if (ch == '.') {
                    for (TrieNode n : curr.children) {
                        if (n != null) {
                            q.offer(n);
                        }
                    }
                } else if (curr.children[ch - 'a'] != null) {
                    q.offer(curr.children[ch - 'a']);
                }
            }
            level++;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */