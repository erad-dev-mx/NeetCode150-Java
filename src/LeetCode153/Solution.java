package LeetCode153;

/**
 * Solution for LeetCode 153
 *
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">LeetCode 153</a>
 * Time complexity: O(Log(N))
 * Space complexity: O(1)
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        if (nums.length == 1) {
            return ans;
        }

        while (left <= right) {
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
            }

            int mid = left + (right - left) / 2;
            ans = Math.min(ans, nums[mid]);
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}