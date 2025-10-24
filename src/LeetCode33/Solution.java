package LeetCode33;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}

// To solve the problem, we use binary search since the array is sorted but rotated. We calculate the middle. If it's
// equal to the target, return mid. If the left half (nums[left] <= nums[mid]) is sorted, check if the target lies
// between nums[left] and nums[mid]: If it does, move the right pointer to mid. Otherwise, move the left pointer to
// mid + 1. If the right half is sorted, apply the same logic symmetrically