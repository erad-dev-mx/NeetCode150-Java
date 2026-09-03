package LeetCode200;

class Solution {
    // 1 is land
    // 0 is water
    // All the outside values are water
    // An island can be if surrounded by water up, down, right a left

    // When we find a 1 we need to check how many 1s are connected with each other
    // Basically, find sets of 1s

    // | 0 | 0 | 0 | 0 | 0 | 0 |
    // | 0 |*1*|*1*| 0 |*1*| 0 |
    // | 0 |*1*| 0 | 0 |*1*| 0 |
    // | 0 | 0 | 0 | 0 |*1*| 0 |
    // | 0 |*1*|*1*| 0 | 0 |*1*|

    // Start traversing through first row, then we will find an element is col 2
    // At that moment, we are going to call a function to iterate over all adjacent cell that are
    // connected with that 1 until we exhaust all the sets
    // We will update our number of island and mark the first 1 as 0 and check it neighbors. If we
    // found 1s we will change to zero and check its neighbors, then go back to first 1 (that it is 0)
    // and check other neighbors.
    // When we found other 1 we do the same process, updating number of islands.
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }
}