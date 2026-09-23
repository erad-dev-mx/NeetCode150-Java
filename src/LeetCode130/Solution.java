package LeetCode130;

class Solution {
    // Each 'O' should be surrounded by 'X' in four directions (top, bottom, left and right)
    // If that is true we flip 'O' to 'X'

    // We will start traversing in the edges and check if exists any 'O'
    // If we found we will start our DFS
    // | X | X | X | X |
    // | X | X | O | X |
    // | X | O | X | O |
    // | X | O | X | X |
    // We will found two 'O', so in other board we will mark that as special char
    // Now we start moving inside using DFS
    // We found a new 'O' from the bottom
    // Now, simply convert special chars to 'X' and we will keep the surrounded in the original value
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark as visited
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}