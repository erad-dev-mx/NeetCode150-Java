package LeetCode4;

/**
 * Solution for LeetCode 4
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">LeetCode 4</a>
 * Time complexity: O(Log min(N, M))
 * Space complexity: O(1)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while (start <= end) {
            int partX = (start + end) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if (xLeft <= yRight && yLeft <= xRight) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                } else {
                    return Math.max(xLeft, yLeft);
                }
            } else if (xLeft > yRight) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }
        }

        return 0;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1a = {1, 3};
        int[] nums2a = {2};
        System.out.println(solution.findMedianSortedArrays(nums1a, nums2a));

        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1b, nums2b));

        int[] nums1c = {0, 0};
        int[] nums2c = {0, 0};
        System.out.println(solution.findMedianSortedArrays(nums1c, nums2c));

        int[] nums1d = {};
        int[] nums2d = {1};
        System.out.println(solution.findMedianSortedArrays(nums1d, nums2d));

        int[] nums1e = {2};
        int[] nums2e = {};
        System.out.println(solution.findMedianSortedArrays(nums1e, nums2e));
    }
}