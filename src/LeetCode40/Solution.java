package LeetCode40;

import java.util.ArrayList;
import java.util.Arrays;
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
    // E.G.: When check 3 we do not check neither 1 nor 2s
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) break;

            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}