package LeetCode1.Review;

import java.util.HashMap;
import java.util.Map;

public class ReviewV2 {
    // nums = [11,15,2,7], target = 9
    // HashMap -> {{11, 0}, {15, 1}, {2, 2}, {}}
    // complement = 9 - 7 = 2 => [2, 3]
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement),i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
