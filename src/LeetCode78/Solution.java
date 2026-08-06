package LeetCode78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // [1,2,3]
    // At every single step, we are going to make a decision whether we include that element or not
    // []           [1]             [2]         [3]
    //              [1,2] [1,3]     [2,3]
    //              [1,2,3]
    // We do this recursively + backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}