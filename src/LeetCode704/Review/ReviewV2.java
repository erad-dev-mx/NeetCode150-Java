package LeetCode704.Review;

public class ReviewV2 {
    // O(log n)
    // array of integers sorted in ascendig order
    // Two variables: left, right
    // Then, we get the middle value
    // We will check if middle is greater than target
    // --- Update the value of right pointer
    // --- Update the value of left pointer
    // If we don't found an answer, then return -1
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
