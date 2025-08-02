package LeetCode287;

/**
 * Solution for LeetCode 287
 *
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">LeetCode 287</a>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Find the intersection point of two pointers
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Find the entrance to the "cycle"
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + solution.findDuplicate(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + solution.findDuplicate(nums2));

        int[] nums3 = {1, 1};
        System.out.println("Duplicate: " + solution.findDuplicate(nums3));

        int[] nums4 = {1, 1, 2};
        System.out.println("Duplicate: " + solution.findDuplicate(nums4));
    }
}
