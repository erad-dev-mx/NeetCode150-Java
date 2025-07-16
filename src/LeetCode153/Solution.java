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

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Min: " + solution.findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Min: " + solution.findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Min: " + solution.findMin(nums3));

        int[] nums4 = {2, 1};
        System.out.println("Min: " + solution.findMin(nums4));

        int[] nums5 = {1};
        System.out.println("Min: " + solution.findMin(nums5));
    }
}