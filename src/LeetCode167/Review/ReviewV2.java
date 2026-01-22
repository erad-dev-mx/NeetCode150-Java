package LeetCode167.Review;

public class ReviewV2 {
    // Two-pointers: left & right
    // If left + right > target, then decrease right
    // If left + right < target, then increase left

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }
}
