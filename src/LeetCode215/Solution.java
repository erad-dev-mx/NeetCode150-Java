package LeetCode215;

import java.util.PriorityQueue;

class Solution {
    // Brute Force
    // We iterate through the entire array in order to find the max one
    // Then, we find 2 max and so on until K max value

    // We cannot use sorting

    // PriorityQueue is going to be a better approach
    // We will use a MinHeap (ascending order) with K size length
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}