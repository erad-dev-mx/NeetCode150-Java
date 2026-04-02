package LeetCode33.Review;

public class ReviewV2 {
    // [3, 4, 5, 6, 7, 0, 1, 2]
    // Target = 0
    // L = 3, R = 2, M = 7 => L < M (First portion is sorted)
    // Target is not in first portion
    // L = 0, R = 2, M = 1
    // L == Target then we return answer
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
