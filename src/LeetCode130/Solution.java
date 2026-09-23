package LeetCode130;

class Solution {
    // Each 'O' should be surrounded by 'X' in four directions (top, bottom, left and right)
    // If that is true we flip 'O' to 'X'

    // We will start traversing in the edges and check if exists any 'O'
    // If we found we will start our DFS
    // | X | X | X | X |
    // | X | X | O | X |
    // | X | O | X | O |
    // | X | O | X | X |
    // We will found two 'O', so in other board we will mark that as special char
    // Now we start moving inside using DFS
    // We found a new 'O' from the bottom
    // Now, simply convert special chars to 'X' and we will keep the surrounded in the original value
    public void solve(char[][] board) {
        
    }
}