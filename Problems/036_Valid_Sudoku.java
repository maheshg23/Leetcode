class Solution {
    public boolean isValidSudoku(char[][] board) {

        if (board == null)
            return false;
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch == '.')
                    continue;
                // check rows
                for (int k = i + 1; k < board.length; k++) {
                    if (ch == board[k][j]) {
                        return false;
                    }
                }
                // check Columns
                for (int k = j + 1; k < board[0].length; k++) {
                    if (ch == board[i][k]) {
                        return false;
                    }
                }
                // check SubSquares
                int a = i - i % 3;
                int b = j - j % 3;
                int k1 = 0, k2 = 0;
                for (int e = 0; e < 3; e++) {
                    for (int f = 0; f < 3; f++) {
                        if ((a + e == i && b + f == j) || (board[a + e][b + f] == '.'))
                            continue;
                        if (ch == board[a + e][b + f]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}