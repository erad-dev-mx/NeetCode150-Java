package LeetCode153.Review;

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums[0];

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            if (nums[left] < nums[right]) {
                answer = Math.min(answer, nums[left]);
            }
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

// My thoughts: To solve the problem in O(log n) time we will use a binary search but with a twist. Since the array is
// rotated x times, we will need to evaluate while left is less or equal to right we can iterate through all the array
// validating which of the left or right values are less than the other to keep track of the minimum value. In the same
// iteration we will get the mid, and also we will compare which one is lesser if left or mid. To move our pointers, we
// will check if left value is less than equal to mid we will move our left pointer (we will ignore the first part of
// the array), else we will update our right pointer (we will ignore the second part of the array).