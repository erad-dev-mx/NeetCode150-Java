package LeetCode287.Review;

// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// Thoughts: To solve this problem we use the tortoise and hare algorithm, what that means? we will move slow pointer
// one a time, and fast pointer twice a time. When they are equal that means we are in a cycle. So we will move slow to
// 0 position, and we will move both the pointers one a time until they find themselves. This is the way to solve the
// problem avoiding an extra data structure and without modifying the integer arrays.