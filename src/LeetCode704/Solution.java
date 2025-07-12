package LeetCode704;

/**
 * Solution for LeetCode 704
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">LeetCode 704</a>
 * Time complexity: O(Log N)
 * Space complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        System.out.println("Index: " + solution.search(nums1, 9));

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        System.out.println("Index: " + solution.search(nums2, 2));

        int[] nums3 = {1, 3, 5, 7, 9};
        System.out.println("Index: " + solution.search(nums3, 1));

        int[] nums4 = {1, 3, 5, 7, 9};
        System.out.println("Index: " + solution.search(nums4, 9));

        int[] nums5 = {1};
        System.out.println("Index: " + solution.search(nums5, 1));
    }
}