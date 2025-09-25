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

// My thoughts, this is a sliding window problem, we need to return the max value of each window from the very left to
// the very right of the array. To solve we will use a Deque, we will save the values from the window but when we
// already have values there we will evaluate if the index value is greater if it is we will add to our deque, but if is
// not we won't do it. This is to compare the new value when we move forward with the previous ones. At the end, to the
// answer we will add the greater value of the Deque.