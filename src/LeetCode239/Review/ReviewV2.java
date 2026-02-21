package LeetCode239.Review;

import java.util.Deque;
import java.util.LinkedList;

public class ReviewV2 {
    /*
    nums = [1, 3, -1, -3, 5, 3], k = 3
    Result array size: nums.length - k + 1 = 4

    i=0 | val=1  | dq=[0] (val:1)          | res=[]
    i=1 | val=3  | 3 > dq.last(1), dq=[1]  | res=[]
    i=2 | val=-1 | -1 < dq.last(3), dq=[1,2]| res=[3]  <-- Complete window [1,3,-1]
    i=3 | val=-3 | -3 < dq.last(-1),dq=[1,2,3]| res=[3,3]
    i=4 | val=5  | 5 > all, dq=[4]         | res=[3,3,5]
    i=5 | val=3  | 3 < dq.last(5), dq=[4,5]| res=[3,3,5,5]
    */

    // nums = [1, 2, 3], k=2
    // i=0: dq[0]
    // i=1: 2 > 1 -> dq[1], res[2]
    // i=2: 3 > 2 -> dq[2], res[2, 3]
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Remove indices that are out of the window
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Remove indices whose corresponding values are less than nums[i]
            }

            deque.offer(i); // Add current index to deque

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
