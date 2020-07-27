// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
// 79. Word Search

class Solution {
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    public boolean searchWord(int i, int j, int index, char[][] board, String word) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]
                || visited[i][j] == true) {
            return false;
        }
        visited[i][j] = true;
        if (searchWord(i + 1, j, index + 1, board, word) || searchWord(i - 1, j, index + 1, board, word)
                || searchWord(i, j + 1, index + 1, board, word) || searchWord(i, j - 1, index + 1, board, word)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
