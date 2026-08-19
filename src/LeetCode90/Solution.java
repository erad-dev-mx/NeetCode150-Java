package LeetCode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // [1,2] this will contain 2 ^ n possible subsets
    // [][1][2][1,2]
    // [1,2,2] => [][1][2][2][1,2][1,2] => whenever we have duplicates we need to remove them
    // [][1][2][1,2]

    // We will use backtracking, but first we will order our array
    // Why? In order to compare if there are similar entries (handle similar)
    // [1,2,2]
    // []
    // [1] - [1,2], [1,2] THIS IS NOT VALID! - [1,2,2]
    // [2] - [2,2] -
    // [2] THIS IS NOT VALID!
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}