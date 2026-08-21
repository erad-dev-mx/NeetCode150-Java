package LeetCode40;

import java.util.List;

class Solution {
    // [2,1,2,3,4], target = 5
    // [[4,1], [2,1,2],[3,2]]

    // In order to solve we can sort the given input array
    // Why? To avoid check values that are greater than target
    // Also because we can handle duplicates

    // [2,1,2,3,4]
    // [1,2,2,3,4]
    // Check all 1 combinations: ans = [1,2,2] => [[1,2,2],[1,4]]
    // Check all 2 combinations: ans = [1,2,2] => [[1,2,2],[1,4],[2,3]]
    // Ignore duplicate 2
    // Check all 3 combinations: ans = [1,2,2] => [[1,2,2],[1,4],[2,3]]
    // Check all 4 combinations: ans = [1,2,2] => [[1,2,2],[1,4],[2,3]]
    // In every new check we don't go to previous numbers.
    // E.G.: When check 3 we do not check neither 1 or 2s
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    }
}