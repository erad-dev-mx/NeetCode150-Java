package LeetCode153.Review;

public class ReviewV2 {
    // nums = [2, 3, 4, 5, 6, 7, 8, 0, 1]
    // l = 2, r = 1, m = 6 => 2 <= 6 (left side sorted), search right. ans = 2
    // nums = [7, 8, 0, 1]
    // l = 7, r = 1, m = 8 => 7 <= 8 (left side sorted), search right. ans = 2
    // nums = [0, 1]
    // l = 0, r = 1, m = 0 => 0 < 1 (range is sorted), ans = min(2, 0) = 0

    // nums = [7, 8, 0, 1, 2, 3, 4, 5, 6]
    // l = 7, r = 6, m = 2 => 7 > 2 (pivot is on the left), search left. ans = 2
    // nums = [7, 8, 0, 1
    // l = 7, r = 1, m = 8 => 7 <= 8 (left side sorted), search right. ans = 2
    // nums = [0, 1]
    // l = 0, r = 1, m = 0 => 0 < 1 (range is sorted), ans = min(2, 0) = 0
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums[0];

        if (nums.length == 1) return nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) answer = Math.min(answer, nums[left]);

            int mid = left + (right - left) / 2;
            answer = Math.min(answer, nums[mid]);
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
