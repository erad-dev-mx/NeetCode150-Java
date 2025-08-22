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

// My thoughts: This problem it is a bit difficult for me, so the first thing is to create a new array with the length
// of nums array. After that, we will fill the array with 1 in all positions. It is time to create two variables: pre
// and pos. Now we run through all array from left to right multiplying the previous values of current. Finally, we will
// run from right to left, multiplying the values that we have from the first run by pos variable, and we update pos
// similar to the first run.