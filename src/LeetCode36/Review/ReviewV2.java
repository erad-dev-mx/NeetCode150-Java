package LeetCode36.Review;

import java.util.HashSet;

public class ReviewV2 {
    // We can use HashSet for each (rows, cols and sub-boxes)
    // We create 27 HashSets for each row, col and sub-box
    // Run the Sudoku in each cell, using loops. If character is equal to “.” we skip, then we check col, row
    // and sub-box.
    // To validate sub-box we use this formula to know in which square we are validating
    // 0 | 1 | 2
    // 3 | 4 | 5
    // 6 | 7 | 8
    // int boxNumber = (r / 3) * 3 + c / 3 // Example: (r=4, c=7) => (4/3) * 3 + 7/3 = 1 * 3 + 2 = 3 + 2 = 5

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            cols[i] = new HashSet<Character>();
            rows[i] = new HashSet<Character>();
            boxs[i] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                if (rows[r].contains(val)) return false;
                rows[r].add(val);

                if (cols[c].contains(val)) return false;
                cols[c].add(val);

                int boxNumber = (r / 3) * 3 + c / 3;
                if(boxs[boxNumber].contains(val)) return false;
                boxs[boxNumber].add(val);
            }
        }

        return true;
    }

}
