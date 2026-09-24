package LeetCode994;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // grid: [[2,1,1],[1,1,0],[0,1,1]]
    // Where: 2 is rotten, 1 is fresh and 0 is empty

    // Min 0 is when we start
    // 1st minute: [[2,2,1],[2,1,0],[0,1,1]]
    // 2nd minute: [[2,2,2],[2,2,0],[0,1,1]]
    // 3rd minute: [[2,2,2],[2,2,0],[0,2,0]]
    // 4th minute: [[2,2,2],[2,2,0],[0,2,2]]
    // We return 4

    // In a case when we have fresh oranges we return -1

    // To solve we are going to use a min variable
    // Find a rotten orange, once we find one we start branching out
    // And we apply BFS to check all neighbors
    // Whenever we do a new BFS call we increase min counter
    // Once we found a bad orange we will add that to the queue
    // During the time we are trying to find bad oranges we will save good oranges
    // Once we add a bad orange to que queue, we reduce one element from good oranges
    // If we still have good oranges we return -1 else return min
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        // Count fresh and enqueue rotten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

        // BFS
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {

                        grid[x][y] = 2; // fresh to rotten
                        freshCount--;
                        rottenQueue.offer(new int[]{x,y});
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes - 1 : -1;
    }
}