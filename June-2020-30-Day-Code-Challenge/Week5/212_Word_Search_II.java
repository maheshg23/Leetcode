// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
// 212. Word Search II

class Solution {
    boolean visited[][];
    TrieNode root = new TrieNode();

    public class TrieNode {
        boolean isWord = false;
        TrieNode[] child = new TrieNode[26];
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.child[ch - 'a'] == null)
                    node.child[ch - 'a'] = new TrieNode();
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = buildTrie(words);
        List<String> res = new ArrayList<>();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    searchWord(i, j, board, "", root, res);
                }
            }
        }
        return res;
    }

    public void searchWord(int i, int j, char[][] board, String word, TrieNode node, List<String> res) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || node.child[board[i][j] - 'a'] == null
                || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if (node.isWord) {
            res.add(word + board[i][j]);
            node.isWord = false;
        }
        searchWord(i + 1, j, board, word + board[i][j], node, res);
        searchWord(i - 1, j, board, word + board[i][j], node, res);
        searchWord(i, j + 1, board, word + board[i][j], node, res);
        searchWord(i, j - 1, board, word + board[i][j], node, res);
        visited[i][j] = false;
    }
}