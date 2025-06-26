package LeetCode239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution for LeetCode 239
 *
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">LeetCode 239</a>
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 */


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Removing indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Removing indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Adding the current index to the deque
            deque.offer(i);

            // Adding the maximum element of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.print("Result 1: ");
        printArray(result1);

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.print("Result 2: ");
        printArray(result2);

        int[] nums3 = {9, 11};
        int k3 = 2;
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.print("Result 3: ");
        printArray(result3);

        int[] nums4 = {4, -2};
        int k4 = 2;
        int[] result4 = solution.maxSlidingWindow(nums4, k4);
        System.out.print("Result 4: ");
        printArray(result4);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}