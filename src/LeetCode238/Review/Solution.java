package LeetCode238.Review;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        int pre = 1, pos = 1;

        for (int i = 0; i < result.length; i++) {
            result[i] = pre;
            pre = nums[i] * pre;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * pos;
            pos = pos * nums[i];
        }

        return result;
    }
}