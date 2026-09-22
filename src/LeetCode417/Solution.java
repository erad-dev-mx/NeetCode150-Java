package LeetCode417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // We are on an island between Pacific and Atlantic Ocean
    // The Pacific ocean is at left and top sides
    // The Atlantic ocean is at right and bottom sides

    // Each cell has a height above sea level
    // Island receive a lot of rain
    // Water can flow to neighbor in top, bottom, left and right
    // But just, if height level is less or equal to current cell's height

    // We need to return coordinates with all cells that can reach to both oceans

    // A brute force is check in each one of the cells, but time complexity is O(m x n) ^ 2

    // We will create two grids of boolean values
    // One will contain cell that can reach to Pacific and another to Atlantic
    // At the end, we can intersect the cell that can reach to both oceans

    // For Pacific, all the elements at top and left are true by default
    // Now from those cells we are going to move inverse checking if value is greater
    // We will mark as true. If an element us true we don't check it again. O (n x m)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) return new ArrayList<>();

        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(i, 0, pacificReachable, heights);
            dfs(i, col - 1, atlanticReachable, heights);
        }

        for (int i = 0; i < col; i++) {
            dfs(0, i, pacificReachable, heights);
            dfs(row - 1, i, atlanticReachable, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable, int[][] heights) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        reachable[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            if (reachable[newRow][newCol]) continue;

            if (heights[newRow][newCol] < heights[row][col]) continue;

            dfs(newRow, newCol, reachable, heights);
        }
    }
}