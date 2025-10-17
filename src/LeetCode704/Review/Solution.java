package LeetCode704.Review;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

// My thoughts: We can use binary search when we have a sort array. If we have to find a number inside the array, we can
// use brute force iterating through the whole array until we found the target, with this approach the time complexity
// is o(n) so a better way is to use binary search, basically we will compare target with the mid-element, if is greater
// than the target, we will decrease the right pointer (end pointer), in other case, we will increase left pointer to
// have a new beginning.