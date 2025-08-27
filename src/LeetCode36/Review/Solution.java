package LeetCode36.Review;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxs[i] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                // Checking row
                if (rows[r].contains(val)) return false;
                rows[r].add(val);

                // Checking column
                if (cols[c].contains(val)) return false;
                cols[c].add(val);

                // Checking box
                int boxNumber = (r / 3) * 3 + c / 3;
                if (boxs[boxNumber].contains(val)) return false;
                boxs[boxNumber].add(val);
            }
        }

        return true;
    }
}

// R/3 + 3 + C/3