package LeetCode90;

import java.util.List;

class Solution {
    // [1,2] this will contain 2 ^ n possible subsets
    // [][1][2][1,2]
    // [1,2,2] => [][1][2][2][1,2][1,2] => whenever we have duplicates we need to remove them
    // [][1][2][1,2]

    // We will use backtracking but first we will order our array
    // [1,2,2]
    // []
    // [1] - [1,2], [1,2] THIS IS NOT VALID! - [1,2,2]
    // [2] - [2,2] -
    // [2] THIS IS NOT VALID!
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
    }
}