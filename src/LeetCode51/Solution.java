package LeetCode51;

import java.util.ArrayList;
import java.util.List;

// Basically we will receive an m x n board when x number of queens
// A queen can move up, down, right, left and diagonal
// We will return all posible combination in which the queens cannot attack others

// We will do recursive backtracking to determine if there is a good path or not
// First, we need to keep track of the path
// Base case and recursion function
// Method: check valid path
// Method: generate the board
// Time complexity is terrible: 2^n^2
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(board, 0, res);
        return res;
    }

    private void backtrack(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, res);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            res.add(row);
        }
        return res;
    }
}