package LeetCode695;

// We are going to iterate in one single direction, if we found 1 we will check
// all the neighbors, once we exhaust every single neighbor we can determine the area
// and also check the max so far.

// [0,0,1,0,0,0,0,1,0,0,0,0,0]
// [0,0,0,0,0,0,0,1,1,1,0,0,0]
// [0,1,1,0,1,0,0,0,0,0,0,0,0]
// [0,1,0,0,1,1,0,0,1,0,1,0,0]
// [0,1,0,0,1,1,0,0,1,1,1,0,0]
// [0,0,0,0,0,0,0,0,0,0,1,0,0]
// [0,0,0,0,0,0,0,1,1,1,0,0,0]
// [0,0,0,0,0,0,0,1,1,0,0,0,0]

// First we visited the first island (1), it is important to check as visited
// Why? To avoid infinite loops and recount a determine value
// Our next max area is going to be 4, then we find another 4, and so on

// We are using DFS
// Time: O(n x m), space: O(n x m)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
    }
}