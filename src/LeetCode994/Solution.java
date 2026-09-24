package LeetCode994;

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
    // And we apply BFS to check all neighboors
    // Whenever we do a new BFS call we increase min counter
    // Once we found a bad orange we will add that to the queue
    // During the time we are trying to find bad oranges we will save good oranges
    // Once we add a bad orange to que queue, we reduce one element from good oranges
    // If we still have good oranges we return -1 else return min
    public int orangesRotting(int[][] grid) {
        
    }
}