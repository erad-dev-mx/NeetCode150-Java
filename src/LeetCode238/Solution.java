package LeetCode238;

import java.util.Arrays;

/**
 * Solution for LeetCode 238
 *
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">LeetCode 238</a>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * This approach a two-pass algorithm to calculate the product of all elements except the current one.
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        int pre = 1, post = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre = nums[i] * pre;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * post;
            post = post * nums[i];
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums1))); // Expected output: [24, 12, 8, 6]

        int[] nums2 = {5, 6, 7};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums2))); // Expected output: [42, 35, 30]

        int[] nums3 = {1};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums3))); // Expected output: [1]
    }
}
