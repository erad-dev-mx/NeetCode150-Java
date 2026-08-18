package LeetCode46;

import java.util.List;

class Solution {
    // [1,2]: [[1,2],[2,1]]
    // [1,2,3]: We can do n factorial permutations
    // This is going to be a desition making algorithm
    // We will use backtracking
    // Also we are goign to need an array of booleans to track if we have a specific value
    // inside our permutation
    // [1,2,3]
    // currentVal: 1,2,3, used: true, true, true, ans = [1,2,3]
    // currentVal: 1,3,2, used: true, true, true, ans = [1,3,2]
    // Then we go with to 2, until we reach 3
    public List<List<Integer>> permute(int[] nums) {
        
    }
}