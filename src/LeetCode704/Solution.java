package LeetCode704;

/**
 * Solution for LeetCode 84
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">LeetCode 704</a>
 * Time complexity: O(Log N)
 * Space complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }
}