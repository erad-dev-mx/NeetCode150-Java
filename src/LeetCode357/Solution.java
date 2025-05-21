package LeetCode357;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/description/
// Time Complexity: O(N log K)
// Space Complexity: O(N)
// This approach uses a min-heap to keep track of the top k frequent elements.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}