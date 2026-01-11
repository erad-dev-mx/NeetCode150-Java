package LeetCode347.Review;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReviewV2 {

    public int[] topKFrequent(int[] nums, int k) {
        // [1,1,1,2,2,3], k = 2
        // Top 2 => 1,3 - 2,2 - 3,1
        // PriorityQueue => [1, 2]
        Map<Integer, Integer> count = new HashMap<>();
        int[] ans = new int[k];
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
