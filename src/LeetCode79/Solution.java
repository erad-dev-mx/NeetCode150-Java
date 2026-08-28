package LeetCode79;

// [P,E,S,P,I]
// [T,S,M,A,Y]
// [E,P,I,D,B]
// [R,B,R,E,O]
// word = SPIDER
// We will start in m1 x n1 and there we will check if "S" is present
// If we found we will change the value temporary as a "#".
// Keeping moving we found "SPI" but since "I" doesn't have a neighbor we
// backtrack removing "#" symbols and we move forward trying to find the word.
// We are able to reach to thw word hence we return true.
// Time : O(N < 3^L), Space = O(L)
class Solution {
    public char[][] board;
    public int rows;
    public int cols;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) return true;

        if (row < 0 || row >= rows || col < 0 || col >= cols || this. board[row][col] != word.charAt(index)) return false;

        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        this.board[row][col] = '#';
        boolean ret = false;

        for (int d = 0; d < 4; d++) {
            ret = backtrack(row + rowDir[d], col + colDir[d], word, index + 1);
            if (ret) break; // If we found a good neighbor
        }
        board[row][col] = word.charAt(index);
        return ret;
    }
}
