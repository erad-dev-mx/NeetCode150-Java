package LeetCode39;

import java.util.List;

class Solution {
    // Candidate: (2,5,6); Targer: 8
    // ((2,2,2,2), (2,6))
    // How to solve?
    // Use a kind of tree validating if SUM < TARGET
    // If is GREATER is not necessary to keep searching
    // Start [2] -> [2,2] -> [2,2,2] -> [2,2,2,2] (== 8, ANS!)
    // Backtrack to [2,2], try next: [2,2,5] (> 8, STOP)
    // Backtrack to [2], try next: [2,6] (== 8, ANS!)
    // Start [5] -> [5,5] (> 8, STOP).
    // Start [6] -> [6,6] (> 8, STOP).
    // After check all posibilities within 2 now we move to 5 and then 6
    // In each new value, we check less than the prev because we do not repeat validations
    // In last exaple when we are in 6, the only posible combination is (6,6)
    // Basically, we will use backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    }
}