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