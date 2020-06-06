// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
// No. 208 https://leetcode.com/problems/implement-trie-prefix-tree/ 

class Trie {

    /** Initialize your data structure here. */
    private TrieNode root;
    static class TrieNode{
        char c ;
        Map<Character,TrieNode> child = new HashMap<>();
        boolean isWord;
    }
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if(!node.child.containsKey(ch)) {
                node.child.put(ch, new TrieNode());
            }
            node = node.child.get(ch);
        }
        node.isWord = true;
    
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if(!node.child.containsKey(ch)) {
                return false;
            }
             node = node.child.get(ch);
        }
        
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            if(!node.child.containsKey(ch)) {
                return false;
            }
            node = node.child.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */