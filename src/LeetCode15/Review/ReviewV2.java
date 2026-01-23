package LeetCode15.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewV2 {
    // nums = [-1,0,1,2,-1,-4] => [-1,-1,0,1,2,4]
    // We start in -1 and run with the other values [-1,0,1,2,4] to find a 0
    // If we don't find a 0 we move to the next one, validating that our new pivot is not equal to prev.

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total > 0) {
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
