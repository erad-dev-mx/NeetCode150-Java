package LeetCode167;

/**
 * Solution for LeetCode 167
 *
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">LeetCode 167</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a Two-Pointer technique
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[right] + numbers[left] > target) {
                right--;
            } else if (numbers[right] + numbers[left] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }
}
