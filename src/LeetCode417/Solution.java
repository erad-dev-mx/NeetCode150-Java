package LeetCode417;

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
        
    }
}