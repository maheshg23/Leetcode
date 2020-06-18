// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
// 130. Surrounded Regions

class Solution {
    public void solve(char[][] board) {

        if (board.length <= 2 || board[0].length <= 2)
            return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1)) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}

// Efficient solution
class Solution {
    public void solve(char[][] board) {

        if (board.length <= 2 || board[0].length <= 2)
            return;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O')
                dfs(board, i, board[0].length - 1);
        }

        for (int i = 1; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[board.length - 1][i] == 'O')
                dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}