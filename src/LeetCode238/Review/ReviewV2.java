package LeetCode238.Review;

import java.util.Arrays;

// We create an array with the same length.
// We fill all elements with 1 > We use two vars (pre = 1 and pos = 1)
// We run from left to right (forward)
// [{1, 1*1}, {1, 2*1}, {2, 2*3}, {6, 4*6}] = [1, 1, 2, 6]
// We run from right to left (backward)
// [{24, 24*1},{12, 12*2},{8, 4*3}, {6, 1*4}]

public class ReviewV2 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int pre = 1;
        int pos = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre = nums[i] * pre;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * pos;
            pos = nums[i] * pos;
        }

        return result;
    }
}
