package LeetCode239.Review;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);

            // Add the max of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}

// This problem is about finding the maximum value in each sliding window of size k across the array. To solve it, we
// use a Deque that stores indices in decreasing order of their corresponding values. At each step, we remove indices
// that are out of the current window and also remove from the back any indices whose values are smaller than the
// current element, since they can no longer be maximum candidates. We then add the current index, and once the window
// is fully formed (i >= k - 1), the value at the front of the Deque represents the maximum for that window and is
// stored in the result array.