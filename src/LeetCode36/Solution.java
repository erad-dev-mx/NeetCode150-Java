package LeetCode36;

import java.util.HashSet;

/**
 * Solution for LeetCode 36: Valid Sudoku
 *
 * @see <a href="https://leetcode.com/problems/valid-sudoku/">LeetCode 36</a>
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * This approach uses hashing to track the numbers seen in each row, column, and 3x3 box.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int r = 0; r < 9; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                // Checking row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Checking column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Checking box
                int boxNumber = (r / 3) * 3 + c / 3;
                if (boxes[boxNumber].contains(val)) {
                    return false;
                }
                boxes[boxNumber].add(val);
            }
        }

        return true;
    }
}
