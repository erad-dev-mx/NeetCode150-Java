package LeetCode15.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));

                while (left < right && nums[left] == nums[left - 1]) {
                    ++left;
                }
            }
        }
    }
}

// My thoughts: The approach to solve this problem is the next one, first we will sort our array of ints. Then we will
// use a two-pointer technique, if the sum of the two pointer is greater than our sum value we will decrease right
// pointer else, we will increase left pointer. If we found an expected value we can add to our answer the value. This
// problem has a O (log n) + O (n squared) time complexity.