package LeetCode286;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // -1 means there is an obstacle => W
    // 0 means there is a gate => G
    // INF means there is empty room => E
    // | E | W | G | E |
    // | E | E | E | W |
    // | E | W | E | W |
    // | G | W | E | E |
    // This is going to be our answer
    // | 3 | W | G | 1 |
    // | 2 | 2 | 1 | W |
    // | 1 | W | 2 | W |
    // | G | W | 3 | 4 |
    // If there is no way to reach a G we turn that cell into INF

    // To solve if we keep iterating in every single E it could take a lot of time
    // It would be better to start from a certain point and then starting to branching
    // We will run through the matrix and get positions of Gs
    // From that Gs we start the branching
    // Since we can have multiple G pointing to a same E we will mark the number of distance
    // Why? In order to always have the smallest
    // We are using BFS + Queue

    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0}; // 4-directional (right, down, left, up)

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
